package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {


    @FindBy(xpath = "//button[@class='close-popup btn-text']")
    WebElement closeButton;

    //Elements
    @FindBy(className = "btn-buy")
    WebElement addToCartButton;


    @FindBy(xpath = "//div[@class='text']")
    WebElement cartItemCount;

    @FindBy(className = "product-price")
    WebElement productPrise;



    public ProductPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }


    public void closeButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(closeButton));

    }


    public void addToCart() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addToCartButton);

            WebElement successfulAddToCartAlert = driver.findElement(By.cssSelector("p[role='alert']"));
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOf(successfulAddToCartAlert));


        }

    public String getCartItemCount() {
        String itemCountText = cartItemCount.getText().trim();
        return itemCountText;
    }
    public String getProductPrise() {

        return productPrise.getText();
    }


}