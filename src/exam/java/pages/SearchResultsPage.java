package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), '%s')]")
    WebElement productTitle;




    public SearchResultsPage(WebDriver driver, String productName) {
        super(driver);
        PageFactory.initElements(driver, this);
        productTitle = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", productName)));
    }
    public String getFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productTitle));

      return productTitle.getText();
    }
}
