package Common;

import UI.Login;
import UI.PaymentMethodUI;
import UI.ProductPageUIMobile;
import UI.ShoppingCartUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseFunction {

    public static String baseUrl = "https://nocs01mstrc81epinte.dxcloud.episerver.net/";

    protected WebDriver dr;

    public BaseFunction(WebDriver dr) {
        this.dr = dr;
    }

//	Open website

    public void openWebsite() {
        dr.get(baseUrl);
        dr.manage().window().maximize();

    }

    //	Accept Cookie
    public void acceptCookie() throws InterruptedException {

        WebElement accept_cookie = dr.findElement(By.id("onetrust-accept-btn-handler"));
        accept_cookie.click();
        Thread.sleep(1000);
    }

    //	Hover   menu
    public void hoverMenu(By Element) throws InterruptedException {
        Actions actions = new Actions(dr);
        WebElement menu = dr.findElement(Element);
        actions.moveToElement(menu).perform();
        Thread.sleep(1000);
    }

    //	Input Textbox
    public void inputTextbox(String element, String value) {
        dr.findElement(By.cssSelector(element)).sendKeys(value);

    }

    // Login
    public void login(String email, String password) throws InterruptedException {
        WebElement Email = dr.findElement(Login.Login_Email);
        WebElement PassWord = dr.findElement(Login.Login_PassWord);
        WebElement sign_in_btn = dr.findElement(Login.Login_Submit_Button);
        Email.sendKeys(email);
        PassWord.sendKeys(password);
        sign_in_btn.click();
        Thread.sleep(2000);
    }

    //	Search Variant
    public void search(String attribute) {
        WebElement search_icon = dr.findElement(By.cssSelector("span[class='item search-xs header-search']"));
        search_icon.click();
        WebElement search_textbox = dr.findElement(By.cssSelector("input[type='text']"));
        search_textbox.sendKeys(attribute);

    }

    //Select value from dropdown
    public void selectDropdown(By dropdown, By value) throws InterruptedException {
        WebElement Dropdown = dr.findElement(dropdown);
        Thread.sleep(500);
        Dropdown.click();
        Thread.sleep(500);
        WebElement Value = dr.findElement(value);
        Thread.sleep(500);
        Value.click();

    }

    //	Check element display
    public Boolean isDisplayed(By Element) {
        Boolean Display = dr.findElement(Element).isDisplayed();
        return Display;
    }

    //    Check element focus
    public Boolean isFocused(By Element) {
        WebElement element = dr.findElement(Element);
        Boolean focus = element.equals(dr.switchTo().activeElement());
        return focus;
    }

    //	Check element enable
    public Boolean isEnabled(By Element) {
        Boolean Enable = dr.findElement(Element).isEnabled();
        return Enable;
    }

    //	Wait element visible
    public void waitElementVisible(By Element) {
        WebDriverWait wait = new WebDriverWait(dr, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }

    //	Wait element invisible
    public void waitElementInvisible(By Element) {
        WebDriverWait wait = new WebDriverWait(dr, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Element));
    }

    //	getText
    public String getText(By Element) {
        return dr.findElement(Element).getText();

    }

    //	Get text from position
    public String getTextPostion(By Element, int textPosition) {
        WebElement element = dr.findElement(Element);
        JavascriptExecutor js = (JavascriptExecutor) dr;
        return (String) js.executeScript(
                "var parent = arguments[0];var textPosition = arguments[1]; var txtPosition = 0; var child = parent.firstChild; var textValue=''; while(child) { if (child.nodeType === 3){ if (txtPosition===(textPosition-1)){ textValue = child.textContent; break;}}else{txtPosition+=1;}child = child.nextSibling; } return textValue;",
                element, textPosition);
    }

    //	click element
    public void clickElement(By Element) {
        WebElement button = dr.findElement(Element);
        button.click();

    }

    public void inputPassword(By Element1, By Element2) {
        dr.findElement(Element1).sendKeys("Abcd@123");
        dr.findElement(Element2).sendKeys("Abcd@123");
    }

    //	Get price & convert to float
    public float getPrice(By Element) {
        String p = getText(Element);
        float price = Float.parseFloat(p.replace("$", ""));
        return price;

    }

    public String getAttribute(By Element, String att) {
        WebElement element = dr.findElement(Element);
        return element.getAttribute(att);

    }

    // Get requie message from Epi Form
    public String getMessage(By Element, String att, String path) {
        WebElement element = dr.findElement(Element);
        String s = element.getAttribute(att);
        String x = path + s + "']";
        return dr.findElement(By.xpath(x)).getText();

    }

    public void waitPageLoad() {
        WebDriverWait wait = new WebDriverWait(dr, 10);
        wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    //	scroll to visible of Element
    public void scrollToElement(By Element) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) dr;
        // specify the WebElement till which the page has to be scrolled
        WebElement element = dr.findElement(Element);
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

//	public void scrollToElement1(WebElement element) {
//        waitForElementToBeVisible(element, 10);
//        Point p = element.getLocation();
//        long innerHeight = (long) ((JavascriptExecutor) dr).executeScript("return window.innerHeight");
//        logger.info("Scrolling to " + element);
//        ((JavascriptExecutor) dr).executeScript("window.scroll(" + p.getX() + "," + (p.getY() - innerHeight / 2) + ");", element);
//    }

    public void clickElementMobile(By Element) {
        WebElement element = dr.findElement(Element);
        Actions actions = new Actions(dr);
        actions.moveToElement(element).click().build().perform();
    }

    //	Move to Element
    public void moveToElement(By Element) {
        WebElement element = dr.findElement(Element);
        Actions actions = new Actions(dr);
        actions.moveToElement(element).perform();
    }

    //	Hide element
    public void hideElement(By Element) {
        WebElement element = dr.findElement(Element);
        ((JavascriptExecutor) dr).executeScript("arguments[0].style.visibility='hidden'", element);
    }

    //    Accept confirmation popup
    public void acceptConfirmationPopup() {
        Alert alert = dr.switchTo().alert();
        dr.switchTo().alert().accept();

    }


    //    Get message from confirmation popup
    public String acceptConfirmationPopupMessage() {
        Alert alert = dr.switchTo().alert();
        String message = dr.switchTo().alert().getText();
        dr.switchTo().alert().accept();
        return message;
    }


    //    Reject confirmation popup
    public void rejectConfirmationPopup() {
        Alert alert = dr.switchTo().alert();
        String message = dr.switchTo().alert().getText();
        dr.switchTo().alert().dismiss();

    }

//    Count child element

    public Integer getElementSize(By Element) {
        int size = dr.findElements(Element).size();
        return size;
    }

    //	Get size table
    public Integer getTableSize(By TableElement, By TableTag) {
        waitElementVisible(TableElement);
        WebElement table = dr.findElement(TableTag);
        List<WebElement> TotalRowsList = table.findElements(TableTag);
        return TotalRowsList.size();
    }

    public void inputName(By FirstName, By LastName) throws InterruptedException {
        dr.findElement(FirstName).sendKeys(createRandomWord(5));
        Thread.sleep(1000);
        dr.findElement(LastName).sendKeys(createRandomWord(5));
        Thread.sleep(1000);

    }

    public void inputPhone(By Phone) throws InterruptedException {
        dr.findElement(Phone).sendKeys(createPhoneNumber());
        Thread.sleep(1000);

    }

    public void inputAddress(By Address, By SmartyStreet, By Value) throws InterruptedException {
        dr.findElement(Address).sendKeys(createRandomNum());
        Thread.sleep(1000);
        waitElementVisible(SmartyStreet);
        WebElement value = dr.findElement(Value);
        value.click();
    }

    public void inputEmailRandDom(By Email_Element) {
        WebElement email = dr.findElement(Email_Element);
        email.sendKeys("test+" + createRandomEmail(10000, 99999) + "@nsc.co");
    }

    public void inputCreditCard(By IframeElement, By CardNumber, By ExpDate, By CardCode, By FirstName, By LastName,
                                By ZipCode, By Button) throws InterruptedException {

        WebElement iframe = dr.findElement(IframeElement);
        dr.switchTo().frame(iframe);
        Thread.sleep(1000);
        dr.findElement(CardNumber).sendKeys("3569990010095841");
        Thread.sleep(1000);
        dr.findElement(ExpDate).sendKeys("1126");
        Thread.sleep(1000);
        dr.findElement(CardCode).sendKeys("737");
        Thread.sleep(1000);
        dr.findElement(FirstName).sendKeys("Test");
        Thread.sleep(1000);
        dr.findElement(LastName).sendKeys("Test");
        Thread.sleep(1000);
        dr.findElement(ZipCode).sendKeys("56565");
        clickElement(Button);
        Thread.sleep(3000);
        dr.switchTo().defaultContent();
        Thread.sleep(1000);

    }

    public void inputCreditCardCheckout(By IframeElement, By CardNumber, By ExpDate, By CardCode, By Button)
            throws InterruptedException {

        WebElement iframe = dr.findElement(IframeElement);
        dr.switchTo().frame(iframe);
        Thread.sleep(1000);
        dr.findElement(CardNumber).sendKeys("3569990010095841");
        Thread.sleep(1000);
        dr.findElement(ExpDate).sendKeys("1126");
        Thread.sleep(1000);
        dr.findElement(CardCode).sendKeys("737");
        clickElement(Button);
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        Thread.sleep(1000);

    }

    public static String createRandomWord(int len) {
        String name = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }


    public static String  creatRandomPhoneNumber(int n){
        int m = (int) Math.pow(10, n - 1);
        System.out.println(m + new Random().nextInt(9 * m));

        return String.valueOf( m + new Random().nextInt(9 * m));
    }

    public static String createRandomNum() {
        Random rand = new Random();
        int ranNum = rand.nextInt(999) + 1;
        return String.valueOf(ranNum);
    }

    public static String createRandomEmail(int min, int max) {

        return String.valueOf((int) Math.floor(Math.random() * (max - min + 1) + min));

    }

    public static String createPhoneNumber() {
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        return df3.format(num1) + df3.format(num2) + df4.format(num3);
    }

//    public ArrayList<String> readExcel(String brand, String eventName, String sheetName) throws IOException {
//        ArrayList<String> result = new ArrayList<>();
//        String filePath = System.getProperty("user.dir") + "/src/trackingData/" + brand + "TrackingData.xlsx";
//        File file = new File(filePath);
//        FileInputStream inputStream = new FileInputStream(file);
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet sheet = workbook.getSheet(sheetName);
//        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//        for (int i = 1; i < rowCount + 1; i++) {
//            Row row = sheet.getRow(i);
//            for (int j = 1; j < row.getLastCellNum(); j++) {
//                if (row.getCell(0).getStringCellValue().equals(eventName)) {
//                    result.add(row.getCell(j).getStringCellValue());
//                }
//            }
//        }
//        return result;

//    }


    public void compareShippingCost(float subtotal, String cost) {
        if (subtotal >= 0 && subtotal <= 10) {
            Assert.assertEquals(cost, "7.95");
        } else if (subtotal >= 10.01 && subtotal <= 35) {
            Assert.assertEquals(cost, "8.95");
        } else if (subtotal >= 35.01 && subtotal <= 60) {
            Assert.assertEquals(cost, "9.95");
        } else if (subtotal >= 60.01 && subtotal <= 80) {
            Assert.assertEquals(cost, "10.95");
        } else if (subtotal >= 80.01 && subtotal <= 100) {
            Assert.assertEquals(cost, "12.95");
        } else if (subtotal >= 100.01 && subtotal <= 125) {
            Assert.assertEquals(cost, "14.95");
        } else if (subtotal >= 125.01 && subtotal <= 150) {
            Assert.assertEquals(cost, "16.95");
        } else if (subtotal >= 150.01 && subtotal <= 175) {
            Assert.assertEquals(cost, "18.95");
        } else if (subtotal >= 175.01 && subtotal <= 200) {
            Assert.assertEquals(cost, "21.95");
        } else if (subtotal >= 200.01 && subtotal <= 250) {
            Assert.assertEquals(cost, "26.95");
        } else if (subtotal >= 250.01 && subtotal <= 300) {
            Assert.assertEquals(cost, "32.95");
        } else if (subtotal >= 300.01 && subtotal <= 350) {
            Assert.assertEquals(cost, "36.95");
        } else if (subtotal >= 350.01 && subtotal <= 400) {
            Assert.assertEquals(cost, "42.95");
        } else if (subtotal >= 400.01 && subtotal <= 450) {
            Assert.assertEquals(cost, "46.95");
        } else if (subtotal >= 450.01 && subtotal <= 500) {
            Assert.assertEquals(cost, "49.95");
        }
    }

}
