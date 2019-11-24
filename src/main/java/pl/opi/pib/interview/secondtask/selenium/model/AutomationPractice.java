package pl.opi.pib.interview.secondtask.selenium.model;

import pl.opi.pib.interview.secondtask.selenium.config.SeleniumConfig;

public class AutomationPractice {

    private SeleniumConfig config;

    public AutomationPractice(SeleniumConfig config) {
        this.config = config;
    }

    public void navigateTo() {
        config.navigateTo("http://automationpractice.com/index.php");
    }

}
