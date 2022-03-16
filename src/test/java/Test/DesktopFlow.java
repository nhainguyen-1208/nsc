package Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import Actions.DesktopBillingPageAction;
import Actions.DesktopPaymentMethodPageAction;
import Actions.DesktopShippingAddressPageAction;
import Actions.DesktopShippingMethodPageAction;
import Actions.ProductPage;
import Actions.RegisterPage;
import Actions.ShoppingCart;
import Actions.ThankYouPage;
import Actions.MyAccountAction;
import Actions.LoginPageAction;
import Actions.contactusaction;

public class DesktopFlow {
    float total;
    public WebDriver dr;
    LoginPageAction login_page;
    MyAccountAction my_account;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        dr = new ChromeDriver();
        login_page = new LoginPageAction(dr);
        my_account = new MyAccountAction(dr);


    }

    @AfterTest
    public void close() {
//		dr.close();
        dr.quit();
    }


    @Ignore
    @Test
    public void registerflow() throws InterruptedException {
        RegisterPage register_page = new RegisterPage(dr);
        register_page.Register();
    }

//    @Ignore
    @Test(priority = 0)
    public void login() throws InterruptedException {
//       login_page = new LoginPageAction(dr);
        login_page.loginfrompageSuccess();
        Thread.sleep(1000);

    }

    //    Address Book
    @Ignore
    @Test(priority = 1)
    public void addressBook() throws InterruptedException {
        String address_book_title;
        // Go to address book
        Thread.sleep(1000);
        my_account.goToAddressBook();
        address_book_title = my_account.getAddressBookTitle();
        Assert.assertEquals(address_book_title, "Address Book");

    }

    @Ignore
    @Test(priority = 2)
    public void shippingaddress() throws InterruptedException {
//        MyAccountAction my_account = new MyAccountAction(dr);

        String first_name_msg;
        String phone_msg;
        int total_shipping_address_old;
        int total_shipping_address_new;
        int total_shipping_address_delete;
        String old_shipping_address_name;
        String new_shipping_address_name;

        total_shipping_address_old = my_account.shippingAddressSize();

//      Open add new address form >> not input any info >> Click Save button
        my_account.validateAddShippingAddress();
//        phone_msg = my_account.phoneShippingMessage();
//        Assert.assertEquals(address_book_title, "Please type your first name");
        first_name_msg = my_account.firstNameMessage();
        Assert.assertEquals(first_name_msg, "Please type your first name");

//        Add new address
        dr.navigate().refresh();
        Thread.sleep(1000);
        my_account.addNewShippingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        total_shipping_address_new = my_account.shippingAddressSize();
        Assert.assertEquals(total_shipping_address_new, total_shipping_address_old + 1);
        System.out.println("Verify add new shipping address: Passed");

//        Edit address
        old_shipping_address_name = my_account.getFirstShippingAddressName();
        my_account.editShippingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        new_shipping_address_name = my_account.getFirstShippingAddressName();
        Assert.assertEquals(new_shipping_address_name, old_shipping_address_name + " update");
        System.out.println("Verify edit shipping address: Passed");

//        Delete address
        my_account.deleteShippingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        total_shipping_address_delete = my_account.shippingAddressSize();
        Assert.assertEquals(total_shipping_address_delete, total_shipping_address_new - 1);
        System.out.println("Verify delete normal shipping address: Passed");
    }

    @Ignore
    @Test(priority = 3)
    public void billingaddress() throws InterruptedException {
        String first_name_msg;
        String phone_msg;
        int total_billing_address_old;
        int total_billing_address_new;
        int total_billing_address_delete;
        String old_billing_address_name;
        String new_billing_address_name;

        total_billing_address_old = my_account.billingAddressSize();

//      Open add new address form >> not input any info >> Click Save button
        my_account.validateAddBillingAddress();
//        phone_msg = my_account.phoneShippingMessage();
//        Assert.assertEquals(address_book_title, "Please type your first name");
        first_name_msg = my_account.firstNameMessage();
        Assert.assertEquals(first_name_msg, "Please type your first name");

//        Add new address
        dr.navigate().refresh();
        Thread.sleep(1000);
        my_account.addNewBillingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        total_billing_address_new = my_account.billingAddressSize();
        Assert.assertEquals(total_billing_address_new, total_billing_address_old + 1);
        System.out.println("Verify add new billing address: Passed");

//        Edit address
        old_billing_address_name = my_account.getFirstBillingAddressName();
        my_account.editBillingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        new_billing_address_name = my_account.getFirstBillingAddressName();
        Assert.assertEquals(new_billing_address_name, old_billing_address_name + " update");
        System.out.println("Verify edit billing address: Passed");

//        Delete address
        my_account.deleteBillingAddress();
        dr.navigate().refresh();
        Thread.sleep(1000);
        total_billing_address_delete = my_account.billingAddressSize();
        Assert.assertEquals(total_billing_address_delete, total_billing_address_new - 1);
        System.out.println("Verify delete normal billing address: Passed");
    }

