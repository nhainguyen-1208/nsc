package Actions;

import Common.BaseFunction;
import UI.MyAccountUI;
import UI.ShippingMethodUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class MyAccountAction extends BaseFunction {

    public MyAccountAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    //    Go to Address Book
    public void goToAddressBook() throws InterruptedException {
        waitElementVisible(MyAccountUI.Address_Book_Menu);
        clickElement(MyAccountUI.Address_Book_Menu);
        waitElementVisible(MyAccountUI.Address_Book_Title);

    }

    public String getAddressBookTitle() {
        String address_book_title = getText(MyAccountUI.Address_Book_Title);
        return address_book_title;
    }

    /*    Add new shipping Address
    1. Validate required fields
    2. Add new address successfully
     */
    public void validateAddShippingAddress() throws InterruptedException {

//      Click Add new Shipping Address button
        clickElement(MyAccountUI.Add_Shipping_Button);
        waitElementVisible(MyAccountUI.Address_Popup_Title);
//      Click on Save button
        clickElement(MyAccountUI.Save_Button);
    }

    //     Get first name message
    public String firstNameMessage() {
        String first_name_msg = getText(MyAccountUI.First_Name_Required_Msg);
        return first_name_msg;

    }

    //      Get last name message
    public String lastNameMessage() {
        String last_name_msg = getText(MyAccountUI.Last_Name_Required_Msg);
        return last_name_msg;
    }

    //     Get zipcode message
    public String zipcodeMessage() {
        String zipcode_msg = getText(MyAccountUI.Zipcode_Required_Msg);
        return zipcode_msg;
    }

    //      Get address message
    public String addressMessage() {
        String address_msg = getText(MyAccountUI.Address_Line1_Required_Msg);
        return address_msg;
    }

    //      Get city message
    public String cityMessage() {
        String city_msg = getText(MyAccountUI.City_Required_Msg);
        return city_msg;
    }

    //      Get state message
    public String stateMessage() {
        String state_msg = getText(MyAccountUI.State_Required_Msg);
        return state_msg;
    }

    //      Get phone message
    public String phoneMessage() {
        String phone_msg = getText(MyAccountUI.Phone_Required_Msg);
        return phone_msg;
    }

    public Integer shippingAddressSize() {
        int size = getElementSize(MyAccountUI.Shipping_Address_Element);
        return size;
    }

    //    add new shipping address
    public void addNewShippingAddress() throws InterruptedException {
        clickElement(MyAccountUI.Add_Shipping_Button);
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.First_Name).sendKeys("new");
        dr.findElement(MyAccountUI.Last_Name).sendKeys("shipping");
        dr.findElement(MyAccountUI.Address_Line1).sendKeys("123 10th St SE");
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.Zipcode).sendKeys("24013");
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.Address_Line1).click();
        Thread.sleep(3000);
        dr.findElement(MyAccountUI.Phone).sendKeys("4112223334");
        Thread.sleep(1000);
        clickElement(MyAccountUI.Save_Button);
        Thread.sleep(1000);
    }


    //Get name of first shipping address
    public String getFirstShippingAddressName() {
        String first_address_name = getText(MyAccountUI.Address_Full_Name_Shipping);
        return first_address_name;
    }

    //    Edit shipping addresss
    public void editShippingAddress() throws InterruptedException {
//        Click Edit button
        clickElement(MyAccountUI.Edit_Button_Shipping);
        String old_last_name = getText(MyAccountUI.Last_Name);
        dr.findElement(MyAccountUI.Last_Name).sendKeys(old_last_name + " update");
        Thread.sleep(2000);
        clickElement(MyAccountUI.Save_Button);
        Thread.sleep(2000);
    }

    public void deleteShippingAddress() throws InterruptedException {
        int size = getElementSize(MyAccountUI.Shipping_Address_Element);
        for (int i = 1; i <= size; i++) {
            String xpath1 = MyAccountUI.s1 + "[" + i + "]" + MyAccountUI.s3;
            String full_name = dr.findElement(By.xpath(xpath1)).getText();
            if (full_name.equals("new shipping")) {
                String xpath2 = MyAccountUI.s1 + "[" + i + "]" + MyAccountUI.s2;
                WebElement button = dr.findElement(By.xpath(xpath2));
                button.click();
                Thread.sleep(1000);
                clickElement(MyAccountUI.Yes_Button);
//                acceptConfirmationPopup();
                Thread.sleep(2000);
                return;
            }
        }

    }


    /*    Add new billing Address
   1. Validate required fields
   2. Add new address successfully
   3. Edit
   4. Delete
    */
    public void validateAddBillingAddress() throws InterruptedException {

//      Click Add new Billing Address button
        clickElement(MyAccountUI.Add_Billing_Button);
        waitElementVisible(MyAccountUI.Address_Popup_Title);
//      Click on Save button
        clickElement(MyAccountUI.Save_Button);
    }


    public Integer billingAddressSize() {
        int size = getElementSize(MyAccountUI.Billing_Address_Element);
        return size;
    }

    //    add new billing address
    public void addNewBillingAddress() throws InterruptedException {
        clickElement(MyAccountUI.Add_Billing_Button);
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.First_Name).sendKeys("new");
        dr.findElement(MyAccountUI.Last_Name).sendKeys("billing");
        dr.findElement(MyAccountUI.Address_Line1).sendKeys("123 10th St SE");
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.Zipcode).sendKeys("24013");
        Thread.sleep(1000);
        dr.findElement(MyAccountUI.Address_Line1).click();
        Thread.sleep(3000);
        clickElement(MyAccountUI.Save_Button);
        Thread.sleep(1000);
    }


    //Get name of first billing address
    public String getFirstBillingAddressName() {
        String first_address_name = getText(MyAccountUI.Address_Full_Name_Billing);
        return first_address_name;
    }

    //    Edit billing addresss
    public void editBillingAddress() throws InterruptedException {
//        Click Edit button
        clickElement(MyAccountUI.Edit_Button_Billing);
        String old_last_name = getText(MyAccountUI.Last_Name);
        dr.findElement(MyAccountUI.Last_Name).sendKeys(old_last_name + " update");
        Thread.sleep(2000);
        clickElement(MyAccountUI.Save_Button);
        Thread.sleep(2000);
    }

    public void deleteBillingAddress() throws InterruptedException {
        int size = getElementSize(MyAccountUI.Billing_Address_Element);
        for (int i = 1; i <= size; i++) {
            String xpath1 = MyAccountUI.s4 + "[" + i + "]" + MyAccountUI.s6;
            String full_name = dr.findElement(By.xpath(xpath1)).getText();
            if (full_name.equals("new billing")) {
                String xpath2 = MyAccountUI.s4 + "[" + i + "]" + MyAccountUI.s5;
                WebElement button = dr.findElement(By.xpath(xpath2));
                Actions actions = new Actions(dr);
                actions.moveToElement(button).perform();
                button.click();
                Thread.sleep(1000);
                clickElement(MyAccountUI.Yes_Button);
//                acceptConfirmationPopup();
                Thread.sleep(2000);
                return;
            }
        }

    }


}
