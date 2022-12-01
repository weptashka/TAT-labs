package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.OriflameCartPage;
import pageobject_model.page.OriflameItemPage;


public class OriflameTest {

    public static String EXPECTED_AMOUNT = "1";

    private static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddItemToCart() {
        OriflameCartPage expectedCartPage = new OriflameItemPage(driver)
                .openPage()
                .clickAddToCartButton()
                .clickCartIcon();
        String expectedResultOfItemAmount = expectedCartPage.getAmountOfItem();
        Assert.assertEquals(expectedResultOfItemAmount, EXPECTED_AMOUNT);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown()  {
        driver.quit();
        driver = null;
    }

}
