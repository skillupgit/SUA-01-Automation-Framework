import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void PlaySong() throws InterruptedException {
        //Navigate to Koel
        navigateToKoel();
        Thread.sleep(2000);
        //Login to Koel
        loginValidEmailPassword();
        Thread.sleep(2000);
        //Click Play button (media player controls)
        clickPlayButton();
        Thread.sleep(2000);
        //Assertion - if the album thumbnail is spinning or pause button is displayed
        WebElement pauseDisplayed = driver.findElement(By.cssSelector("button[class='playing']"));
        Assert.assertTrue(pauseDisplayed.isDisplayed());
    }

    public void clickPlayButton() {
        WebElement playBtn = driver.findElement(By.cssSelector("button[class='stopped']"));
        playBtn.click();
    }


}
