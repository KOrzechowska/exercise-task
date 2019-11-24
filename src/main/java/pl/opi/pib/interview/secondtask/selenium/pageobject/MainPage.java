package pl.opi.pib.interview.secondtask.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.opi.pib.interview.secondtask.selenium.config.SeleniumConfig;

public class MainPage extends BasePageObject{

    @FindBy(xpath = "//li[div[@class='product-container']]")
    private WebElement productDiv;

    @FindBy(className = "ajax_add_to_cart_button")
    private WebElement addToCartButton;

    @FindBy(className = "ajax_cart_no_product")
    private WebElement emptyCartSpan;

    @FindBy(className = "shopping_cart")
    private WebElement shoppingCart;

    public MainPage(SeleniumConfig config) {
        super(config);
    }

    public void addToCart(){
        executeJavaScript("arguments[0].scrollIntoView(true);", productDiv);
        String classes = String.join(" ", productDiv.getAttribute("class"), "hovered");
        executeJavaScript(String.format("arguments[0].setAttribute('class', '%s')",classes), productDiv);
        addToCartButton.click();
    }

    public boolean isCartEmpty(){
        return emptyCartSpan.isEnabled();
    }

    public int getCartQuantity(){
        WebElement cartQuantity = shoppingCart.findElement(By.className("ajax_cart_quantity"));
        if (!cartQuantity.isEnabled())
            return 0;
        else return Integer.parseInt(cartQuantity.getText());
    }
}
