package Actions;

import Common.BaseFunction;
import UI.ProductPageUI;
import UI.ProductPageUIMobile;
import UI.RegisterUI;

import org.openqa.selenium.*;

import java.util.ArrayList;

public class ProductPage extends BaseFunction {


    public ProductPage(WebDriver dr) {
        super(dr);

    }

    public float addProductToCart() throws InterruptedException {

        ArrayList<Float> price = new ArrayList<>();

//		Open PDP page
        dr.get(BaseFunction.baseUrl + ProductPageUI.Variant);
        Thread.sleep(1000);
//        acceptCookie();

//		Click Searh Icon to close flyout block
        clickElement(RegisterUI.Search_Icon);
        Thread.sleep(2000);
        //		Show full screen
        dr.manage().window().maximize();
        Thread.sleep(1000);

//		Add variant 1 to cart
        moveToElement(ProductPageUI.Product_Size);
        selectDropdown(ProductPageUI.Product_Size, ProductPageUI.Large_Product_Size);
        selectDropdown(ProductPageUI.Color, ProductPageUI.Blue_Color);
        selectDropdown(ProductPageUI.Packge_Size, ProductPageUI.Package_Size_BestValue);
        selectDropdown(ProductPageUI.Qty, ProductPageUI.No1);

        Thread.sleep(1000);
        waitElementVisible(ProductPageUI.Price_Element);

        clickElement(ProductPageUI.Ship_One_Time);
        Thread.sleep(1000);
        clickElement(ProductPageUI.AddtoCart_Button);
        Thread.sleep(1000);

//		Get variant price & Convert price to float & add to array
        float price1 = getPrice(ProductPageUI.Price_Element);
        price.add(price1);

//		Add variant 2 to cart
        moveToElement(ProductPageUI.Product_Size);
        selectDropdown(ProductPageUI.Packge_Size, ProductPageUI.Package_Size_Pack10);
        selectDropdown(ProductPageUI.Qty, ProductPageUI.No2);
        Thread.sleep(1000);

//		 Get price variant 2
        scrollToElement(ProductPageUI.Price_Element);
        waitElementVisible(ProductPageUI.Price_Element);
        clickElementMobile(ProductPageUI.Ship_One_Time);
        Thread.sleep(1000);

        clickElementMobile(ProductPageUI.AddtoCart_Button);
        Thread.sleep(1000);
//
        float price2 = getPrice(ProductPageUI.Price_Element);
        price.add(price2);

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
