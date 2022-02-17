package net.seamlessly.pages;

import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){PageFactory.initElements(Driver.get(),this);}

    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(css = "[class='warning wrongPasswordMsg']")
    public WebElement message;

    public void login(){
        String userName= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        Driver.get().get(ConfigurationReader.get("url"));
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
