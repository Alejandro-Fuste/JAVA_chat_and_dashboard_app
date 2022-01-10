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

    // View Pitches
    @FindBy(id = "")
    public WebElement viewPitchesButton;

    @FindBy(id = "")
    public WebElement pitchesTable;

    // Make Comment
    @FindBy(id = "")
    public WebElement businessIdInput;

    @FindBy(id = "")
    public WebElement pitchIdInput;

    @FindBy(id = "")
    public WebElement sharkIdInput;

    @FindBy(id = "")
    public WebElement commentInput;

    @FindBy(id = "")
    public WebElement postCommentButton;

    @FindBy(id = "")
    public WebElement commentPostSuccessMessage;

    // Make Offer
    @FindBy(id = "")
    public WebElement amountInput;

    @FindBy(id = "")
    public WebElement percentageInput;

    @FindBy(id = "")
    public WebElement postOfferButton;

    @FindBy(id = "")
    public WebElement offerPostSuccessMessage;

    // Accept Offer
    @FindBy(id = "")
    public WebElement sharkAcceptButton;

    @FindBy(id = "")
    public WebElement dealClosedMessage;

    // Logout
    @FindBy(id = "")
    public WebElement sharkLogoutButton;
}
