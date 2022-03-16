package Actions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;
import UI.ShippingMethodUI;

public class DesktopShippingMethodPageAction extends BaseFunction {
    float subtotal_shipping_method;

    public DesktopShippingMethodPageAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public float getSubtotalinShippingMethod() throws InterruptedException {
        Thread.sleep(1000);
        waitElementVisible(ShippingMethodUI.Shipping_Method_Title);
        subtotal_shipping_method = getPrice(ShippingMethodUI.Subtotal_Element);
        return subtotal_shipping_method;

    }

    //	Verify FedExGround is selected as default & cost is correct
    public float fedExGroundShippingCost() throws InterruptedException {

        int i;
        for (i = 1; i <= 4; i++) {
            String xpath1 = ShippingMethodUI.s1 + "[" + i + "]" + ShippingMethodUI.s2;
            WebElement method_name_element = dr.findElement(By.xpath(xpath1));
            String shipping_method_name = method_name_element.getText();
            if (shipping_method_name.contains("FedEx Ground"))  {
                String xpath2 = ShippingMethodUI.s3 + "[" + i + "]" + ShippingMethodUI.s4;
                WebElement method_cost_element = dr.findElement(By.xpath(xpath2));
                String Shipping_cost_string = method_cost_element.getText().replace("$", "");
                compareShippingCost(subtotal_shipping_method, Shipping_cost_string);
                String att = getAttribute(ShippingMethodUI.Selected_Shipping_Method_Element, "class");
                assertEquals(true, att.contains("selected"));
                return  Float.parseFloat(Shipping_cost_string);

            }

        }
        return 0;

    }

    public void goToPaymentMethodPage() throws InterruptedException {

        clickElement(ShippingMethodUI.Continue_Button);
        Thread.sleep(5000);

    }

}
