package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SharkHomePage {
    private WebDriver driver;

    public SharkHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // get driver from this object
    }

    // Make Comment
    @FindBy(id = "commentButtonShark")
    public WebElement commentButtonShark;

    @FindBy(id = "commentModalShark")
    public WebElement commentModalShark;

    @FindBy(id = "reciepientfromShark")
    public WebElement commentDropdown;

    @FindBy(css = "[value='1']")
    public WebElement commentRecipient;

    @FindBy(id = "commentDateShark")
    public WebElement commentDateShark;

    @FindBy(id = "commentShark")
    public WebElement commentInput;

    @FindBy(id = "sendButtonShark")
    public WebElement sendCommentButton;

    @FindBy(id = "commentSent")
    public WebElement commentPostSuccessMessage;

    // Make Offer
    @FindBy(id = "pitchButtonShark")
    public WebElement pitchButtonShark;

    @FindBy(id = "pitchModalShark")
    public WebElement pitchModalShark;

    @FindBy(id = "validationCustom02")
    public WebElement amountInput;

    @FindBy(id = "validationCustom03")
    public WebElement percentageInput;

    @FindBy(id = "submitPitchButton")
    public WebElement submitOfferButton;

    @FindBy(id = "pitchSent")
    public WebElement pitchSent;

    // Accept Offer
    @FindBy(id = "statusButton")
    public WebElement sharkAcceptButton;

//    @FindBy(id = "pitchAccepted")
//    public WebElement acceptedMessage;

    // Logout
    @FindBy(id = "sharkLogoutEl")
    public WebElement sharkLogoutButton;

    // Exceptions
//    @FindBy(id = "invalid-feedback")
//    public WebElement nullValuesMessage;

//    @FindBy(id = "hideErrorMessage")
//    public WebElement usernameTakenMessage;
//
//    @FindBy(id = "hideErrorMessage")
//    public WebElement usernamePasswordIncorrectMessage;
}
