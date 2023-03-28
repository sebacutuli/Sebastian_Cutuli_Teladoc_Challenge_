package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public WebElement getElement(By locator)
    {
        return getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator)
    {
        return getDriver().findElements(locator);
    }
}
