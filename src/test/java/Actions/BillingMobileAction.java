//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Actions;

import Common.BaseFunction;
import UI.BillingMobileUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingMobileAction extends BaseFunction {
    WebDriverWait wait;

    public BillingMobileAction(WebDriver dr) {
        super(dr);
        this.wait = new WebDriverWait(this.dr, 10);
    }

    public void paymentCreditCardMobile() throws InterruptedException {
        Thread.sleep(5000);
        this.waitElementVisible(BillingMobileUI.Credit_Card_Option);
        this.moveToElement(BillingMobileUI.Footer_Billing);
        this.clickElement(BillingMobileUI.Credit_Card_Option);
        Thread.sleep(1000);
        this.inputCreditCardCheckout(BillingMobileUI.IframeElement, BillingMobileUI.Card_Number, BillingMobileUI.Exp_Date, BillingMobileUI.CVV, BillingMobileUI.Submit_Button_Mobile);
        Thread.sleep(1000);
    }

    public void goToOrderReviewPage() throws InterruptedException {
        this.moveToElement(BillingMobileUI.Footer_Billing);
        this.clickElement(BillingMobileUI.Continue_Button_Billing_Page);
        Thread.sleep(3000);
    }
}
