package oriflame_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OriflameTest {

    private static WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddItemToCart() {
        webDriver.get("https://by.oriflame.com/products/product?code=37769");
        String EXPECTED_AMOUNT = "1";

        WebElement buttonAddToCart = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'k-button add-to-basket be-by')]")));
        buttonAddToCart.click();

        WebElement cartIcon = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='MuiTypography-root MuiTypography-body1 MuiLink-root MuiLink-underlineAlways top-area-4v5mp']")));
        cartIcon.click();

        WebElement numberOfProduct = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='Checkout-shopping-bag-step-1-products-item-37769-P-quantity']")));

        Assert.assertEquals(numberOfProduct.getAttribute("value"), EXPECTED_AMOUNT);
    }

    @Test
    public void testSearchProductByVendorCode(){
        String EXPECTED_VENDOR_CODE = "37769";
        webDriver.get("https://by.oriflame.com");

        WebElement searchInput = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'Поиск') or contains(@class,'top-area-sevu50')]")));
        searchInput.click();
        searchInput.sendKeys("37769");
        searchInput.click();
        searchInput.sendKeys(Keys.ENTER);

        WebElement itemWithVendorCode = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '37769') and contains(@class,'product-box-1uxw1kc')]")));

        String vendorCode = itemWithVendorCode.getAttribute("data-testid");

        Assert.assertEquals(vendorCode, "Presentation-product-box-" + EXPECTED_VENDOR_CODE);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown()  {
        webDriver.quit();
        webDriver = null;
    }

}
