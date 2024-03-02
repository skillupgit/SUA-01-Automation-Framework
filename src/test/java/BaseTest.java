import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

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
        driver.manage().window().maximize();
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
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToKoel(String baseUrl) {
        //String url = "https://demo.koel.dev/";
        driver.get(baseUrl);
    }
}