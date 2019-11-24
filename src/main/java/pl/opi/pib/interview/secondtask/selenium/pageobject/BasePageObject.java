package pl.opi.pib.interview.secondtask.selenium.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.opi.pib.interview.secondtask.selenium.config.SeleniumConfig;

public class BasePageObject {
    protected SeleniumConfig config;

    public BasePageObject(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(config.getDriver(), this);
    }

    protected void executeJavaScript(String script, WebElement element){
        ((JavascriptExecutor) config.getDriver()).executeScript(script, element);
    }

    public boolean isElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(config.getDriver(), config.getWait());
        try{
            wait.until(
                    ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
}
