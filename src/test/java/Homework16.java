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
        //Login with Credentials
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();
        //search for a song
        searchForSong("Blue Shadow");
        //click view all to display the search results
        clickViewAll();
        //click the first song in the search results
        clickFirstSong();
        //click ADD TO button
        clickAddToButton();
        //Choose skillup playlist and add song
        addToSkillupPlaylist();
        //Assertion

    }

    public void addToSkillupPlaylist() {
        WebElement skillUpPlaylist = driver.findElement(By.cssSelector(""));
        skillUpPlaylist.click();
    }

    public void clickAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector(""));
        addToButton.click();
    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector("div[class='playing selected song-item']"));
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
