package Actions;

import UI.DesktopShippingAddressUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class DesktopShippingAddressPageAction extends BaseFunction {


    public DesktopShippingAddressPageAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public float getSubtotal() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(DesktopShippingAddressUI.Shipping_Title);
        Thread.sleep(1000);
        float subtotal = getPrice(DesktopShippingAddressUI.Subtotal_Element);
        return subtotal;

    }

    public void goToShippingMethodPage() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(DesktopShippingAddressUI.Continue_Button);
        Thread.sleep(5000);

    }

}