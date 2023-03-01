package Project;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultsPage;

import java.time.Duration;

public class CheckoutTest extends TestUtil {

    @Test
    public void successfulCheckout(){


        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Уиски Chivas Regal 15г");

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, "Уиски Chivas Regal 15г");
        String actualProductName = searchResultsPage.getFirstProduct();
        Assert.assertEquals(actualProductName, "Уиски Chivas Regal 15г");

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        WebElement cartIcon = driver.findElement(By.className("s-basket"));
        cartIcon.click();

        WebElement orderButton = driver.findElement(By.className("order-btn"));
        orderButton.click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("dannytest@mail.bg", "Test12345");


       // WebElement googleLocator = driver.findElement(By.id("google-autocomplete-input"));
       // googleLocator.click();
       // googleLocator.clear();
       // googleLocator.sendKeys("бул. „Александър Малинов“ 51");
      //  WebElement editButton = driver.findElement(By.className("edit-section"));
     //   editButton.click();

     //   WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продължи']"));
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.elementToBeClickable(continueButton));
      //  JavascriptExecutor executor = (JavascriptExecutor)driver;
      //  executor.executeScript("arguments[0].click();", continueButton);


      //  WebElement firstName = driver.findElement(By.id("firstName"));
      //  executor.executeScript("arguments[0].click();", firstName);
      //  firstName.clear();
       // firstName.sendKeys("Daniel");

      //  WebElement lastName = driver.findElement(By.id("lastName"));
      //  lastName.click();
      //  lastName.clear();
      //  lastName.sendKeys("Georgiev");

       // WebElement phoneNumber = driver.findElement(By.id("phone"));
       // phoneNumber.click();
       // phoneNumber.clear();
       // phoneNumber.sendKeys("359883214232");


     //   WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait2.until(ExpectedConditions.visibilityOf(continueButton));
      //  executor.executeScript("arguments[0].click();", continueButton);

     //   WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
     //   wait3.until(ExpectedConditions.visibilityOf(continueButton));
     //   executor.executeScript("arguments[0].click();", continueButton);
        WebElement chooseDay = driver.findElement(By.xpath("//button[text()='УТРЕ']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", chooseDay);

        WebElement dateAndHour = driver.findElement(By.id("normal_delivery_slot_1900-2000_10"));
        executor.executeScript("arguments[0].click();", dateAndHour);

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продължи']"));
        executor.executeScript("arguments[0].click();", continueButton);

        WebElement paymentMethodEpay = driver.findElement(By.className("epay"));
        executor.executeScript("arguments[0].click();", paymentMethodEpay);

        WebElement sendTip = driver.findElement(By.xpath("//label[text()='Бакшиш']"));
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.visibilityOf(sendTip));

        Assert.assertTrue(sendTip.isDisplayed());

        // continueButton.click();




    }





}
