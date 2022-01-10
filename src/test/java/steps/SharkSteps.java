package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class SharkSteps {

    // HOME PAGE
    // create profile
    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/home.html");
    }

    @When("The user clicks on the new shark profile button")
    public void the_user_clicks_on_the_new_shark_profile_button() {
        TestRunner.homePage.newSharkProfileButton.click();
    }

    @When("The user clicks on drop down list")
    public void the_user_clicks_on_drop_down_list() {
        TestRunner.homePage.dropDownList.click();
    }

    @When("The user clicks on Shark")
    public void the_user_clicks_on_shark() {
        TestRunner.homePage.sharkOption.click();
    }

    @When("The user enters their first name")
    public void the_user_enters_their_first_name() {
        TestRunner.homePage.firstNameInput.sendKeys("Kevin");
    }

    @When("The user enters their last name")
    public void the_user_enters_their_last_name() {
        TestRunner.homePage.lastNameInput.sendKeys("O'Leary");
    }

    @When("The user enters their username")
    public void the_user_enters_their_username() {
        TestRunner.homePage.usernameInput.sendKeys("MrWonderful");
    }

    @When("The user enters their password")
    public void the_user_enters_their_password() {
        TestRunner.homePage.passwordInput.sendKeys("Wonders1");
    }

    @When("The user re-enters their password")
    public void the_user_re_enters_their_password() {
        TestRunner.homePage.passwordReInput.sendKeys("Wonders1");
    }

    @When("The user clicks on the create profile button")
    public void the_user_clicks_on_the_create_profile_button() {
        TestRunner.homePage.createSharkProfileButton.click();
    }

    @Then("A message saying shark profile created successfully appears")
    public void a_message_saying_account_created_successfully_appears() {
        Assert.assertEquals(TestRunner.homePage.createSharkProfileSuccessMessage.getText(),
                "Shark profile created successfully!");
    }


    // Login
    @When("The user clicks on the shark login button")
    public void the_user_clicks_on_the_login_button() {
        TestRunner.homePage.sharkLoginButton.click();
    }

    @Then("The shark should be redirected to the shark page")
    public void the_shark_should_be_redirected_to_the_shark_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shark");
    }


    // SHARK HOME PAGE
    // View pitches
    @Given("The shark is on the shark page")
    public void the_shark_is_on_the_shark_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/shark");
    }

    @When("The sharks clicks on view pitches button")
    public void the_sharks_clicks_on_view_pitches_button() {
        TestRunner.sharkHomePage.viewPitchesButton.click();
    }

    @Then("A table with the investment pitches is rendered")
    public void a_table_with_the_investment_pitches_is_rendered() {
        TestRunner.sharkHomePage.pitchesTable.isDisplayed();
    }

    // Make comment
    @When("The shark enters the business ID")
    public void the_shark_enters_the_business_id() {
        TestRunner.sharkHomePage.businessIdInput.sendKeys("1");
    }

    @When("The shark enters the pitch ID")
    public void the_shark_enters_the_pitch_id() {
        TestRunner.sharkHomePage.pitchIdInput.sendKeys("1");
    }

    @When("The shark enters their shark ID")
    public void the_shark_enters_their_shark_id() {
        TestRunner.sharkHomePage.sharkIdInput.sendKeys("1");
    }

    @When("The shark enters a comment")
    public void the_manager_enters_a_comment() {
        TestRunner.sharkHomePage.commentInput.sendKeys("I am interested in your idea!");
    }

    @When("The shark clicks on the comment post button")
    public void the_manager_clicks_on_the_comment_post_button() {
        TestRunner.sharkHomePage.postCommentButton.click();
    }

    @Then("A message saying comment post was successful appears")
    public void a_message_saying_post_was_successful_appears() {
        Assert.assertEquals(TestRunner.sharkHomePage.commentPostSuccessMessage.getText(),
                "Comment was successfully posted");
    }


    // Make offer
    @When("The shark enters an amount")
    public void the_shark_enters_an_amount() {
        TestRunner.sharkHomePage.amountInput.sendKeys("100_000");
    }

    @When("The shark enters a percentage")
    public void the_shark_enters_a_percentage() {
        TestRunner.sharkHomePage.percentageInput.sendKeys("5.4");
    }

    @When("The shark clicks on the offer post button")
    public void the_shark_clicks_on_the_offer_post_button() {
        TestRunner.sharkHomePage.postOfferButton.click();
    }

    @Then("A message saying offer post was successful appears")
    public void a_message_saying_offer_post_was_successful_appears() {
        Assert.assertEquals(TestRunner.sharkHomePage.offerPostSuccessMessage.getText(),
                "Offer was successfully posted!");
    }


    // Accept offer
    @When("The shark clicks on the accept button")
    public void the_shark_clicks_on_the_accept_button() {
        TestRunner.sharkHomePage.sharkAcceptButton.click();
    }

    @Then("A message saying deal is closed appears")
    public void a_message_saying_deal_is_closed_appears() {
        Assert.assertEquals(TestRunner.sharkHomePage.dealClosedMessage.getText(),
                "Deal closed!");
    }


    // Logout
    @When("The shark clicks on the logout button")
    public void the_shark_clicks_on_the_logout_button() {
        TestRunner.sharkHomePage.sharkLogoutButton.click();
    }

    @Then("The user should be redirected to home page")
    public void the_user_should_be_redirected_to_home_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Home");
    }
}
