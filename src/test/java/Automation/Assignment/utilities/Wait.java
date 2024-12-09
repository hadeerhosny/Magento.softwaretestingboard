package Automation.Assignment.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    WebDriver driver;
    WebDriverWait wait;
    private static final Duration waitTime = Duration.ofSeconds(10);
    private static final Duration pollingTime = Duration.ofMillis(500);


    public Wait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitToLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/app-root/app-loader")));
    }

    public void waitPresenceOfElement(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public boolean elementIsPresent(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void waitElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> waitt = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return waitt.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public WebElement waitForElementToBeClickable(WebElement element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public WebElement waitForVisibility(By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForVisibility(WebElement element) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForUnVisibility(By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBePresent(By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findElement(By locator) {
        return waitForElementToBePresent(locator);
    }

}
