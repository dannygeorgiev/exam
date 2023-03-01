package Project;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class unsuccessfulLoginTest extends TestUtil {


    @Test (dataProvider = "wrongUsers")
    public void unSuccessfulLogin(String userName, String password){

      LoginPage loginPage = new LoginPage(driver);
      loginPage.login(userName, password);

      WebElement errorMessage = driver.findElement(By.xpath("//li[text()='Невалидно име/парола']"));

      WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait4.until(ExpectedConditions.visibilityOf(errorMessage));


       Assert.assertEquals(errorMessage.getText(), "Невалидно име/парола");
    }

     @DataProvider (name = "wrongUsers")
     public static Object [][] readUsersFromCsv(){
         try{
             CSVReader csvReader = new CSVReader(new FileReader("src/exam/resources/wrongUsers.csv"));
             List<String[]> csvData = csvReader.readAll();
             Object[] [] csvDataObj = new Object[csvData.size()][2];
             for (int i = 0; i < csvData.size(); i++){
                 csvDataObj[i] = csvData.get(i);
             }
             return csvDataObj;
         }catch (IOException e){
             System.out.println("Not Possible to find CSV!");
             return null;
         }
         catch (CsvException e){
             return null;
         }
     }
     }



