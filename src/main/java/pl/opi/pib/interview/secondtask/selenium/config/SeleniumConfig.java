package pl.opi.pib.interview.secondtask.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class SeleniumConfig {

    private WebDriver driver;
    private int wait = 10;

    public SeleniumConfig() {
        driver = new FirefoxDriver();
    }

    static {
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver"));
    }

    static private String findFile(String filename) {
        if (System.getProperty("webdriver.gecko.driver") == null) {
            String paths[] = {"", "bin/", "target/classes", "/opt/"};
            for (String path : paths) {
                if (new File(path + filename).exists())
                    return path + filename;
            }
            return "";
        }else
            return System.getProperty("webdriver.gecko.driver");
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void close() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public int getWait() {
        return wait;
    }
}
