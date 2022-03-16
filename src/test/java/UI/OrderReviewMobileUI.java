//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class OrderReviewMobileUI {
    public static final By Cart_Subtotal = By.xpath("//li//span[text()='Subtotal']/following-sibling::span");
    public static final By Cart_Shipping = By.xpath("//li//span[@class='price']");
    public static final By Cart_Tax = By.xpath("//li//span[text()='Tax']/following-sibling::span");
    public static final By Cart_Total = By.xpath("//div[@class='order-total text-center']");
    public static final By Hide_Cart_Link = By.xpath("//span[@class='lbl']");
    public static final By Shipping_Method_Name = By.xpath("//div[@class='review-item']//img");
    public static final By Shipping_Method_Cost = By.xpath("//div[@class='text-right']//span[@class='price']");
    public static final By Order_Summary_Subtotal = By.xpath("//div[@class='order-summary']//span[text()='Subtotal']/following-sibling::span");
    public static final By Order_Summay_Shipping = By.xpath("//div[@class='order-summary']//span[@class='price']");
    public static final By Order_Summary_Tax = By.xpath("//div[@class='order-summary']//span[text()='Tax']/following-sibling::span");
    public static final By Order_Summary_Total = By.xpath("//div[@class='order-summary']//span[text()='Total']/following-sibling::span");
    public static final By Place_Order_Button = By.xpath("//button[text()='Place Your Order']");
    public static final By Footer_Order_Review_Page = By.xpath("//footer");


}
