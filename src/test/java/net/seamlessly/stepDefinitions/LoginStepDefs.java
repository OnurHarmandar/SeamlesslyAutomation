package net.seamlessly.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

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

    @And("Press Enter button on keyboard")
    public void pressEnterButtonOnKeyboard() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @Then("Verify {string} massage is displayed")
    public void verifyMassageIsDisplayed(String message) {
        String actuallMessage=loginPage.message.getText();
        System.out.println("actuallMessage = " + actuallMessage);
        Assert.assertTrue(loginPage.message.isDisplayed());
    }

    @Given("the user logged in")
    public void the_user_logged_in() {
        new LoginPage().login();
    }
    @Given("the user clicks on Forgot password? button")
    public void theUserClicksOnForgotPasswordButton() {
        loginPage.forgotButton.click();
        BrowserUtils.waitFor(2);
    }


    @When("the user enters {string} email to user email input box")
    public void the_user_enters_email_to_user_email_input_box(String email) {
        loginPage.userEmail.sendKeys(email);
    }
    @When("the user clicks on Reset password button")
    public void the_user_clicks_on_Reset_password_button() {
        loginPage.resetBUtton.click();
    }
    @Then("Verify that message contains {string}")
    public void verify_that_message_contains(String Message) {
        System.out.println(loginPage.resetMessage.getAttribute("value"));
        Assert.assertTrue(loginPage.resetMessage.getAttribute("value").contains(Message));
    }


    @Then("verify that {string} is dissplayed on user input box")
    public void verifyThatIsDissplayedOnUserInputBox(String message) {

    }

    @Given("the user enters {string} to password input box")
    public void theUserEntersToPasswordInputBox(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("verify that {string} is dissplayed on {string}")
    public void verifyThatIsDissplayedOn(String message, String box) {
        String actualMessage="";
        if(box.equals("user input box")){
            actualMessage=loginPage.usernameInput.getAttribute("validationMessage");
            System.out.println(loginPage.usernameInput.getAttribute("validationMessage"));
        }else if(box.equals("password input box")){
            actualMessage=loginPage.passwordInput.getAttribute("validationMessage");
            System.out.println(loginPage.passwordInput.getAttribute("validationMessage"));
        }

        Assert.assertEquals(message,actualMessage);
    }

    @Given("the user enters {string} to username input box")
    public void theUserEntersToUsernameInputBox(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @Then("verify that username and password placeholders are dissplayed")
    public void verifyThatUsernameAndPasswordPlaceholdersAreDissplayed() {
        System.out.println("loginPage.usernameInput.getAttribute(\"id\") = " + loginPage.usernameInput.getAttribute("id"));
        String expectedLoginPlaceholder="Username or email";
        String actualLoginPlaceholder=loginPage.usernameInput.getAttribute("placeholder");
        String expectedPasswordPlaceholder="Password";
        String actualPasswordPlaceholder=loginPage.passwordInput.getAttribute("placeholder");
        Assert.assertEquals(expectedLoginPlaceholder,actualLoginPlaceholder);
        Assert.assertEquals(expectedPasswordPlaceholder,actualPasswordPlaceholder);

    }

    @Then("Veriy that username and password appears in a for of dots")
    public void veriyThatUsernameAndPasswordAppearsInAForOfDots() {
        String expectedUserText="text";
        String expectedPasswordText="password";
        String actualUserText=loginPage.usernameInput.getAttribute("type");
        String actualPasswordText=loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals(expectedUserText,actualUserText);
        Assert.assertEquals(expectedPasswordText,actualPasswordText);
    }
}
