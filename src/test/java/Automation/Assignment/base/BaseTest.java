package Automation.Assignment.base;

import Automation.Assignment.factory.DriverFactory;
import Automation.Assignment.pages.HomePage;
import Automation.Assignment.pages.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverFactory{

    public WebDriver driver = new ChromeDriver();;

   // @BeforeMethod
    //public void setup() {

      //  driver = new DriverFactory().initialization();

    //}
    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = new DriverFactory().initialization(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

