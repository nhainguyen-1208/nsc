//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class Login {
    public static final By Flyout_Block = By.cssSelector("div[class='flyout-dialog flyout-background']");
    public static final By Flyout_Close_Button = By.cssSelector("span[class='icon icon-close flyout-dialog__close']");
    public static final By Header = By.cssSelector("header[class='header']");
    public static final By Account_Menu = By.id("account-menu-button");
    public static By Login_Email = By.id("signupEmail");
    public static final By Login_PassWord = By.id("signupPassword");
    public static final By Login_Submit_Button = By.cssSelector("button[class='primary-button login-el']");
    public static final By Login_Email_Wrong_Msg = By.id("signupEmail-err-msg");
    public static final By Login_PassWord_Empty_Msg = By.id("signupPassword-rep-msg");
    public static final By Login_Fail_Msg = By.cssSelector("div[class='col-xs-12 error-text text-center clearfix mt-10'][style='']");
    public static final By Sign_out_text = By.cssSelector("div[href='/login/logout']");
    public static final By Welcome_element = By.cssSelector("h1[class='account-title']");
    public static final By Flyout_Element1 = By.cssSelector("div[class='flyout-dialog flyout-background']");
    public static final By Flyout_Element2 = By.cssSelector("div[class='flyout-dialog flyout-background  flyout-dialog__lower-right']");

//Login page
    public static final By Email = By.xpath("//form[@id='login-form']//input[@name='signupEmail']");
    public static final By Password = By.xpath("//form[@id='login-form']//input[@name='signupPassword']");
    public static final By Login_Button = By.xpath("//button[text()='Login']");

}
