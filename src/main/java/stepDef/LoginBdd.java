package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginBdd extends env_target {
    @Given("User is on login page")
    public void user_is_on_login_page() {
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
    }

    @When("User fill username and password")
    public void user_fill_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login bottom")
    public void user_click_login_bottom() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User verify login result")
    public void user_verify_login_result() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"title\"]"))
        );
        driver.quit();
    }

    @When("User fill invalid username and password")
    public void user_fill_invalid_username_and_password() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
    }

    @Then("User get error message")
    public void user_get_error_message() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
        );
        driver.quit();
    }

    @When("^User input (.*) and (.*)$")
    public void user_input_username_and_password(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("^User get verify login (.*)$")
    public void userVerifyLoginResult(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if(result == "true"){
            wait.until(ExpectedConditions.or(
                            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"title\"]"))
                    ));
            driver.quit();
        } else if (result == "Failed") {
            wait.until(ExpectedConditions.or(
                            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
                    ));
        }
        driver.quit();
    }
}
