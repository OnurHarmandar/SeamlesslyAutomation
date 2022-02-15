package net.seamlessly.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    @Given("the user navigates to login page")
    public void the_user_navigates_to_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters following credentials")
    public void the_user_enters_following_credentials(Map<String,String> credentials) {
        loginPage.usernameInput.sendKeys(credentials.get("username"));
        loginPage.passwordInput.sendKeys(credentials.get("password"));
    }


    @When("click on login button")
    public void click_on() {
        loginPage.loginButton.click();
    }
    @Then("Verify that user is on {string} page")
    public void verify_that_user_is_on_page(String page) {
        String title = Driver.get().getTitle();
        Assert.assertTrue(title.contains("Files"));
    }
    @When("click on user avatar")
    public void clickOnUserAvatar() {
        dashboardPage.avatarIcon.click();
    }



    @Then("Verify that {string} is displayed in dropdown")
    public void verifyThatIsDisplayedInDropdown(String expectedUsername) {
        expectedUsername=ConfigurationReader.get("username");
        String actualUsername=dashboardPage.usernameTitle.getText();
        Assert.assertEquals("Verify username title",expectedUsername,actualUsername);
    }
}
