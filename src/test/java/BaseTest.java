import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver;

    public String url = "https://demo.koel.dev/";
    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void navigateToKoel(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }

    public void loginToKoel() throws InterruptedException {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

    }

    public void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);


    }

    public void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);


    }

    //Profile Test Helper Methods

    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String newName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void provideCurrentPassword(String currentPassword) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);

    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");

    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("a.view-profile"));
        avatarIcon.click();

    }


    public void loginValidEmailPassword() throws InterruptedException{


        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();

        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[alt='Avatar of Koel']"));
        //Assert.assertTrue(avatarIcon.isDisplayed());

    }


}

