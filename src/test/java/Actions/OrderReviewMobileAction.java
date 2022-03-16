package Actions;

import UI.OrderReviewMobileUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class OrderReviewMobileAction extends BaseFunction {
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

    public OrderReviewMobileAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    //	Open Cart Summary
    public void openCartSummary() {
        waitElementVisible(OrderReviewMobileUI.Hide_Cart_Link);
        clickElementMobile(OrderReviewMobileUI.Hide_Cart_Link);
    }

    //	Get subtotal on Cart Summary
    public float subtotalCartSummary() {
        subtotal_cart_summary = getPrice(OrderReviewMobileUI.Cart_Subtotal);
        return subtotal_cart_summary;
    }

    //	Get shipping on Cart Summary
    public float shippingCartSummary() {
        shipping_cart_summary = getPrice(OrderReviewMobileUI.Cart_Shipping);
        return shipping_cart_summary;
    }

    //	Get tax on Cart Summary
    public float taxCartSummary() {
        tax_cart_summary = getPrice(OrderReviewMobileUI.Cart_Tax);
        return tax_cart_summary;
    }

    //	Get total on Cart Summary
    public float totalCartSummary() {
        String total_cart_summary_string = getText(OrderReviewMobileUI.Cart_Total);
        total_cart_summary = Float.parseFloat(total_cart_summary_string.replace("Total $", ""));
        return total_cart_summary;
    }

    //	Get shipping method name
    public String shippingMethodName() {
        moveToElement(OrderReviewMobileUI.Shipping_Method_Name);
        shipping_method_name = getAttribute(OrderReviewMobileUI.Shipping_Method_Name, "alt");
        return shipping_method_name;
    }

    //	Get shipping method cost
    public float shippingCost() {
        moveToElement(OrderReviewMobileUI.Shipping_Method_Name);
        shipping_cost_order_review = getPrice(OrderReviewMobileUI.Shipping_Method_Cost);
        return shipping_cost_order_review;
    }

    //	Get subtotal on Order Sumamry
    public float subtotalOrderSummary() {
        moveToElement(OrderReviewMobileUI.Footer_Order_Review_Page);
        subtotal_order_summary = getPrice(OrderReviewMobileUI.Order_Summary_Subtotal);
        return subtotal_order_summary;
    }

    //	Get shipping cost on Order Sumamry
    public float shippingOrderSummary() {
        shipping_order_summary = getPrice(OrderReviewMobileUI.Order_Summay_Shipping);
        return shipping_order_summary;
    }

    //	Get tax on Order Sumamry
    public float taxOrderSummary() {
        tax_order_summary = getPrice(OrderReviewMobileUI.Order_Summary_Tax);
        return tax_order_summary;
    }

    //	Get tax on Order Sumamry
    public float totalOrderSummary() {
        total_order_summary = getPrice(OrderReviewMobileUI.Order_Summary_Total);
        return total_order_summary;
    }

    public void placeOrder() throws InterruptedException {
        moveToElement(OrderReviewMobileUI.Footer_Order_Review_Page);
        clickElement(OrderReviewMobileUI.Place_Order_Button);
        Thread.sleep(1000);

    }

}
