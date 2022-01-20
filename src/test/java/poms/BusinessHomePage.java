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
    @FindBy(id = "businessLogoutEl")
    public WebElement businessLogoutButton;

//    @FindBy(id = "")
//    public WebElement businessIdInput;

    //  ------------------------------    MAKE A COMMENT   ------------------------------
    @FindBy(id = "commentBusiness")
    public WebElement commentInput;

    @FindBy(id = "commentButtonBiz")
    public WebElement commentButton;

    @FindBy(id = "commentModal")
    public WebElement commentModal;

    @FindBy(id = "chooseOption")
    public WebElement downArrow;

    @FindBy(css = "[value='1']")
    public WebElement receiver;

    @FindBy(id = "commentDateBiz")
    public WebElement enterDate;

    @FindBy(id = "sendButtonBiz")
    public WebElement postCommentButton;

    @FindBy(id = "commentSent")
    public WebElement commentPostSuccessMessage;

    @FindBy(id = "businessCommentModalClose")
    public WebElement businessCommentModalClose;

    @FindBy(id = "submitButton")
    public WebElement businessLoginButton;

    @FindBy(id = "businessPitchButton")
    public WebElement openAcceptModal;

    @FindBy(id = "acceptPitchButton")
    public WebElement acceptBidButton;

    @FindBy(id = "Accepted")
    public WebElement acceptPitchMessage;

    @FindBy(id = "acceptPitchCloseButton")
    public WebElement acceptPitchCloseButton;


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

    @FindBy(id = "validationCustom02")
    public WebElement enterAmount;

    @FindBy(id = "validationCustom03")
    public WebElement enterPercentage;

    @FindBy(id = "validationTextarea")
    public WebElement enterPitch;

    @FindBy(id = "pitchCreated")
    public WebElement clickSubmit;

    @FindBy(id = "commentSent")
    public WebElement pitchCreated;

//    @FindBy(id = "")
//    public WebElement enterPitch;

//  ----------------------------------------  EXCEPTIONS TESTING  -----------------------------------------

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
