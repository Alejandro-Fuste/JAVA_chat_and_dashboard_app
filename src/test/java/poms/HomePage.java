package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // get driver from this object
    }

    // Create Profile
//    @FindBy(id = "")
//    public WebElement newBusinessProfileButton;

    @FindBy(css = "[value='Shark']")
    public WebElement sharkOption;

    @FindBy(css = "[value='Business']")
    public WebElement businessOption;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userName")
    public WebElement usernameInput;

    //  Dont see PW
    @FindBy(id = "signupPassword")
    public WebElement passwordInput;

    @FindBy(id = "roleSignIn")
    public WebElement dropDownList;

    @FindBy(id = "submitSignUpButton")
    public WebElement createBusinessProfileButton;

    @FindBy(id = "successProfile")
    public WebElement createBusinessProfileSuccessMessage;

    // Login
    @FindBy(id = "submitButton")
    public WebElement loginButton;

    @FindBy(id = "businessName")
    public WebElement businessNameInput;

    @FindBy(id = "submitSignUpButton")
    public WebElement submitProfileButton;

    @FindBy(id = "userName")
    public WebElement loginUsernameInput;

    @FindBy(id = "password")
    public WebElement loginPasswordInput;

    @FindBy(id = "errorMessage")
    public WebElement errorMessage;
}
