package pl.opi.pib.interview.secondtask.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.opi.pib.interview.secondtask.selenium.config.SeleniumConfig;
import pl.opi.pib.interview.secondtask.selenium.model.AutomationPractice;
import pl.opi.pib.interview.secondtask.selenium.pageobject.MainPage;
import pl.opi.pib.interview.secondtask.selenium.pageobject.PopupPage;

public class SeleniumTest {
    private SeleniumConfig config;
    private MainPage mainPage;
    private PopupPage popupPage;
    private AutomationPractice automationPractice;

    @Before
    public void setUp() {
        config = new SeleniumConfig();
        mainPage = new MainPage(config);
        popupPage = new PopupPage(config);
        automationPractice = new AutomationPractice(config);
    }

    @After
    public void teardown() {
        config.close();
    }

    @Test
    public void testAddingTwoItemsToCart() {
        automationPractice.navigateTo();
        // czy na start koszyk pusty
        Assert.assertTrue(mainPage.isCartEmpty());
        mainPage.addToCart();
        Assert.assertTrue(popupPage.isVisible());
        Assert.assertTrue("Incorect popup message: "+ popupPage.getMessage(),popupPage.isSuccess());
        // liczba w koszyku na popup
        Assert.assertEquals(1, popupPage.getCartQuantity());
        popupPage.continueShopping();
        // liczba w koszyku w main page
        Assert.assertEquals(1, mainPage.getCartQuantity());

        mainPage.addToCart();
        Assert.assertTrue(popupPage.isVisible());
        Assert.assertTrue("Incorect popup message: "+ popupPage.getMessage(),popupPage.isSuccess());
        Assert.assertEquals(2, popupPage.getCartQuantity());
        Assert.assertEquals(2, mainPage.getCartQuantity());
    }

}
