package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(className = "s-profile")
    WebElement loginIcon;

    //Elements on the current page
    @FindBy(id = "email")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "login-btn")
    private WebElement loginBtn;

    //Constructor
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Methods
    public ProductPage login(String userName, String password){

        loginIcon.click();


        WebElement loginPageTitle = driver.findElement(By.xpath("//p[text()='Вход в eBag']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPageTitle));

        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginBtn.click();


        ProductPage productPage = new ProductPage(driver);

        return productPage;

    }

}



