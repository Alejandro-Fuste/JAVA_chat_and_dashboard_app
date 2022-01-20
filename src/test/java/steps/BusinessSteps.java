package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import runner.TestRunner;

public class BusinessSteps {
    // HOME PAGE

    // ------------------create profile-------------------------------
    @Given("The user is on the signup page")
    public void the_user_is_on_the_signup_page() {
        TestRunner.driver.get("file:///Users/dlanderos/JAVA_investing_app/signup.html");
    }

    @When("The user enters their first name")
    public void the_user_enters_their_first_name() {
        TestRunner.homePage.firstNameInput.sendKeys("Kevin");
    }

    @When("The user enters their last name")
    public void the_user_enters_their_last_name() {
        TestRunner.homePage.lastNameInput.sendKeys("O'Leary");
    }

    @When("The user enters their business name")
    public void the_user_enters_their_business_name() {
        TestRunner.homePage.businessNameInput.sendKeys("O'Leary");
    }

    @When("The user enters their username")
    public void the_user_enters_their_username() {
        TestRunner.homePage.usernameInput.sendKeys("Wayne100");
    }

    @When("The user enters their password")
    public void the_user_enters_their_password() {
        TestRunner.homePage.passwordInput.sendKeys("wonders123");
    }

    @When("The user clicks on drop down list")
    public void the_user_clicks_on_drop_down_list() {
        TestRunner.homePage.dropDownList.click();
    }

    @When("The user clicks on Business")
    public void the_user_clicks_on_business() {
        TestRunner.homePage.businessOption.click();
    }

    @When("The user clicks on the submit profile button")
    public void the_user_clicks_on_the_submit_profile_button() {
        TestRunner.homePage.submitProfileButton.click();
    }

    @Then("The user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Home");
    }

    // ---------------------------Sign In  DONE ------------------------------------
    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/home.html");
    }

    @When("The user enters their login username")
    public void the_user_enters_their_login_username() {
        TestRunner.homePage.usernameInput.sendKeys("Wayne100");
    }

    @When("The user enters their login password")
    public void the_user_enters_their_login_password() {
        TestRunner.homePage.loginPasswordInput.sendKeys("ImBatman");
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        TestRunner.homePage.loginButton.click();
    }

    @Then("The business is redirected to the business page")
    public void the_business_is_redirected_to_the_business_page() throws InterruptedException {
        Thread.sleep(1000);
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Business");
    }

    // ---------------------------------LOGOUT----------------------------------------

    @Given("The business is on the business page")
    public void the_business_is_on_the_business_page() throws InterruptedException {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Business");
    }

    @When("The business clicks log out")
    public void the_business_clicks_log_out() {
        TestRunner.businessHomePage.businessLogoutButton.click();
    }

    @Then("The user should be redirected to the home page")
    public void the_user_should_be_redirected_to_home_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Home");
    }
    // --------------------------MAKE A COMMENT--------------------------------

    @When("The business clicks on the comment button")
    public void the_business_clicks_on_the_comment_button() {
        TestRunner.businessHomePage.commentButton.click();
    }

    @When("The comment modal is displayed")
    public void the_comment_modal_is_displayed() {
        TestRunner.businessHomePage.commentModal.isDisplayed();
    }

    @When("The business clicks on drop down list")
    public void the_business_clicks_on_drop_down_list() throws InterruptedException {
        Thread.sleep(1000);
        TestRunner.businessHomePage.downArrow.click();
    }

    @When("The business clicks on the recipient")
    public void the_business_clicks_on_the_recipient() {
        TestRunner.businessHomePage.receiver.click();
    }

    @When("The business enters a date")
    public void the_business_enters_a_date() {
        TestRunner.businessHomePage.enterDate.sendKeys("2022/01/11");
    }

    @When("The business enters a comment")
    public void the_manager_enters_a_comment() {
        TestRunner.businessHomePage.commentInput.sendKeys("I am interested in your idea!");
    }

    @When("The business clicks send")
    public void the_manager_clicks_send() {
        TestRunner.businessHomePage.postCommentButton.click();
    }

    @When("A message saying comment post was successful appears")
    public void a_message_saying_post_was_successful_appears() throws InterruptedException {
        Thread.sleep(1000);
        TestRunner.businessHomePage.commentPostSuccessMessage.isDisplayed();
    }

    @Then("The business clicks the close button")
    public void the_business_clicks_the_close_button() {
        TestRunner.businessHomePage.businessCommentModalClose.click();
    }
