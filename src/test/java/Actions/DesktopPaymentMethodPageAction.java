package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;
import UI.PaymentMethodUI;

public class DesktopPaymentMethodPageAction extends BaseFunction {

    public DesktopPaymentMethodPageAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    //	Get Total Order in Payment Method page
    public float TotalOrder() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(PaymentMethodUI.Payment_Title);
        String p = getText(PaymentMethodUI.Order_Total_Element);
        float totalorder = Float.parseFloat(p.replace("Total $", ""));
        return totalorder;
    }

    //	Get Tax
    public float Tax() throws InterruptedException {
        float tax = getPrice(PaymentMethodUI.Tax_Element);
        return tax;
    }

    public void paymentCreditCard() throws InterruptedException {
//		Select Credit Card option
        Thread.sleep(1000);
        waitElementVisible(PaymentMethodUI.Credit_Card_Option);
        clickElement(PaymentMethodUI.Credit_Card_Option);
        Thread.sleep(1000);
        inputCreditCard(PaymentMethodUI.IframeElement, PaymentMethodUI.Card_Number, PaymentMethodUI.Exp_Date,
                PaymentMethodUI.CVV, PaymentMethodUI.First_Name, PaymentMethodUI.Last_Name, PaymentMethodUI.ZipCode,
                PaymentMethodUI.Submit_button);

    }

    public void placeOrder() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(PaymentMethodUI.Place_Order_Button_Element);
        clickElement(PaymentMethodUI.Place_Order_Button_Element);
        Thread.sleep(3000);
    }
}
