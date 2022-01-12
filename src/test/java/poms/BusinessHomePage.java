package poms;

import com.investing_app.entities.Pitch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessHomePage {

    private WebDriver driver;

    public BusinessHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // get driver from this object
    }

    //  ------------------------------    LOGOUT    -----------------------------------
    @FindBy(id = "logoutEl")
    public WebElement businessLogoutButton;

    @FindBy(id = "")
    public WebElement businessIdInput;

    //  ------------------------------    MAKE A COMMENT   ------------------------------
    @FindBy(id = "comment")
    public WebElement commentInput;

    @FindBy(id = "")
    public WebElement receiver;

    @FindBy(id = "commentDateBiz")
    public WebElement enterDate;

    @FindBy(id = "")
    public WebElement postCommentButton;

    @FindBy(id = "")
    public WebElement commentPostSuccessMessage;

    @FindBy(id = "submitButton")
    public WebElement businessLoginButton;

    @FindBy(id = "")
    public WebElement acceptBidButton;

    @FindBy(id = "")
    public WebElement acceptPitchMessage;

    @FindBy(id = "")
    public WebElement commentButton;
//
//    @FindBy(id = "")
//    public WebElement commentInput;
//
//    @FindBy(id = "")
//    public WebElement commentInput;
//
    //    ------------------------------------  Create Pitch ------------------------------------------
    @FindBy(id = "bizAddPitchButton")
    public WebElement clicksCreatePitchButton;

    @FindBy(id = "bizAddPitchButton")
    public WebElement enterAnotherDate;

    @FindBy(id = "")
    public WebElement enterAmount;

    @FindBy(id = "")
    public WebElement enterPercentage;

    @FindBy(id = "")
    public WebElement enterPitch;

    @FindBy(id = "pitchCreated")
    public WebElement clickSubmit;

    @FindBy(id = "commentSent")
    public WebElement pitchCreated;

//    @FindBy(id = "")
//    public WebElement enterPitch;

//  -----------------------  EXCEPTIONS --------------

    @FindBy(id = "")
    public WebElement nullValuesMessage;

    @FindBy(id = "")
    public WebElement tooLongMessage;

    @FindBy(id = "")
    public WebElement tooShortMessage;

    @FindBy(id = "")
    public WebElement incorrectDataTypeMessage;

    @FindBy(id = "")
    public WebElement usernameTakenMessage;

    @FindBy(id = "")
    public WebElement usernamePasswordIncorrectMessage;

    @FindBy(id = "pitchAmount")
    public WebElement amountInput;

}
