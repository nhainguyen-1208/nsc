package UI;

import org.openqa.selenium.By;

public class MyAccountUI {

    //---------------------     My Account Menu     ---------------------
    public static final By Credit_Card_Menu = By.cssSelector("ul[class='dropdown-menu'] li:nth-of-type(4) a");
//    ul[class='dropdown-menu'] li:nth-of-type(4) a
    public static final By Address_Book_Menu = By.cssSelector("ul[class='dropdown-menu'] li:nth-of-type(5) a");

    //---------------------     Address Boook     ---------------------
    public static final By Address_Book_Title = By.xpath("//h1[text()='Address Book']");

    //    Shipping Address
    public static final By Add_Shipping_Button = By.xpath("//button[text()='Add Shipping Address']");
    public static final By Address_Popup_Title = By.xpath("//h1[@id='addressModal-title']");
    public static final By First_Name = By.xpath("//input[@name='formAddress.firstName']");
    public static final By First_Name_Required_Msg = By.xpath("//span[@id='formAddress.firstName-err-msg']");
    public static final By Last_Name = By.xpath("//input[@name='formAddress.lastName']");
    public static final By Last_Name_Required_Msg = By.xpath("//span[@id='formAddress.lastName-err-msg']");
    public static final By Company = By.xpath("//input[@name='formAddress.company']");
    public static final By Address_Line1 = By.xpath("//input[@name='formAddress.line1']");
    public static final By Address_Line1_Required_Msg = By.xpath("//span[@id='formAddress.line1-err-msg']");
    public static final By Address_Line2 = By.xpath("//input[@name='formAddress.line2']");
    public static final By Zipcode = By.xpath("//input[@name='formAddress.postalCode']");
    public static final By Zipcode_Required_Msg = By.xpath("//span[@id='formAddress.line1-err-msg']");
    public static final By City_Required_Msg = By.xpath("//span[@id='formAddress.city-err-msg']");
    public static final By State_Required_Msg = By.xpath("//span[text()='Please select your state']");
    public static final By Phone = By.xpath("//input[@name='formAddress.daytimePhoneNumber']");
    public static final By Phone_Required_Msg = By.xpath("//div[text()='Please type your phone number']");
    public static final By Delivery_Note_Dropdown = By.xpath("//span[text()='Delivery notes (optional)']");
    public static final By Delivery_Note_Value = By.xpath("//button[text()='Leave on back or side porch']");
    public static final By Set_as_Address = By.xpath("//label[@for='defaultAddress']");
    public static final By Save_Button = By.xpath("//button[@id='address-continue']");
    public static final By Cancel_Button = By.xpath("//a[text()='Cancel']");
    public static final By Shipping_Address_Element = By.xpath("//span[text()='Shipping Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card']");
    public static final By Edit_Button_Shipping = By.xpath("//span[text()='Shipping Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card'][1]//button[@class='edit']");
    public static final By Address_Full_Name_Shipping = By.xpath("//div[@class='card-detail']//span[1]");
    public static String s1 = "//span[text()='Shipping Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card']";
    public static String s2 = "//button[@class='delete']";
    public static String s3 = "//div[@class='card-detail']//span[1]";
    public static final By Yes_Button = By.xpath("//div[@id='delete-address-confirmation']//div[@class='modal-footer']//button[@class='btn btn-primary']");

    //    Billing Address

    public static final By Add_Billing_Button = By.xpath("//button[text()='Add Billing Address']");
    public static final By Billing_Address_Element = By.xpath("//span[text()='Billing Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card']");
    public static final By Edit_Button_Billing = By.xpath("//span[text()='Billing Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card'][1]//button[@class='edit']");
    public static final By Address_Full_Name_Billing = By.xpath("//span[text()='Billing Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card'][1]//div[@class='card-detail']//span[1]");
    public static String s4 = "//span[text()='Billing Addresses']/following-sibling::div[1]/div[@class='col-xs-12 col-md-4 col-lg-4 address-card']";
    public static String s5 = "//button[@class='delete']";
    public static String s6 = "//div[@class='card-detail']//span[1]";
}
