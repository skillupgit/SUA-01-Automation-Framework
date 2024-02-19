import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void navigateToKoel() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Wait
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigation
        //Pre condition - Have login page open
        String url = "https://demo.koel.dev/";
        driver.get(url);

        //Locators
        //Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        Thread.sleep(2000);
        //Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        Thread.sleep(2000);
        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        loginButton.click();

        Thread.sleep(5000);

        //Assertion - Expected vs Actual result
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit the browser
        driver.quit();
    }
    @Test
    public void logoutTest() throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Wait
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigation
        //Pre condition - Have login page open
        String url = "https://demo.koel.dev/";
        driver.get(url);

        //Locators
        //Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        Thread.sleep(2000);
        //Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        Thread.sleep(2000);
        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        loginButton.click();

        Thread.sleep(5000);

        //Click on logout button
        WebElement logoutButton = driver.findElement(By.cssSelector("i[class = 'fa fa-sign-out']"));
        logoutButton.click();

        //Assertion
        WebElement loginButton1 = driver.findElement(By.cssSelector("button[type = 'submit']"));
        Assert.assertTrue(loginButton1.isDisplayed());

        //Quit the browser
        driver.quit();


    }


    /**
     * Email:invalid and Password; Invalid
     * @throws InterruptedException
     */
    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Wait
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigation
        //Pre condition - Have login page open
        String url = "https://demo.koel.dev/";
        driver.get(url);

        //Locators
        //Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("demos@koel.dev");
        Thread.sleep(2000);
        //Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("demos");
        Thread.sleep(2000);
        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        loginButton.click();

        Thread.sleep(5000);

        //Assertion - Expected vs Actual result
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit the browser
        driver.quit();
    }

    /**
     * Email: Empty
     * Password: Empty
     * @throws InterruptedException
     */
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Wait
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigation
        //Pre condition - Have login page open
        String url = "https://demo.koel.dev/";
        driver.get(url);

        //Locators
        //Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("");
        Thread.sleep(2000);
        //Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("");
        Thread.sleep(2000);
        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        loginButton.click();

        Thread.sleep(5000);

        //Assertion - Expected vs Actual result
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit the browser
        driver.quit();
    }
}
