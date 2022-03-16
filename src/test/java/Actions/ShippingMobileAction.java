package Actions;

import UI.ShippingMobileUI;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class ShippingMobileAction extends BaseFunction {
    float subtotal_shipping_page;

    public ShippingMobileAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    //	Get subtotal on Shipping Page
    public float getSubtotalinShippingMethod() throws InterruptedException {
        Thread.sleep(1000);
        clickElementMobile(ShippingMobileUI.Show_Cart_Element);
        subtotal_shipping_page = getPrice(ShippingMobileUI.Subtotal_Mobile_Element);
        return subtotal_shipping_page;

    }



    public void shippingAddressGuest() throws InterruptedException {

        waitElementVisible(ShippingMobileUI.Email_Element);
        Thread.sleep(1000);

//		Input Email
        inputEmailRandDom(ShippingMobileUI.Email_Element);

//		Input Contact Information
        inputName(ShippingMobileUI.First_Name, ShippingMobileUI.Last_Name);

        Thread.sleep(1000);
        inputPhone(ShippingMobileUI.Phone);

//		Input Address
        moveToElement(ShippingMobileUI.Address);
        inputAddress(ShippingMobileUI.Address, ShippingMobileUI.SmartyStreet, ShippingMobileUI.address_value);
        Thread.sleep(3000);

    }

//		Click on Billing Address name is the same as the contact checkbox

    public void sameAsShippingAddress() throws InterruptedException {
        clickElementMobile(ShippingMobileUI.Billing_Same_As_Shipping);
        Thread.sleep(1000);

    }

    public float fedExGroundShippingCost() throws InterruptedException {

        int i;
        waitElementInvisible(ShippingMobileUI.Loading_Shipping_Method);
        for (i = 1; i <= 4; i++) {
            String xpath1 = ShippingMobileUI.s1 + "[" + i + "]" + ShippingMobileUI.s2;
            moveToElement(By.xpath(xpath1));
            WebElement method_name_element = dr.findElement(By.xpath(xpath1));
            String shipping_method_name = method_name_element.getText();
            if (shipping_method_name.contains("FedEx Ground")) {
                String xpath2 = ShippingMobileUI.s3 + "[" + i + "]" + ShippingMobileUI.s4;
                moveToElement(By.xpath(xpath2));
                WebElement method_cost_element = dr.findElement(By.xpath(xpath2));
                String Shipping_cost_string = method_cost_element.getText().replace("$", "");
                compareShippingCost(subtotal_shipping_page, Shipping_cost_string);
                moveToElement(ShippingMobileUI.Selected_Shipping_Method_Element);
                String att = getAttribute(ShippingMobileUI.Selected_Shipping_Method_Element, "class");
                assertEquals(true, att.contains("selected"));
                return Float.parseFloat(Shipping_cost_string);

            }

        }
        return 0;

    }

    //	Click Continue button
    public void goToBillingPageMobile() throws InterruptedException {
        waitElementVisible(ShippingMobileUI.Continue_Button_Mobile);
        Thread.sleep(1000);
        moveToElement(ShippingMobileUI.Save_And_Continue);
        clickElementMobile(ShippingMobileUI.Continue_Button_Mobile);
        Thread.sleep(1000);
    }

}
