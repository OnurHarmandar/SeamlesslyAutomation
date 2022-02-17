package net.seamlessly.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;

public class logoutStepDefs {

    @When("click on log out button")
    public void click_on_log_out_button() {
        new DashboardPage().logoutButton.click();
    }
    @Then("The user comes back to login page")
    public void the_user_comes_back_to_login_page() {
        Assert.assertTrue(new LoginPage().loginButton.isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @And("the user navigates to back")
    public void theUserNavigatesToBack() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(1);
    }

    @Then("the user comes back to login page again")
    public void theUserComesBackToLoginPageAgain() {
        Assert.assertTrue(new LoginPage().loginButton.isDisplayed());
    }
}
