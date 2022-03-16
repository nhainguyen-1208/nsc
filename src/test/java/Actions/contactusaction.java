package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import UI.ContactUsUI;
import Common.BaseFunction;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertTrue;

public class contactusaction extends BaseFunction {
    WebDriverWait wait;

    public contactusaction(WebDriver dr) {
        super(dr);
        this.wait = new WebDriverWait(this.dr, 10);
    }


    public void goToContactUsPage() throws InterruptedException {
        openWebsite();
        Thread.sleep(1000);
        acceptCookie();
//        Hover on Support Menu
        hoverMenu(ContactUsUI.Support_Menu);
//        Click Contact us link
        clickElement(ContactUsUI.Contact_Us_Menu);
        Thread.sleep(1000);

    }


    public void validateRequiredFields() throws InterruptedException {
        waitElementVisible(ContactUsUI.Name_Element);
        clickElement(ContactUsUI.Submit_Button);
        Thread.sleep(1000);
        assertTrue(isFocused(ContactUsUI.Name_Element));
        assertFalse(isFocused(ContactUsUI.Email_Element));
        String Name_Message = getMessage(ContactUsUI.Name_Element, "name", "//span[@data-f-linked-name='");
        Assert.assertEquals(Name_Message, ContactUsUI.message);
        String Email_Message = getMessage(ContactUsUI.Email_Element, "name", "//span[@data-f-linked-name='");
        Assert.assertEquals(Email_Message, ContactUsUI.message);
        String Phone_Message = getMessage(ContactUsUI.Phone_Element, "name", "//span[@data-f-linked-name='");
        Assert.assertEquals(Phone_Message, ContactUsUI.message);
        String Comment_Message = getMessage(ContactUsUI.Comment_Element, "name", "//span[@data-f-linked-name='");
        Assert.assertEquals(Comment_Message, ContactUsUI.message);
        String ReachMe_Message = getMessage(ContactUsUI.Reach_me_By_Phone_Element, "name", "//span[@data-f-linked-name='");
        Assert.assertEquals(ReachMe_Message, ContactUsUI.message);
        System.out.println("Contact us ---  Verify Validation function: Passed");

    }

    public void submitContactUs() throws InterruptedException{
        dr.findElement(ContactUsUI.Name_Element).sendKeys(createRandomWord(5));
        Thread.sleep(1000);
        inputEmailRandDom(ContactUsUI.Email_Element);
        dr.findElement(ContactUsUI.Phone_Element).sendKeys(creatRandomPhoneNumber(10));
        Thread.sleep(1000);
        clickElement(ContactUsUI.Reach_me_By_Phone_Element);
        Thread.sleep(1000);
        dr.findElement(ContactUsUI.Comment_Element).sendKeys(createRandomWord(100));
        Thread.sleep(1000);
        WebElement iframe = dr.findElement(ContactUsUI.Iframe);
        dr.switchTo().frame(iframe);
        Thread.sleep(1000);
        clickElement(ContactUsUI.Captcha_Element);
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        Thread.sleep(1000);
        clickElement(ContactUsUI.Submit_Button);
        Thread.sleep(5000);

    }
}

