package pl.opi.pib.interview.secondtask.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.opi.pib.interview.secondtask.selenium.config.SeleniumConfig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PopupPage extends BasePageObject {

    private static final String SUCCESS_MESSAGE = "Product successfully added to your shopping cart";

    @FindBy(id = "layer_cart")
    private WebElement cartPopup;

    @FindBy(className = "continue")
    private WebElement continueButton;

    public PopupPage(SeleniumConfig config) {
        super(config);
    }

    public boolean isVisible(){
        return isElementVisible(cartPopup);
    }

    public String getMessage(){
        return cartPopup.findElement(By.xpath("//div[contains(@class, 'layer_cart_product')]//h2")).getText();
    }

    public boolean isSuccess(){
        return getMessage().contains(SUCCESS_MESSAGE);
    }

    public int getCartQuantity(){
        WebElement itemNumberText = cartPopup.findElement(By.xpath("//div[contains(@class, 'layer_cart_cart')]/h2"));
        Pattern pattern = Pattern.compile("[^\\d]*([\\d]+)");
        Matcher matcher = pattern.matcher(itemNumberText.getText());
        if (matcher.find())
            return Integer.parseInt(matcher.group(1));
        else return 0;
    }

    public void continueShopping(){
        continueButton.click();
    }
}
