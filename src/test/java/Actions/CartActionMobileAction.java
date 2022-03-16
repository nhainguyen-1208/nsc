package Actions;

import UI.CartUIMobile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.BaseFunction;

public class CartActionMobileAction extends BaseFunction {

    public CartActionMobileAction(WebDriver dr) {
        super(dr);

    }

    WebDriverWait wait = new WebDriverWait(dr, 10);

    public Boolean isCartEmpty() {

//		Go to Shopping Cart page
        dr.get(baseUrl + CartUIMobile.Cart_URL);
        String cart_emtpy = getText(CartUIMobile.Cart_Empty);

        return CartUIMobile.Cart_Emtpy_Text_Expected.equals(cart_emtpy);

    }

    public float MiniCart() throws InterruptedException {

//		Hover minicart
        hoverMenu(CartUIMobile.MiniCart_Button);
        Thread.sleep(1000);

//		Get subtotal in minicart
        waitElementVisible(CartUIMobile.Minitcart_Subotal);
        String subtotal1 = getText(CartUIMobile.Minitcart_Subotal);
        float minicart_subtotal = Float.parseFloat(subtotal1.replace("Cart Subtotal: $", ""));
        return minicart_subtotal;

//		Compare subtotal
//		Assert.assertEquals(actual_subtotal, minicart_subtotal);

    }

    public float ShoppingCartPage() throws InterruptedException {

//		Go to cart page
        Thread.sleep(1000);
        clickElementMobile(CartUIMobile.MiniCart_Button);
        Thread.sleep(1000);
        moveToElement(CartUIMobile.Cart_Subtotal);
        waitElementVisible(CartUIMobile.Cart_Subtotal);
        String subtotal2 = getText(CartUIMobile.Cart_Subtotal);
        float cart_subtotal = Float.parseFloat(subtotal2.replace("Subtotal: $", ""));
        return cart_subtotal;

    }

    public void deleteItem() throws InterruptedException {

//		Get size cart table
        Thread.sleep(1000);
        moveToElement(CartUIMobile.Table_Body);
        int size = getTableSize(CartUIMobile.Table_Body, CartUIMobile.tr_tag);

        // Clear cart
        for (int i = 0; i < size; i++) {
            clickElementMobile(CartUIMobile.Delete_Icon);
            if (i < size - 1) {
                Thread.sleep(2000);
            }
        }

    }

    public void checkoutAsGuest() throws InterruptedException {

        Thread.sleep(1000);
//       Click Checkout button on shopping cart
        moveToElement(CartUIMobile.Payment_Icon);
        clickElementMobile(CartUIMobile.Checkout_Button);
        Thread.sleep(1000);

//		Select Checkout as Guest option
        clickElementMobile(CartUIMobile.Checkout_As_Guest);
        Thread.sleep(2000);


    }
}