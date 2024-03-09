import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{

    @Test
    public void playSongWithContextClick() throws InterruptedException {
        //Login
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        //choose all Songs List
        chooseAllSongsList();
        Thread.sleep(2000);
        //Context Click the first Songs
        contextClickFirstSong();
        Thread.sleep(2000);
        //choose play option
        choosePlayOption();
        Thread.sleep(2000);
        //Assert song is playing
        Assert.assertTrue(isSongPlaying());

    }

    @Test
    public void addSongToFavorites() throws InterruptedException {
        //login
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLoginBtn();
        Thread.sleep(2000);
        //choose all songs list
        chooseAllSongsList();
        Thread.sleep(2000);
        //Context click a song
        contextClickSong("1984");
        Thread.sleep(2000);
        //Hover the mouse to 'Add to' option in Context Menu
        hoverAddToOption();
        Thread.sleep(2000);
        //choose Favorites Playlist
        chooseContextFavoritesPlaylist();
        Thread.sleep(2000);
        //open Favorites playlist
        openFavoritesPlaylist();
        Thread.sleep(4000);
        //Assert that the song is present in the favorites playlist
        //Assert.assertTrue(isSongInFavorites("1984"));
    }

    public boolean isSongInFavorites(String songName){ //section[@id='favoriteWrapper']
        WebElement songInFavoriteList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='title text-primary'][text()='"+songName+"']")));
        return songInFavoriteList.isDisplayed();
    }

    public void openFavoritesPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='playlists']//a[@href='#/favorites']"))).click();
    }

    public void chooseContextFavoritesPlaylist() {
        WebElement favoritesPlaylistContextOption = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@class='has-sub']//li[text()='Favorites']")));
        actions.moveToElement(favoritesPlaylistContextOption).perform();
        favoritesPlaylistContextOption.click();
    }
    //Helper Methods

    public void hoverAddToOption() {
        WebElement addToContextOption = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//nav[@data-testid='song-context-menu']//li[@class='has-sub']")));
        actions.moveToElement(addToContextOption).perform();
    }




    public void contextClickSong(String songName) {
        WebElement songInAllSongs = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songsWrapper']//span[@class='title text-primary'][text()='"+songName+"']")));
        actions.contextClick(songInAllSongs).perform();
    }

    public boolean isSongPlaying(){
        WebElement soundDiskSpinning = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='song-info playing']")));
        return soundDiskSpinning.isDisplayed();
    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//nav[@data-testid='song-context-menu']//span"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongInAllSongs = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@data-testid='song-item'][1]")));
        actions.contextClick(firstSongInAllSongs).perform();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a//span[text()='All Songs']"))).click();
    }

}
