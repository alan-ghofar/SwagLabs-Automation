import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class username_standart_user extends env_target {
   @Test
   public void failed(){
       //set driverlocation path
       System.setProperty("webdriver.microsoft-edge.driver","F:\\QA Testing\\untitled\\src\\main\\resources\\msedgedriver.exe");
       driver = new EdgeDriver();
       //maximize driver
       driver.manage().window().maximize();
       //Set Url
       driver.get(urlSwagLabs);

       Duration duration = Duration.ofSeconds(10);
       WebDriverWait wait = new WebDriverWait(driver, duration);

       wait.until(
               ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login-button\"]"))
       );
       //Login
       driver.findElement(By.name("user-name")).sendKeys("standard_user");
       driver.findElement(By.id("password")).sendKeys("secret_sauc");
       driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

       wait.until(
               ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"))
       );

       driver.quit();
   }

    @Test
    public void main(){
        //set driverlocation path
        System.setProperty("webdriver.microsoft-edge.driver","F:\\QA Testing\\untitled\\src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //Set Url
        driver.get(urlSwagLabs);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login-button\"]"))
        );
        //Login
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"title\"]"))
        );

        //Bottom add product in dashboard inventory
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))
        );

        //Bottom remove product in dashboard inventory
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))
        );

        //Inventory-Item
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"inventory_item_container\"]"))
        );

        //Bottom add product in dashboard inventory-item
        driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))
        );

//        //Bottom remove product in dashboard inventory-item
//        driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
//        wait.until(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))
//        );

        //Product add in chart
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))
        );

        //Product remove from chart
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))
        );


        driver.quit();
    }
}
