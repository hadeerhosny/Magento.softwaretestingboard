package Automation.Assignment.pages;

import Automation.Assignment.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By hotSellersSection = By.linkText("Hot Sellers");
    public void clickHotSellers() {
        driver.findElement(hotSellersSection).click();
    }
   @FindBy(css= "[class=\"title\"]")
    private WebElement hotSellers;
    public String hotSellersMessage () {
        return hotSellers.getText();
    }


}