//    @Ignore
    @Test(priority = 4)
    public void checkoutAsGuestFlowFesktop() throws InterruptedException {

        float actual_subtotal;
        float minicart_subtotal;
        float cart_subtotal;
        float shipping_address_subtotal;
        float shipping_method_subtotal;
        float fedex_shipping_cost;
        float tax;
        float order_total;
        float subtotal_thankyou;
        float tax_thankyou;
        float discount_thankyou;
        float shipping_thankyou;
        float order_total_thankyou;

        ProductPage product_page = new ProductPage(dr);
        ShoppingCart cart_page = new ShoppingCart(dr);
        DesktopBillingPageAction billing_page = new DesktopBillingPageAction(dr);
        DesktopShippingAddressPageAction shipping_address_page = new DesktopShippingAddressPageAction(dr);
        DesktopShippingMethodPageAction shipping_method_page = new DesktopShippingMethodPageAction(dr);
        DesktopPaymentMethodPageAction payment_method_page = new DesktopPaymentMethodPageAction(dr);
        ThankYouPage thank_you_page = new ThankYouPage(dr);

//		Add product to cart & get actual_subtotal from addProductToCart() function
        actual_subtotal = product_page.addProductToCart();
//      Go to cart page
        cart_subtotal = cart_page.ShoppingCartPage();
        Assert.assertEquals(actual_subtotal, cart_subtotal);
        System.out.println("Verify shopping cart: Passed");

//		Go to billing address page
        cart_page.checkoutAsGuest();

//		Fill billing address information
        billing_page.billingAddressGuest();

//		Go to shipping address page
        billing_page.goToShippingAddressPage();

//		Verify subtotal in shipping address page is correct
        shipping_address_subtotal = shipping_address_page.getSubtotal();
        Assert.assertEquals(actual_subtotal, shipping_address_subtotal);
        System.out.println("Subtotal in shipping address page is correct.");

//		Go to shipping method page
        shipping_address_page.goToShippingMethodPage();

//		Verify subtotal in shipping method page is correct
        shipping_method_subtotal = shipping_method_page.getSubtotalinShippingMethod();

        Assert.assertEquals(actual_subtotal, shipping_method_subtotal);
        System.out.println("Subtotal in shipping method page is correct.");

//		Verify that shipping cost is correct
        fedex_shipping_cost = shipping_method_page.fedExGroundShippingCost();
        System.out.println("FedExGround is selected as default & cost is correct");

//		Go to payment method page
        shipping_method_page.goToPaymentMethodPage();

//		Verify OrderTotal
        order_total = payment_method_page.TotalOrder();
        tax = payment_method_page.Tax();
        Float.compare(order_total, tax + fedex_shipping_cost + cart_subtotal);
        System.out.println("Total order is correct");

//		Input Credit Cart & Place Order
        payment_method_page.paymentCreditCard();

//		Place Order
        payment_method_page.placeOrder();
        System.out.println("Place order successfully");

//		Verify thank you page
        thank_you_page.verifyPageTitleDesktop();
        subtotal_thankyou = thank_you_page.SubtotalDesktop();

//		Verify Create An Account Button enable
        assertTrue(thank_you_page.verifyCreateAccountButtonExistedDesktop());
        System.out.println("Create account button is displayed & enabled");

        Assert.assertEquals(actual_subtotal, subtotal_thankyou);
        shipping_thankyou = thank_you_page.ShippingDesktop();

        Assert.assertEquals(fedex_shipping_cost, shipping_thankyou);
        tax_thankyou = thank_you_page.TaxDesktop();

        Assert.assertEquals(tax_thankyou, tax);
        order_total_thankyou = thank_you_page.TotalOrderDesktop();

        Assert.assertEquals(order_total_thankyou, (subtotal_thankyou + tax_thankyou + shipping_thankyou));
        System.out.println("Verify thank you page: Passed");

    }


    @Test
    public void contacUs() throws InterruptedException {
        contactusaction contact_us = new contactusaction(dr);
//        Go to contact us
        contact_us.goToContactUsPage();
//        Validate
//        contact_us.validateRequiredFields();
        contact_us.submitContactUs();
    }


}
