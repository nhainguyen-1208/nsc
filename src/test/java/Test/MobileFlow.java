package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Actions.BillingMobileAction;
import Actions.CartActionMobileAction;
import Actions.OrderReviewMobileAction;
import Actions.ProductPageMobile;
import Actions.ShippingMobileAction;
import Actions.ThankYouPage;

public class MobileFlow {
    public WebDriver dr;

    @BeforeTest
    public void setupMobileChrome() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 414);
        deviceMetrics.put("height", 736);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent",
                "Mozilla/5.0 (Linux; Android 5.0;" + "SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) "
                        + "Chrome/90.0.4430.212 Mobile Safari/537.36");

        // Set custom options for Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        // Initialize ChromeDriver
        dr = new ChromeDriver(chromeOptions);
    }

    @Test
    public void checkoutAsGuestFlowMobile() throws InterruptedException {

        float actual_subtotal;
        float cart_subtotal;
        float subtotal_shipping_page;
        float shipping_method_subtotal;
        float fedex_shipping_cost;
        float subtotal_thankyou;
        float tax_thankyou;
        float discount_thankyou;
        float shipping_thankyou;
        float order_total_thankyou;

//		Variable on Order review page
        float subtotal_cart_summary;
        float shipping_cart_summary;
        float tax_cart_summary;
        float total_cart_summary;
        String shipping_method_name;
        float shipping_cost_order_review;
        float subtotal_order_summary;
        float shipping_order_summary;
        float tax_order_summary;
        float total_order_summary;

        ProductPageMobile product_page_mobile = new ProductPageMobile(dr);
        CartActionMobileAction cart_mobile = new CartActionMobileAction(dr);
        ShippingMobileAction shipping_mobile_page = new ShippingMobileAction(dr);
        BillingMobileAction billing_mobile_page = new BillingMobileAction(dr);
        OrderReviewMobileAction order_review_page = new OrderReviewMobileAction(dr);
        ThankYouPage thank_you_page = new ThankYouPage(dr);

//		Add product to cart & get actual_subtotal from addProductToCart() function
        actual_subtotal = product_page_mobile.addProductToCart();

//		Go to cart page
        cart_subtotal = cart_mobile.ShoppingCartPage();
        Assert.assertEquals(actual_subtotal, cart_subtotal);
        System.out.println("Verify shopping cart: Passed");

//		Go to shipping address page
        cart_mobile.checkoutAsGuest();

//		Verify subtotal in shipping page is correct
        subtotal_shipping_page = shipping_mobile_page.getSubtotalinShippingMethod();
        Assert.assertEquals(actual_subtotal, subtotal_shipping_page);
        System.out.println("Subtotal on shipping page is correct");

//		Fill contact & shipping info
        shipping_mobile_page.shippingAddressGuest();

//		Verify that shipping cost is correct
        fedex_shipping_cost = shipping_mobile_page.fedExGroundShippingCost();
        System.out.println("FedExGround is selected as default & cost is correct");

//		Tick on checkbox same as shipping address
        shipping_mobile_page.sameAsShippingAddress();

//		Go to billing page
        shipping_mobile_page.goToBillingPageMobile();

//		Select & input credit card
        billing_mobile_page.paymentCreditCardMobile();
        billing_mobile_page.goToOrderReviewPage();

//		Verify cart summary on order review page
        order_review_page.openCartSummary();
        subtotal_cart_summary = order_review_page.subtotalCartSummary();
        shipping_cart_summary = order_review_page.shippingCartSummary();
        tax_cart_summary = order_review_page.taxCartSummary();
        total_cart_summary = order_review_page.totalCartSummary();
        Assert.assertEquals(total_cart_summary, subtotal_cart_summary + shipping_cart_summary + tax_cart_summary);
        System.out.println("Verify cart summary on order review page: Passed");

//		Verify shipping method on order review page
        shipping_method_name = order_review_page.shippingMethodName();
        assertEquals(true, shipping_method_name.contains("fedex-ground"));
        shipping_cost_order_review = order_review_page.shippingCost();
//		Compare shipping cost on order review & shipping page
        Assert.assertEquals(shipping_cost_order_review, fedex_shipping_cost);
        System.out.println("Verify Shipping Method on order review page: Passed");

//		Verify Order Summary Info
        subtotal_order_summary = order_review_page.subtotalOrderSummary();
        shipping_order_summary = order_review_page.shippingOrderSummary();
        tax_order_summary = order_review_page.taxOrderSummary();
        total_order_summary = order_review_page.totalOrderSummary();
        Assert.assertEquals(total_order_summary, subtotal_order_summary + shipping_order_summary + tax_order_summary);
//		Compare total on cart summary & on order summary
        Assert.assertEquals(total_cart_summary, total_order_summary);
        System.out.println("Verify order summary on order review page: Passed");

//		Place order
        order_review_page.placeOrder();

//		Verify thank you page
        thank_you_page.verifyPageTitleMobile();
        subtotal_thankyou = thank_you_page.SubtotalMobile();

//		Verify Create An Account Button enable
        assertTrue(thank_you_page.verifyCreateAccountButtonExistedMobile());
        System.out.println("Create account button is displayed & enabled");

        Assert.assertEquals(actual_subtotal, subtotal_thankyou);
        shipping_thankyou = thank_you_page.ShippingMobile();

        Assert.assertEquals(fedex_shipping_cost, shipping_thankyou);
        tax_thankyou = thank_you_page.TaxMobile();

        Assert.assertEquals(tax_thankyou, tax_order_summary);
        order_total_thankyou = thank_you_page.TotalOrderMobile();

        Assert.assertEquals(order_total_thankyou, (subtotal_thankyou + tax_thankyou + shipping_thankyou));
        System.out.println("Verify thank you page: Passed");

    }

    @AfterTest
    public void close() {
//		dr.close();
        dr.quit();
    }

}
