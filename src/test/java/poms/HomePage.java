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
    @FindBy(id = "")
    public WebElement newSharkProfileButton;

    @FindBy(id = "")
    public WebElement dropDownList;

    @FindBy(id = "")
    public WebElement sharkOption;

    @FindBy(id = "")
    public WebElement firstNameInput;

    @FindBy(id = "")
    public WebElement lastNameInput;

    @FindBy(id = "")
    public WebElement usernameInput;

    @FindBy(id = "")
    public WebElement passwordInput;

    @FindBy(id = "")
    public WebElement passwordReInput;

    @FindBy(id = "")
    public WebElement createSharkProfileButton;

    @FindBy(id = "")
    public WebElement createSharkProfileSuccessMessage;


    // Login
    @FindBy(id = "")
    public WebElement sharkLoginButton;
}
