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
public class Homework16 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //Navigate to Koel
        navigateToKoel();
        Thread.sleep(2000);
        //Login with Credentials
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();
        Thread.sleep(2000);
        //search for a song
        searchForSong("Blue Shadow");
        Thread.sleep(2000);
        //click view all to display the search results
        clickViewAll();
        Thread.sleep(2000);
        //click the first song in the search results
        clickFirstSong();
        Thread.sleep(2000);
        //click ADD TO button
        clickAddToButton();
        Thread.sleep(2000);
        //Choose skillup playlist and add song
        addToSkillupPlaylist();
        Thread.sleep(2000);
        //Assertion
        WebElement messageSuccess = driver.findElement(By.xpath("//main[text() = 'Added 1 song into \"skillup.\"']"));
        Assert.assertTrue(messageSuccess.isDisplayed());

        //Quit Browser
        driver.quit();

    }

    public void addToSkillupPlaylist() {
        WebElement skillUpPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper'] //li[text() = 'skillup']"));
        skillUpPlaylist.click();
    }

    public void clickAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector("#songResultsWrapper button[green]"));
        addToButton.click();
    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector("span[class='title text-primary']"));
        firstSong.click();
    }

    public void clickViewAll() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-testid='view-all-songs-btn']"));
        viewAllButton.click();
    }

    public void searchForSong(String songName) {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(songName);
    }
}
