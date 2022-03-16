//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class ShippingMethodUI {
    public static int i;
    public static final By Continue_Button = By.cssSelector("button[class='primary-button']");
    public static final By Shipping_Method_Title = By.xpath("//div[@class='shipping-addresses-wrapper']");
    public static final By Subtotal_Element = By.cssSelector("div[class='col-xs-6 text-right']");
    public static String s1 = "//div[@class='panel panel-default']";
    public static String s2 = "//span[@class='ship-method']";
    public static final By Shipping_Cost_Name_Element = By.xpath("//div[@class='panel panel-default'][" + i + "]//span[@class='ship-method']");
    public static final By Shipping_Cost_Element = By.xpath("div[@class='panel panel-default'][" + i + "]//span[@class='price']");
    public static String s3 = "//div[@class='panel panel-default']";
    public static String s4 = "//span[@class='price']";
    public static final By Selected_Shipping_Method_Element = By.xpath("//div[@class='custom-radio selected']");


}
