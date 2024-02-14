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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    /**
     * Email: Valid
     * Password: Valid
     * @throws InterruptedException
     */
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navigation
        //Pre-Condition
        String url = "https://demo.koel.dev/";
        driver.get(url);
        //Step 1: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        Thread.sleep(2000);
        //Step 2: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        Thread.sleep(2000);
        //Step 3: Click on Login button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(5000);
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit The browser
        driver.quit();
    }

    /**
     * Email: Invalid
     * Password: Invalid
     * @throws InterruptedException
     */
    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navigation
        //Pre-Condition
        String url = "https://demo.koel.dev/";
        driver.get(url);
        //Step 1: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demos@koel.dev");
        Thread.sleep(2000);
        //Step 2: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("demos");
        Thread.sleep(2000);
        //Step 3: Click on Login button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(5000);
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit The browser
        driver.quit();
    }

    /**
     * Email: Invalid - Empty
     * Password: Invalid - Empty
     * @throws InterruptedException
     */
    @Test
    public void loginWithEmptyEmailPassword() throws InterruptedException {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navigation
        //Pre-Condition
        String url = "https://demo.koel.dev/";
        driver.get(url);
        //Step 1: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("");
        Thread.sleep(2000);
        //Step 2: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("");
        Thread.sleep(2000);
        //Step 3: Click on Login button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(5000);
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit The browser
        driver.quit();
    }

}
