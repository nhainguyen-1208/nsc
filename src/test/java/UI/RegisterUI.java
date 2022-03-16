//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class RegisterUI {
    public static final By Search_Icon = By.xpath("//span[@class='icon icon-search']");
    public static final By Account_Menu = By.id("account-menu-button");
    public static final By Register_Button = By.id("register");
    public static final By Register_Email_Field = By.xpath("//input[@name='emailAddress']");
    public static final By Register_Continue_Button = By.xpath("//button[contains(text(),'Continue')]");
    public static final By Register_Error_Message = By.id("register-email-err-msg");
    public static final By Register_First_Name = By.cssSelector("input[name='firstName']");
    public static final By Register_Last_Name = By.cssSelector("input[name='lastName']");
    public static final By Register_Email = By.cssSelector("input[name='email']");
    public static final By Register_Phone_Number = By.cssSelector("input[name='phoneNumber']");
    public static final By Register_PassWord = By.cssSelector("input[name='password']");
    public static final By Register_Confirm_PassWord = By.cssSelector("input[name='confirmPassword']");
    public static final By IframeElement = By.xpath("//iframe[@title='reCAPTCHA']");
    public static final By Recaptcha_Checkbox = By.xpath("//span[@id='recaptcha-anchor']");
    public static final By Register_Submit_Button = By.xpath("//button[contains(text(),'Create an account')]");
    public static final By Singout_Element = By.cssSelector("a[href=\"/login/logout\"]");


}
