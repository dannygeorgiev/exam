package Project;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class ProductsAddToCartTest extends TestUtil {
    @Test (dataProvider = "productName")
    public void successfulProductsAddToCart(String productName) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct(productName);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, productName);
        String actualProductName = searchResultsPage.getFirstProduct();
        Assert.assertEquals(actualProductName, productName);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        String actualProductPrise = productPage.getProductPrise();

        String itemCountText = productPage.getCartItemCount();
        Assert.assertEquals(itemCountText.trim(), actualProductPrise + "\n" + "1 Продукт");




        }

    @DataProvider(name = "productName")
   // public static Object [][] readUsersFromCsv(){
   //     try{
   //         CSVReader csvReader = new CSVReader(new FileReader("src/exam/resources/products.csv"));
   //         List<String[]> csvData = csvReader.readAll();
   //         Object[] [] csvDataObj = new Object[csvData.size()][1];
   //         for (int i = 0; i < csvData.size(); i++){
   //             csvDataObj[i][0] = csvData.get(i)[0];
   //         }
    //        return csvDataObj;
      //  }catch (IOException e){
      //      System.out.println("Not Possible to find CSV!");
      //      return null;
      //  }
      //  catch (CsvException e){
      //      return null;
      //  }
    public Object[][] products() {
        return new Object[][]{{"Царевичен Чипс Takis XtraHot Червен Лют Пипер и Лайм Пикантен"},
                {"Еклери Délifrance Шоколад 8 бр"}};
           }
    }







