import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{
    @Test
    public void changeProfileName() throws InterruptedException {

        //navigate to Koel
        navigateToKoel();
        //login with correct credentials 
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();
        Thread.sleep(5000);
        //click on avatar 
        clickAvatarIcon();
        Thread.sleep(2000);
        //Generate random usernames
        String randomName = generateRandomName();
        System.out.println("Random name is: " + randomName);
        //provide current password
        provideCurrentPassword("demo");
        Thread.sleep(2000);
        //Set the new profile name 
        provideProfileName(randomName);
        Thread.sleep(2000);
        //Click on Save 
        clickSave(); 
        Thread.sleep(2000);
        //Assertion 
        WebElement updateNotification = driver.findElement(By.xpath("//div[@class='message success']//main['Profile updated']"));
        
        System.out.println(updateNotification.getText());
        Assert.assertTrue(updateNotification.isDisplayed());
    }




}
