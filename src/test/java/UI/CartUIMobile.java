//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class CartUIMobile {
    public static String Cart_URL = "/shopping-cart";
    public static String Cart_Emtpy_Text_Expected = "Your cart is empty.";
    public static final By Cart_Empty = By.cssSelector("h1[class='col-xs-8']");
    public static final By MiniCart_Button = By.cssSelector("span[class='icon icon-cart']");
    public static final By Minitcart_Subotal = By.cssSelector("div[class='minicart__subtotal']");
    public static final By MiniCart_Checkout_Button = By.cssSelector("a[href='/shopping-cart']");
    public static final By Cart_Subtotal = By.cssSelector("div[class='sub-total']");
    public static final By Table_Body = By.xpath("//table/tbody");
    public static final By tr_tag = By.tagName("tr");
    public static final By Delete_Icon = By.cssSelector("span[class='hidden-sm']");
    public static final By Promo_Code_Textbox = By.id("promo-code");
    public static final By Apply_Button = By.cssSelector("button[class='apply']");
    public static final By Payment_Icon = By.xpath("//div[@class='payment__cards']");
    public static final By Loading = By.cssSelector("button[class='rec-panel__button']");
    public static final By Checkout_Button = By.xpath("//div[@class='payment__checkout text-center']/button");
    public static final By Checkout_As_Guest = By.xpath("//a[@class='info-button']");
    public static final By Email_Element = By.cssSelector("input[name='emailAddress']");
    public static final By Continue_Button_Element = By.xpath("//div[@class='email-collection-form']/form/button[@type='submit']");
    public static final By Guest_Option = By.cssSelector("label[for='guest']");
    public static final By Continue_Checkout_Button_Element = By.xpath("//div[@class='checkout-login-form']/form/button[@type='submit']");


}
