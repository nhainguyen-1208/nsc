package UI;

import org.openqa.selenium.By;

public class ContactUsUI {
    public static final By Support_Menu = By.xpath("//a[@class='support-hand']");
    public static final By Contact_Us_Menu = By.xpath("//a[text()='Contact Us']");
    public static final By Name_Element = By.xpath("//span[text()='*Name']/following-sibling::input");
    public static final By Email_Element = By.xpath("//span[text()='*Email Address']/following-sibling::input");
    public static final By Phone_Element = By.xpath("//span[contains(text(),'Phone')]/following-sibling::input");
    public static final By Reach_me_By_Phone_Element = By.xpath("//input[@value='Email']");
    public static final By Reach_me_By_Email_Element = By.xpath("//input[@value='Phone']");
    public static final By Comment_Element = By.xpath("//label[contains(text(),'Comments')]/following-sibling::textarea");
    public static final By Upload_File_Element = By.xpath("//input[@type='file']");
    public static final By Captcha_Element = By.xpath("//div[@class='recaptcha-checkbox-border']");
    public static final By Iframe = By.xpath("//iframe");
    public static final By Submit_Button = By.xpath("//button[@name='submit']");
    public static String message = "This field is required.";


}
