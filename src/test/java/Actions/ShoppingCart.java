package Actions;

import UI.ShoppingCartUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class ShoppingCart extends BaseFunction {

    public ShoppingCart(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public Boolean isCartEmpty() {

//		Go to Shopping Cart page
        dr.get(baseUrl + ShoppingCartUI.Cart_URL);
        String cart_emtpy = getText(ShoppingCartUI.Cart_Empty);

        return ShoppingCartUI.Cart_Emtpy_Text_Expected.equals(cart_emtpy);

    }

    public float MiniCart() throws InterruptedException {

//		Hover minicart
        hoverMenu(ShoppingCartUI.MiniCart_Button);
        Thread.sleep(1000);

//		Get subtotal in minicart
        waitElementVisible(ShoppingCartUI.Minitcart_Subotal);
        String subtotal1 = getText(ShoppingCartUI.Minitcart_Subotal);
        float minicart_subtotal = Float.parseFloat(subtotal1.replace("Cart Subtotal: $", ""));
        return minicart_subtotal;

//		Compare subtotal
//		Assert.assertEquals(actual_subtotal, minicart_subtotal);

    }

    public float ShoppingCartPage() throws InterruptedException {

//		Go to cart page
        Thread.sleep(1000);
        clickElement(ShoppingCartUI.MiniCart_Button);
        Thread.sleep(1000);
        waitElementVisible(ShoppingCartUI.Cart_Subtotal);
        String subtotal2 = getText(ShoppingCartUI.Cart_Subtotal);
        float cart_subtotal = Float.parseFloat(subtotal2.replace("Subtotal: $", ""));
        return cart_subtotal;


    }

    public void deleteItem() throws InterruptedException {

//		Get size cart table
        Thread.sleep(1000);
        int size = getTableSize(ShoppingCartUI.Table_Body, ShoppingCartUI.tr_tag);

        // Clear cart
        for (int i = 0; i < size; i++) {
            clickElement(ShoppingCartUI.Delete_Icon);
            if (i < size - 1) {
                Thread.sleep(2000);
            }
        }

    }

    public void checkoutAsGuest() throws InterruptedException {

        Thread.sleep(1000);
//       Click Checkout button on shopping cart
        clickElement(ShoppingCartUI.Checkout_Button);
        Thread.sleep(1000);

//		Input email
        inputEmailRandDom(ShoppingCartUI.Email_Element);

//		Click on Continue button
        clickElement(ShoppingCartUI.Continue_Button_Element);
        Thread.sleep(1000);

//		Select Checkout as Guest option
        waitElementVisible(ShoppingCartUI.Guest_Option);
        clickElement(ShoppingCartUI.Guest_Option);
        Thread.sleep(1000);

//		Click on Continue Checkout button
        clickElement(ShoppingCartUI.Continue_Checkout_Button_Element);
        Thread.sleep(2000);

    }
}