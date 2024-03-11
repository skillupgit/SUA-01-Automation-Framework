package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Elements
    By userAvatarIcon = By.cssSelector(".view-profile");


    //Helper Method
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }
}
