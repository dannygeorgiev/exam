package Project;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class successfulLoginTest extends TestUtil {


    @Test(dataProvider = "correctUsers")
    public void successfulLogin(String userName, String password) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);


        WebElement profileDropdown = driver.findElement(By.xpath("//div[@class='profile-dropdown has-dd']"));
        WebElement bannersCarrousel = driver.findElement(By.className("banners-container"));


        //Asserts
        Assert.assertTrue(profileDropdown.isDisplayed(), "Profile dropdown menu was not displayed");
        Assert.assertTrue(bannersCarrousel.isDisplayed(), "Banners carrousel was not displayed");
    }
    @DataProvider(name = "correctUsers")
    public static Object [][] readUsersFromCsv(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/exam/resources/correctUsers.csv"));
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
