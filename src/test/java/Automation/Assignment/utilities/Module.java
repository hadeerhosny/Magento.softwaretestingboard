package Automation.Assignment.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Module extends Wait {
    WebDriver driver;

    public Module(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void scrollUp() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
    }

    public void scrollDown() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void pgDn() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
    }

    public void sendKey(String l) {
        driver.findElement(By.cssSelector("body")).sendKeys(l);
    }

    public void sendKeys(By locator, String data) {

        driver.findElement(locator).sendKeys(data);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateTo(String URL) {
        driver.get(URL);
    }

    public void hover(By locator) {
        Wait wait = new Wait(driver);
        Actions actions;
        wait.waitForVisibility(locator);
        actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).perform();
    }

    public boolean isDisplayed(By locator) {
        int size = driver.findElements(locator).size();
        return size >= 1;
    }
}
