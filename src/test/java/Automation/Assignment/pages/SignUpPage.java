package Automation.Assignment.pages;

import Automation.Assignment.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By createAccountLink = By.xpath("//a[contains(text(),'Create an Account') and @href='https://magento.softwaretestingboard.com/customer/account/create/']");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");

    private By createAccountButton = By.cssSelector("button[title='Create an Account']");

    @FindBy(css= "[class=\"base\"]")
    private WebElement SuccessCreateAccount;

    // Click Create an Account link
    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }
    public void fillAccountDetails(String firstName, String lastName, String email, String password, String confirmPassword)throws InterruptedException{
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    public String successMessageForCompeleteAccount() {
        return SuccessCreateAccount.getText();
    }


    //.................................................................


    @FindBy(css= "[type=\"button\"]")
    private WebElement menuButton;

    @FindBy(css= "[class=\"authorization-link\"]")
    private WebElement logOut;

    public void logOutLink() {
        menuButton.click();
        logOut.click();
    }

    @FindBy(css= "[class=\"message-error error message\"]")
    private WebElement errorMessage;


    public String errorMessageEmailExsisting () {
        return errorMessage.getText();
    }

    //.............................................................................
    @FindBy(css= "[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"]")
    private WebElement logIn;

    @FindBy(css= "[name=\"login[username]\"]")
    private WebElement emailLogin;

    @FindBy(css= "[name=\"login[password]\"]")
    private WebElement passLogin;

    @FindBy(css= "[class=\"action login primary\"]")
    private WebElement logInButton;


    public void logInLink(String emailLogInField, String passLoginField) {
       logIn.click();
       emailLogin.sendKeys(emailLogInField);
       passLogin.sendKeys(passLoginField);
       logInButton.click();

    }


}
