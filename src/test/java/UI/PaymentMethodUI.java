//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import org.openqa.selenium.By;

public class PaymentMethodUI {
    public static final By Payment_Title = By.xpath("//div[@id='payment-steper']//h2");
    public static final By Credit_Card_Option = By.xpath("//span[text()='Credit or Debit Card']");
    public static final By PayPal_Option = By.xpath("//span[text()='PayPal']");
    public static final By Phone_Order_Option = By.xpath("//span[text()='Phone Order']");
    public static final By IframeElement = By.xpath("//iframe");
    public static final By Card_Number = By.xpath("//input[@id='cardNum']");
    public static final By Exp_Date = By.xpath("//input[@id='expiryDate']");
    public static final By CVV = By.xpath("//input[@id='cvv']");
    public static final By First_Name = By.xpath("//input[@name='firstName']");
    public static final By Last_Name = By.xpath("//input[@name='lastName']");
    public static final By ZipCode = By.xpath("//input[@name='zip']");
    public static final By Submit_button = By.xpath("//button[@name='Submit']");
    public static final By Tax_Element = By.xpath("//div[4]//div[@class='col-xs-6 text-right']");
    public static final By Order_Total_Element = By.xpath("//div[@class='total text-center border-top']");
    public static final By Place_Order_Button_Element = By.xpath("//button[@type='submit']");


}
