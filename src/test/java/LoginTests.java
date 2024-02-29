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
    public void loginEmptyEmailPassword() {

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
    public void logoutTest() throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
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
        WebElement logoutButton = driver.findElement(By.xpath("//button[@data-title='Log out']"));
        logoutButton.click();

        Thread.sleep(2000);

        //Assertion
        WebElement loginForm = driver.findElement(By.xpath("//form[@data-testid='login-form']"));
        Assert.assertTrue(loginForm.isDisplayed());

        //Quit the browser
        driver.quit();


    }
    @Test
    public void loginValidEmailPassword() throws InterruptedException{

        navigateToKoel();
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[alt='Avatar of Koel']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
}
