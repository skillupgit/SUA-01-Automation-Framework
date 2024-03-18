import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    static WebDriver driver;

    WebDriverWait wait;

    public FluentWait<WebDriver> fluentWait;

    Actions actions;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    //public String url = "https://demo.koel.dev/";

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    /*@BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseUrl) throws MalformedURLException {
        *//*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);*//*
        //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Explicit Wait setup
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Fluent Wait setup
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(250));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        navigateToKoel(baseUrl);
    }*/

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseUrl) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Explicit Wait setup
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        //Fluent Wait setup
        fluentWait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(250));
        getDriver().manage().window().maximize();
        actions = new Actions(getDriver());
        navigateToKoel(baseUrl);
    }


    /*@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }*/

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.206:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }
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
        getDriver().get(baseUrl);
    }
}