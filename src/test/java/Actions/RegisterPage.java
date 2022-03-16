package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import UI.RegisterUI;
import Common.BaseFunction;
import org.openqa.selenium.JavascriptExecutor;
public class RegisterPage extends BaseFunction {

    public RegisterPage(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public void Register() throws InterruptedException {

        openWebsite();
        Thread.sleep(1000);
        acceptCookie();
        Thread.sleep(1000);

//		Click Searh Icon to close flyout block
        clickElement(RegisterUI.Search_Icon);
        hoverMenu(RegisterUI.Account_Menu);

//		Click on Register button
        clickElement(RegisterUI.Register_Button);

//		Input email
        waitElementVisible(RegisterUI.Register_Email_Field);
        inputEmailRandDom(RegisterUI.Register_Email_Field);
        clickElement(RegisterUI.Register_Continue_Button);

//		Input information
        waitElementVisible(RegisterUI.Register_First_Name);
        inputName(RegisterUI.Register_First_Name, RegisterUI.Register_Last_Name);
        Thread.sleep(1000);
        inputPhone(RegisterUI.Register_Phone_Number);
        Thread.sleep(1000);
        inputPassword(RegisterUI.Register_PassWord, RegisterUI.Register_Confirm_PassWord);
        Thread.sleep(1000);
////		accpetRecaptcha(RegisterUI.IframeElement, RegisterUI.Recaptcha_Checkbox);
////		moveToElement(RegisterUI.Register_Submit_Button);
//
//		JavascriptExecutor js = (JavascriptExecutor) dr;
//		WebElement Element = dr.findElement(RegisterUI.Register_Submit_Button);
//
//        //This will scroll the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();", Element);
//
//        WebElement iframe = dr.findElement(RegisterUI.IframeElement);
//		dr.switchTo().frame(iframe);
////		dr.switchTo().frame("a-36wolvlz25om");
//		dr.findElement(RegisterUI.Recaptcha_Checkbox).click();
//		dr.switchTo().defaultContent();
//		Thread.sleep(1000);
//
////		clickElement(RegisterUI.Recaptcha_Checkbox);
//		System.out.println("xxxx");
//		Thread.sleep(1000);

//		Thread.sleep(1000);
        clickElement(RegisterUI.Register_Submit_Button);
        Thread.sleep(5000);
        hoverMenu(RegisterUI.Account_Menu);
        waitElementVisible(RegisterUI.Singout_Element);
    }
}
