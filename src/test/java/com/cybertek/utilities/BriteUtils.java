package com.cybertek.utilities;


    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;
    import org.testng.internal.ExpectedExceptionsHolder;

    import java.util.ArrayList;
    import java.util.List;
public class BriteUtils {

   public static WebDriver driver = Driver.getDriver();

    static WebDriverWait wait = new WebDriverWait(driver, 10);

    static  String actionButtonLocator = "//button[contains(text(),'Action')]";
    static  String okLocator = "//span[text()='Ok']";



    static String usernameInputLocator = "#login";
    static String passwordInputLocator = "#password";
    static String LoginButtonLocator = "//button[@type ='submit']";



    public static void loginToPage(){

       String  username = ConfigurationReader.getProperty("eventscrmmanagerusername");
        String password = ConfigurationReader.getProperty("eventscrmmanagerpassword");

        Driver.getDriver().findElement(By.cssSelector(usernameInputLocator)).sendKeys(username);
        Driver.getDriver().findElement(By.cssSelector(passwordInputLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.xpath(LoginButtonLocator)).click();
        SeleniumUtils.waitPlease(3);

    }

    public static void navigateToModule(WebDriver driver, String tab, String module) {

        String tabLocator = "//span[contains(text(),'" + tab + "') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'" + module + "') and contains(@class, 'title title-level-2')]";

        //driver.findElement(By.xpath(tabLocator)).click();

        SeleniumUtils.clickWithWait(driver, By.xpath(tabLocator), 5);
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(moduleLocator)).click();
        // SeleniumUtils.clickWithWait(driver,By.xpath(moduleLocator),5);

        SeleniumUtils.waitPlease(2);
    }

    public static void navigateToModule(WebDriver driver, String module) {

        String moduleLocator = "//span[@class = 'oe_menu_text' and contains(text(),'"+module+"')]";

        WebElement element = driver.findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        SeleniumUtils.waitPlease(2);
    }

    public static List<WebElement> getHeaders(String tableLocatorX) {

        return driver.findElements(By.xpath(tableLocatorX));
    }


    public  static List<String> getHeadersText(String tableLocatorX) {

        List<String> headers = new ArrayList<>();

        for (WebElement tableHeaders : getHeaders(tableLocatorX)) {

            headers.add(tableHeaders.getText());
        }

        return headers;

    }


    public static int getCountOfColumns(String tableLocatorX) {

        return driver.findElements(By.xpath(tableLocatorX)).size();
    }

    public static int getCountOfColumns(By by) {

        return driver.findElements(by).size();
    }


    public static List<String> getColumnData(String columnName,String tableLocatorX) {

        int columnNumber = 0;

        for (int i = 0; i < getCountOfColumns(tableLocatorX); i++) {

            if (columnName.equals(getHeadersText(tableLocatorX).get(i))) {
                columnNumber = i + 1;

            }
        }

        // String locatorForColumn = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tbody//tr/td["+columnNumber+"]";

        String locatorForColumn = tableLocatorX+"//tbody//tr/td["+columnNumber+"]";

        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));

        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element :
                columnCollectionOfWebElements) {
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;

    }







    /**
         * Select opportunity based on opportunity title
         * @param opportunity
         */
        public static void selectOpportunity(String opportunity){
            String locator = "//td[text()='"+opportunity+"']/preceding-sibling::td//input";
            driver.findElement(By.xpath(locator)).click();
        }

        /**
         * Method that deletes opportunity based on opportunity title
         * @param opportunity
         */
        public static void deleteOpportunity(String opportunity){
            selectOpportunity(opportunity);
            selectAction("Delete");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okLocator)));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(okLocator))));
            driver.findElement(By.xpath(okLocator)).click();
        }

        /**
         * Method that selects action for opportunity
         * @param actionName
         */
        public  static void selectAction(String actionName){
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actionButtonLocator))));
            driver.findElement(By.xpath(actionButtonLocator)).click();
            String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'"+actionName+"')]";
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionLocator))));
            driver.findElement(By.xpath(optionLocator)).click();
        }

        /**
         * Based on opportunity title this method will verify that there is no cell with a given text
         * @param opportunity
         */
        public static  void verifyThatOpportunityDeleted(String opportunity){
            String locator = "//td[text()='"+opportunity+"']";
            List<WebElement> elements = driver.findElements(By.xpath(locator));
            Assert.assertTrue(elements.isEmpty());
        }



    }

