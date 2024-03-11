import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test()
    public void testNavigationToKoel() {
        String url = "https://demo.koel.dev/";
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    /**
     * Email: Valid
     * Password: Valid
     * @throws InterruptedException
     */
    @Test()
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //Assertions (Expected VS Actual)
        //Explicit Wait Example
        //WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
        //With Fluent Wait
        WebElement avatarIcon = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
        //driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }



    /**
     * Email: Invalid
     * Password: Invalid
     * @throws InterruptedException
     */
    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
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
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //Assertions (Expected VS Actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    //Negative Test Method using DataProvider
    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass=TestDataProvider.class)
    public void negativeLoginTests(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
        //Assertion
        String expectedUrl = "https://demo.koel.dev/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    //Login Example using Page Object Model
    @Test
    public void loginTest(){
        //Page Object
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Test Steps
        loginPage.provideEmail("demo@koel.dev");
        loginPage.providePassword("demo");
        loginPage.clickLoginBtn();
        //Assertions
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }


}
