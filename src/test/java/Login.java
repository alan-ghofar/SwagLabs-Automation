import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {
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
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"title\"]"))
        );

        driver.quit();
    }

    @Test
    public void problem_user(){
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
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"title\"]"))
        );

        driver.quit();
    }

    @Test
    public void locked_out_user(){
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
        driver.findElement(By.name("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
        );

        driver.quit();
    }

    @Test
    public void fail(){
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
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
        driver.findElement(By.xpath("//*[@id=\'login-button\']")).click();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
        );

        driver.quit();
    }
}
