package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OriflameItemPage extends AbstractPage{
    public static String ORIFLAME_ITEM_PAGE_URL = "https://by.oriflame.com/products/product?code=37769";

    @FindBy(xpath = "//button[contains(@class,'k-button add-to-basket be-by')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='MuiTypography-root MuiTypography-body1 MuiLink-root MuiLink-underlineAlways top-area-4v5mp']")
    private WebElement cartIcon;

    public OriflameItemPage(WebDriver driver) {
        super(driver);
    }

    public OriflameItemPage clickAddToCartButton() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public OriflameCartPage clickCartIcon() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
        return new OriflameCartPage(webDriver);
    }

    @Override
    public OriflameItemPage openPage() {
        webDriver.get(ORIFLAME_ITEM_PAGE_URL);
        return this;
    }

}
