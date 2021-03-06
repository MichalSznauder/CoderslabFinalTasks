package ZadaniaZaliczeniowe;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.nio.file.FileStore;
import java.time.Duration;

public class FinalTask2 {

    public static void main(String[] args)  {



        String userEmail = "znqocowprtbwttvupo@nvhrw.com";
        String userPassword = "wertyq1";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //otwieranie strony www
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        //logowanie
        driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span")).click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(userEmail);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(userPassword);

        driver.findElement(By.id("submit-login")).click();



        //przycisk 'clothes'

        driver.findElement(By.cssSelector("#category-3 > a")).click();

        //wybieranie produktu
        driver.findElement(By.cssSelector("article.product-miniature:nth-child(2) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)")).click();


        // wyliczanie, czy rabat wynosi 20% poprzez try/catch
        /*
        WebElement regularPrice = driver.findElement(By.className("regular-price"));
        regularPrice.getText();
        double regularPriceDouble = Double.parseDouble(String.valueOf(regularPrice));

        WebElement discountedPrice = driver.findElement(By.className("price"));
        discountedPrice.getText();
        double discountedPriceDouble = Double.parseDouble(String.valueOf(discountedPrice));

        try {
            final boolean discountCheck = discountedPriceDouble != regularPriceDouble / 1.2;
        }
        catch (Exception e) {
            System.out.println("Discount is not 20%!");
        }
        */




        //wybieranie rozmiaru przez 'select by index'
        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByIndex(1);


        // wybieranie ilosci
        WebElement quantityField = driver.findElement(By.id("quantity_wanted"));
        quantityField.clear();
        quantityField.sendKeys("5");


        //dodawanie do koszyka
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")).click();

        //przycisk 'proceed to checkout'
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")).click();

        // ponownie przycisk 'checkout'
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")).click();


       // WebElement savedAddress = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[1]/article/header/label/div"));
        //savedAddress.getText();
        //Assertions.assertTrue();



        //wpisywanie danych adresowych
        driver.findElement(By.name("address1")).sendKeys("Jerozolimskie");
        driver.findElement(By.name("postcode")).sendKeys("01-591");
        driver.findElement(By.name("city")).sendKeys("Warsaw");
        driver.findElement(By.name("id_country")).sendKeys("United Kingdom");
        driver.findElement(By.name("phone")).sendKeys("0700 251 241");


        driver.findElement(By.name("confirm-addresses")).click();





        driver.findElement(By.id("delivery_option_1")).submit();



        //driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).submit();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"checkout-payment-step\"]/h1")).click();




        driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]")).click();


        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();

        driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")).click();


        //screenshot 1 metoda
        WebElement screenshot = driver.findElement(By.id("content"));
        screenshot.getScreenshotAs(OutputType.FILE);

       // File dest = new File(System.getProperty("user.dir") +    "/screenshots/elementLogo.png");

        //try {
         //   FileHandler.copy(source, dest);
      //  } catch (IOException exception) {
          //  exception.printStackTrace();

/*    screenshot 2 metoda
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File localizationFile = new File("screenshot.jpg");
        FileHandler.copy(file, localizationFile);

*/

        driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[2]/span")).click();

        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[3]/span")).click();

        //sprawdzanie payment status
       WebElement paymentStatus = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[4]/span"));
       paymentStatus.getText();


    }

}
