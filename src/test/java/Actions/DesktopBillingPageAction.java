package Actions;

import UI.DesktopBillingUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class DesktopBillingPageAction extends BaseFunction {

    public DesktopBillingPageAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public void billingAddressGuest() throws InterruptedException {

        waitElementVisible(DesktopBillingUI.First_Name_Guest);
        Thread.sleep(1000);

//		Input Contact Information
        inputName(DesktopBillingUI.First_Name_Guest, DesktopBillingUI.Last_Name_Guest);

        Thread.sleep(1000);
        inputPhone(DesktopBillingUI.Phone_Number_Guest);

//		Click on Billing Address name is the same as the contact checkbox
        clickElement(DesktopBillingUI.Billing_Name_Same_Contact_Checkbox_Guest);
        Thread.sleep(1000);

//		Input Address
        inputAddress(DesktopBillingUI.Address, DesktopBillingUI.SmartyStreet, DesktopBillingUI.address_value);
        Thread.sleep(2000);

    }

    public void billingAddressSignIn() throws InterruptedException {

        waitElementVisible(DesktopBillingUI.First_Name_Sign_In);
        Thread.sleep(1000);

//		Input Address
        inputName(DesktopBillingUI.First_Name_Sign_In, DesktopBillingUI.Last_Name_Sign_In);
        inputAddress(DesktopBillingUI.Address, DesktopBillingUI.SmartyStreet, DesktopBillingUI.address_value);
        Thread.sleep(1000);

//		Click Set as shipping address button
        clickElement(DesktopBillingUI.Set_As_Shipping_Address_Checkbox);
        Thread.sleep(1000);

    }

    public void goToShippingAddressPage() throws InterruptedException {

//		Click on Continue button
        clickElement(DesktopBillingUI.Continue_Button);
        Thread.sleep(5000);

    }
}
