package Actions;

import Common.BaseFunction;
import UI.ProductPageUIMobile;
import org.openqa.selenium.*;
import java.util.ArrayList;

public class ProductPageMobile extends BaseFunction {

    public ProductPageMobile(WebDriver dr) {
        super(dr);

    }

    public float addProductToCart() throws InterruptedException {

        ArrayList<Float> price = new ArrayList<>();

//		Open PDP page
        dr.get(BaseFunction.baseUrl + ProductPageUIMobile.Variant);
        acceptCookie();

        scrollToElement(ProductPageUIMobile.Cart_Form_Element);
        Thread.sleep(1000);

//		Add variant 1 to cart
        selectDropdown(ProductPageUIMobile.Product_Size, ProductPageUIMobile.Large_Product_Size);
        selectDropdown(ProductPageUIMobile.Color, ProductPageUIMobile.Blue_Color);
        selectDropdown(ProductPageUIMobile.Packge_Size, ProductPageUIMobile.Package_Size_BestValue);
        selectDropdown(ProductPageUIMobile.Qty, ProductPageUIMobile.No1);

//		Get variant price & Convert price to float & add to array
        Thread.sleep(1000);
        scrollToElement(ProductPageUIMobile.Price_Element);
        waitElementVisible(ProductPageUIMobile.Price_Element);
        float price1 = getPrice(ProductPageUIMobile.Price_Element);
        price.add(price1);

//		Select ship one time option
        clickElementMobile(ProductPageUIMobile.Ship_One_Time);
//		scrollToElement(ProductPageUIMobile.Qty);
        clickElementMobile(ProductPageUIMobile.AddtoCart_Button);
        Thread.sleep(5000);

//		Close Recomnendation panel
        dr.navigate().refresh();
        Thread.sleep(5000);
        //		Add variant 2 to cart

        scrollToElement(ProductPageUIMobile.Cart_Form_Element);
        selectDropdown(ProductPageUIMobile.Packge_Size, ProductPageUIMobile.Package_Size_Pack10);
        selectDropdown(ProductPageUIMobile.Qty, ProductPageUIMobile.No2);
        Thread.sleep(1000);

//		 Get price variant 2
        scrollToElement(ProductPageUIMobile.Price_Element);
        waitElementVisible(ProductPageUIMobile.Price_Element);
        float price2 = getPrice(ProductPageUIMobile.Price_Element);
        price.add(price2);

        clickElementMobile(ProductPageUIMobile.Ship_One_Time);
        Thread.sleep(1000);
//		scrollToElement(ProductPageUIMobile.Qty);
        clickElementMobile(ProductPageUIMobile.AddtoCart_Button);
        Thread.sleep(5000);

//		Refresh to close recomendation panel
        dr.navigate().refresh();
        Thread.sleep(2000);
        float actual_subtotal = price1 + price2 * 2;
        return actual_subtotal;

    }

//	public float returnSubtotal(float price1, float price2) {
//		return subtotal = price1 + price2;
//
//	}

}
