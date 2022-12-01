package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OriflameCartPage extends AbstractPage{

    public OriflameCartPage(WebDriver driver) {
        super(driver);
    }

    public String getAmountOfItem() {
        WebElement numberOfProductInput = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='Checkout-shopping-bag-step-1-products-item-37769-P-quantity']")));
        return numberOfProductInput.getAttribute("value");
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
