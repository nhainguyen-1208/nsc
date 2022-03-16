//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class ShippingMobileUI {
    public static int i;
    public static final By Email_Element = By.cssSelector("input[name='email']");
    public static final By First_Name = By.cssSelector("input[name='firstName']");
    public static final By Last_Name = By.cssSelector("input[name='lastName']");
    public static final By Phone = By.cssSelector("input[name='contactInfo.phoneNumber']");
    public static final By Address = By.cssSelector("input[name='address.line1']");
    public static final By Billing_Same_As_Shipping = By.cssSelector("label[for='set-as-shipping-address']");
    public static final By SmartyStreet = By.xpath("//div[@class='smarty-streets custom-dropdown']/ul[@class='dropdown-menu']");
    public static final By address_value = By.xpath("//div[@class='smarty-streets custom-dropdown']/ul/li[1]");
    public static final By Continue_Button_Mobile = By.id("shipping-continue");
    public static final By Save_And_Continue = By.xpath("//a[contains(text(),'Save')]");
    public static final By Loading_Shipping_Method = By.xpath("//div[@class='box-loading']");
    public static final By Shipping_Method_Title = By.xpath("//div[@class='shipping-addresses-wrapper']");
    public static String s1 = "//div[@role='button']";
    public static String s2 = "//span[@class='ship-method']";
    public static final By Shipping_Cost_Name_Element = By.xpath("//div[@class='panel panel-default'][" + i + "]//span[@class='ship-method']");
    public static final By Shipping_Cost_Element = By.xpath("div[@class='panel panel-default'][" + i + "]//span[@class='price']");
    public static String s3 = "//div[@role='button']";
    public static String s4 = "//div[@class='shipping-methods__price']";
    public static final By Selected_Shipping_Method_Element = By.xpath("//div[@class='shipping-methods__item selected']");
    public static final By Show_Cart_Element = By.xpath("//span[@class='lbl']");
    public static final By Subtotal_Mobile_Element = By.xpath("//ul[@class='ul order-summary__other']//span[contains(text(),'$')]");
    public static final By Subtotal_Mobile_Element1 = By.xpath("//ul[@class='ul order-summary__other']");



}
