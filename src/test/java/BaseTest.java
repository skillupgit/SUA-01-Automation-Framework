import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    WebDriverWait wait;

    public FluentWait<WebDriver> fluentWait;

    Actions actions;

    //public String url = "https://demo.koel.dev/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Explicit Wait setup
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Fluent Wait setup
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(250));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        navigateToKoel(baseUrl);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //Data Provider for Test Cases
   /* @DataProvider(name = "NegativeLoginTestData")
    public Object[][] getDataFromDataProviders(){
        return new Object[][] {
                //{"demo@koel.dev","demo"},
                {"demo1@koel.dev","demos"},
                {"demo@koel.dev","demos"},
                {"",""},
        };
    }*/

    //Helper Methods

    public void clickLoginBtn() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
                //driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
                //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
                //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToKoel(String baseUrl) {
        //String url = "https://demo.koel.dev/";
        driver.get(baseUrl);
    }
}