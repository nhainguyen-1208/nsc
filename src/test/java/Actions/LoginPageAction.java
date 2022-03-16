package Actions;

import Common.BaseFunction;
import UI.Login;
import UI.MyAccountUI;
import UI.RegisterUI;
import org.testng.Assert;
import org.openqa.selenium.*;

public class LoginPageAction extends BaseFunction {

    public LoginPageAction(WebDriver dr) {
        super(dr);

    }

    public void verifyLoginFunction() throws InterruptedException {

//		Open website
        openWebsite();
        acceptCookie();
        dr.navigate().refresh();
//		Hover account menu
        hoverMenu(Login.Account_Menu);

//		Verify Login
        login("nhai.nguyen2@niteco.se", "Nh@i12o8");
        WebElement login_fail_mmsg = dr.findElement(Login.Login_Fail_Msg);
        String Login_Fail_Msg_Execpt = "Invalid email or password.";
        Assert.assertEquals(login_fail_mmsg.getText(), Login_Fail_Msg_Execpt);
        System.out.println("Case: Invalid email or password is Passed");

    }

    public void loginfrommenuSuccess() throws InterruptedException {

//		Open website
        openWebsite();
        acceptCookie();
        Thread.sleep(1000);

        hoverMenu(Login.Account_Menu);
        Thread.sleep(1000);

//		Login
        login("nhai.nguyen2@niteco.se", "Nh@i12o8");
        Thread.sleep(1000);
        waitElementVisible(Login.Welcome_element);
        String Welcome = getText(Login.Welcome_element).substring(0, 7);
        Assert.assertEquals(Welcome, "Welcome");
//		Log.info("Login successfully");

    }

//Login from login page

    public void loginfrompageSuccess() throws InterruptedException {

//		Open website
        openWebsite();
        acceptCookie();
        clickElement(Login.Account_Menu);
        Thread.sleep(1000);

//		Login
        dr.findElement(Login.Email).sendKeys("nhai.nguyen2@niteco.se");
        dr.findElement(Login.Password).sendKeys("Nh@i12o8");
        Thread.sleep(1000);
        clickElement(Login.Login_Button);
        Thread.sleep(3000);

    }
}