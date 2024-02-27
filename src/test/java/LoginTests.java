import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test()
    public void testNavigationToKoel() {
        String url = "https://demo.koel.dev/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }

    /**
     * Email: Valid
     * Password: Valid
     * @throws InterruptedException
     */
    @Test()
    public void loginValidEmailPassword() throws InterruptedException {
        //Navigation
        //Pre-Condition
        navigateToKoel();
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }



    /**
     * Email: Invalid
     * Password: Invalid
     * @throws InterruptedException
     */
    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
        navigateToKoel();
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    /**
     * Email: Invalid - Empty
     * Password: Invalid - Empty
     * @throws InterruptedException
     */
    @Test
    public void loginWithEmptyEmailPassword() throws InterruptedException {
        navigateToKoel();
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }


}
