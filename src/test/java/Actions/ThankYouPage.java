package Actions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;
import UI.ThankYouPageUI;

public class ThankYouPage extends BaseFunction {

    public ThankYouPage(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

//------------Function on Desktop----------------------//

    public void verifyPageTitleDesktop() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(ThankYouPageUI.Thank_You_Title);
        String att = getText(ThankYouPageUI.Thank_You_Title);
        assertEquals(true, att.contains("Order Complete"));
    }

    public Boolean verifyCreateAccountButtonExistedDesktop(){
        return (isEnabled(ThankYouPageUI.Create_Account_Button) && isDisplayed(ThankYouPageUI.Create_Account_Button)) ;

    }

    //	Get Total Order in Thankyou page
    public float TotalOrderDesktop() throws InterruptedException {
        Thread.sleep(1000);
        String p = getText(ThankYouPageUI.Total_Element);
        float totalorder = Float.parseFloat(p.replace("Total $", ""));
        return totalorder;
    }

    //	Get Subtotal
    public float SubtotalDesktop() throws InterruptedException {
        float subtotal = getPrice(ThankYouPageUI.Subtotal_Element);
        return subtotal;
    }

    //	Get Tax
    public float TaxDesktop() throws InterruptedException {
        float tax = getPrice(ThankYouPageUI.Tax_Element);
        return tax;
    }

    //	Get Shipping
    public float ShippingDesktop() throws InterruptedException {
        float shipping = getPrice(ThankYouPageUI.Shipping_Element);
        return shipping;
    }

    //	Get Discount
    public float DiscountDesktop() throws InterruptedException {
        float discount = getPrice(ThankYouPageUI.Discount_Element);
        return discount;
    }


//	------------Function on Mobile----------------------//


    public void verifyPageTitleMobile() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(ThankYouPageUI.Thank_You_Title);
        String att = getText(ThankYouPageUI.Thank_You_Title);
        assertEquals(true, att.contains("Order Complete"));
    }

    public Boolean verifyCreateAccountButtonExistedMobile(){
        moveToElement(ThankYouPageUI.Create_Account_Button);
        return (isEnabled(ThankYouPageUI.Create_Account_Button) && isDisplayed(ThankYouPageUI.Create_Account_Button));

    }

    //	Get Total Order in Thankyou page
    public float TotalOrderMobile() throws InterruptedException {
        moveToElement(ThankYouPageUI.Total_Element);
        Thread.sleep(1000);
        String p = getText(ThankYouPageUI.Total_Element);
        float totalorder = Float.parseFloat(p.replace("Total $", ""));
        return totalorder;
    }

    //	Get Subtotal
    public float SubtotalMobile() throws InterruptedException {
        moveToElement(ThankYouPageUI.Subtotal_Element);
        float subtotal = getPrice(ThankYouPageUI.Subtotal_Element);
        return subtotal;
    }

    //	Get Tax
    public float TaxMobile() throws InterruptedException {
        moveToElement(ThankYouPageUI.Tax_Element);
        float tax = getPrice(ThankYouPageUI.Tax_Element);
        return tax;
    }

    //	Get Shipping
    public float ShippingMobile() throws InterruptedException {
        moveToElement(ThankYouPageUI.Shipping_Element);
        float shipping = getPrice(ThankYouPageUI.Shipping_Element);
        return shipping;
    }

    //	Get Discount
    public float DiscountMobile() throws InterruptedException {
        moveToElement(ThankYouPageUI.Discount_Element);
        float discount = getPrice(ThankYouPageUI.Discount_Element);
        return discount;
    }
}
