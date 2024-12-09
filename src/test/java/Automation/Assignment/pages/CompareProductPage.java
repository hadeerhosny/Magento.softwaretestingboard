package Automation.Assignment.pages;

import Automation.Assignment.base.BasePage;
import Automation.Assignment.utilities.Module;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CompareProductPage extends BasePage {


    public void hover(By locator) {
        Actions actions;
        waitForVisibility(locator);
        actions = new Actions(driver);
        actions.moveToElement(compareProducts.findElement(locator)).perform();
    }
    public void click(By locator) {    driver.findElement(locator).click();}

    public WebElement waitForVisibility(By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public CompareProductPage(WebDriver driver) {
        super(driver);
    }

    private By firstProductAddToCompare = By.xpath("//img[@alt='Hero Hoodie']/../../../..//*[@class='action tocompare']");
    private By secondProductAddToCompare = By.xpath("//img[@alt='Radiant Tee']/../../../..//*[@class='action tocompare']");


    @FindBy(css = "[class=\"action compare\"]")
    private WebElement compareProducts;


    public void addTwoProductsToCompare() {
        Module module=new Module(driver);
        module.hover(By.xpath("//a[@title='Hero Hoodie']"));
        module.hover(By.xpath("//img[@alt='Hero Hoodie']/../../../..//*[@class='action tocompare']"));
        module.click(By.xpath("//img[@alt='Hero Hoodie']/../../../..//*[@class='action tocompare']"));
        module.hover(By.xpath("//a[@title='Radiant Tee']"));
        module.hover(By.xpath("//img[@alt='Radiant Tee']/../../../..//*[@class='action tocompare']"));
        module.click(By.xpath("//img[@alt='Radiant Tee']/../../../..//*[@class='action tocompare']"));
        module.hover(By.xpath("//li//a[@class='action compare']"));
        module.click(By.xpath("//li//a[@class='action compare']"));}

    }


