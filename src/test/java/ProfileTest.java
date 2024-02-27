import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        //navigate to Koel App
        navigateToKoel();
        //login Steps
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        Thread.sleep(2000);
        //click On avatar Icon to open Profile
        clickOnAvatartIcon();
        Thread.sleep(2000);
        // Generate a Random Name
        String randomName = generateRandomName();
        // Provide Current Password
        provideCurrentPassword("demo");
        Thread.sleep(2000);
        // Provide new profile name
        provideProfileName(randomName);
        Thread.sleep(2000);
        // click on save
        clickSaveBtn();
        Thread.sleep(500);
        //Assertion to check if success message shows up.
        WebElement updateNotificationMsg = driver.findElement(By.xpath("//div[@class = 'message success']//main['Profile updated']"));
        System.out.println(updateNotificationMsg.getText());
        Assert.assertTrue(updateNotificationMsg.isDisplayed());
    }

    //Helper Methods
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
        saveBtn.click();
    }

    public void provideProfileName(String newProfileName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newProfileName);
    }

    public void provideCurrentPassword(String currentPassword) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickOnAvatartIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("a.view-profile"));
        avatarIcon.click();
    }

}
