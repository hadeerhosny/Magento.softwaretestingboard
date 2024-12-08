package Automation.Assignment.testCases;

import Automation.Assignment.base.BasePage;
import Automation.Assignment.base.BaseTest;
import Automation.Assignment.factory.DriverFactory;
import Automation.Assignment.pages.CompareProductPage;
import Automation.Assignment.pages.HomePage;
import Automation.Assignment.pages.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccount extends BaseTest {

    private WebDriver driver;
    SignUpPage signUpPage = new SignUpPage(super.driver);
    HomePage homePage = new HomePage(super.driver);
    CompareProductPage compareProductPage  = new CompareProductPage(super.driver);



    @Test
    //Create New User
    public void createNewAccountTC1() throws InterruptedException {
        signUpPage.clickCreateAccountLink();
        signUpPage.fillAccountDetails("Ali", "Ahmed", "Ali9@gmail.com", "Test@#$2024", "Test@#$2024");
        signUpPage.clickCreateAccountButton();
        String ActualResult = signUpPage.successMessageForCompeleteAccount();
        Assert.assertEquals(ActualResult, "My Account");
    }

    @Test
    //Check you can't register with the same data
    public void checkCanNotLoginByTheSameDataTC2() throws InterruptedException {
        //signUpPage.logOutLink();
        signUpPage.clickCreateAccountLink();
        signUpPage.fillAccountDetails("Ali", "Ahmed", "Ali3@gmail.com", "Test@#$2024", "Test@#$2024");
        signUpPage.clickCreateAccountButton();
        String ActualResult = signUpPage.errorMessageEmailExsisting();
        Assert.assertEquals(ActualResult, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }


    //Navigate to Hot sellers in Home page
    @Test
    public void navigateToHotSellersTC3() throws InterruptedException {
        signUpPage.logInLink("Ali3@gmail.com", "Test@#$2024");
        homePage.clickHotSellers();
        String ActualResult = homePage.hotSellersMessage();
        Assert.assertEquals(ActualResult, "Hot Sellers");
    }

    //Add 2 products to compare list
    @Test
    public void addTwoProductsToCompareListTC4() throws InterruptedException {
          compareProductPage.addTwoProductsToCompare();
    }


}