//    ----------------------- Accept offer ----------------------------------

    @When("The business clicks on the open accept modal")
    public void the_business_clicks_on_the_open_accept_modal() {
        TestRunner.businessHomePage.openAcceptModal.click();
    }

    @When("The business clicks the accept bid button")
    public void the_business_clicks_the_accept_bid_button() throws InterruptedException {
        Thread.sleep(1000);
        TestRunner.businessHomePage.acceptBidButton.click();
    }

    @Then("The business clicks on the accept pitch close button")
    public void message_appears_saying_accepted() throws InterruptedException {
        TestRunner.businessHomePage.acceptPitchCloseButton.click();
    }

    //    ----------------------- View all comments DONE ----------------------------------

    @Then("A table opens up and the information is shown")
    public void a_table_opens_up_and_the_information_is_shown() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Business");
    }

    //    ----------------------- View original pitch DONE ----------------------------------

    @Then("The table autopopulates")
    public void the_table_atopopulates() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Business");
    }

    //  ------------------------- Create Pitch ----------------------------

    @Given("The business is on the business home page")
    public void the_business_is_on_the_business_home_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/business.html");
    }

    @When("The business clicks the create pitch button")
    public void the_business_clicks_the_create_pitch_button() {
        TestRunner.businessHomePage.clicksCreatePitchButton.click();
    }

    @When("The business enters the date")
    public void the_business_enters_the_date() {
        TestRunner.businessHomePage.enterAnotherDate.sendKeys("2022/01/11");
    }

    @When("The business enters their amount")
    public void the_business_enters_their_amount() {
        TestRunner.businessHomePage.enterAmount.sendKeys("5500.00");
    }

    @When("The business enters their percentage")
    public void the_business_enters_their_percentage() {
        TestRunner.businessHomePage.enterPercentage.sendKeys("20.00");
    }

    @When("The business enters their pitch")
    public void the_business_enters_their_pitch() {
        TestRunner.businessHomePage.enterPitch.sendKeys("This is my pitch");
    }

    @When("The business clicks submit")
    public void the_business_clicks_submit() {
        TestRunner.businessHomePage.clickSubmit.click();
    }

    @Then("A message says Pitch offer was created")
    public void a_message_says_pitch_offer_was_created() {
        Assert.assertEquals(TestRunner.businessHomePage.pitchCreated.getText(), "Comment was sent!");
    }

    //    ------------------------  EXCEPTIONS BELOW -----------------------------------

    @When("The user enters too long of a username")
    public void the_user_enters_too_long_of_a_username() {
        TestRunner.homePage.usernameInput.sendKeys("MrWonderfulissowonderful");
    }

    @Then("An alert pops up saying the entry has exceeded the allowed length")
    public void an_alert_pops_up_saying_the_entry_has_exceeded_the_allowed_length() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }

    @When("The user enters too short of a username")
    public void the_user_enters_too_short_of_a_username() {
        TestRunner.homePage.usernameInput.sendKeys("Mr");
    }

    @Then("An alert pops up saying the entry has not met the allowed minimum length")
    public void an_alert_pops_up_saying_the_entry_has_not_met_the_allowed_minimum_length() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }

    @When("The user enters non-alphabet characters as their first name")
    public void the_user_enters_non_alphabet_characters_as_their_first_name() {
        TestRunner.homePage.firstNameInput.sendKeys("92834hgd");
    }

    @Then("An alert pops up saying the entry has incorrect data type")
    public void an_alert_pops_up_saying_the_entry_has_incorrect_data_type() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }

    @When("The business enters non-numeric characters for an amount")
    public void the_business_enters_non_numeric_characters_for_an_amount() {
        TestRunner.businessHomePage.amountInput.sendKeys("kalsjo");
    }

    @Then("An alert pops up saying the username entered is already taken")
    public void an_alert_pops_up_saying_the_username_entered_is_already_taken() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }

    @Then("An alert pops up saying form cannot accept null values")
    public void an_alert_pops_up_saying_form_cannot_accept_null_values() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }

    @Then("An error message appears")
    public void an_error_message_appears() throws InterruptedException {
        Thread.sleep(1000);
        TestRunner.homePage.errorMessage.isDisplayed();
    }

    @When("The user enters incorrect password")
    public void the_user_enters_incorrect_password() {
        TestRunner.homePage.loginPasswordInput.sendKeys("uuuuuuuuuu");
    }

    @Then("An alert pops up saying either username or password or both are incorrect")
    public void an_alert_pops_up_saying_either_username_or_password_or_both_are_incorrect() {
        TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
    }
}
