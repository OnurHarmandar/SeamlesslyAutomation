package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    @FindBy(css = "[class='avatardiv avatardiv-shown']")
    public WebElement avatarIcon;

    @FindBy(css = "[class='user-status-menu-item__header']")
    public WebElement usernameTitle;
}
