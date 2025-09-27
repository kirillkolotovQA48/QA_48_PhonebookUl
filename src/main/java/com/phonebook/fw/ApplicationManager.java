package com.phonebook.fw;

import com.phonebook.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class ApplicationManager{

    private String browser;
    private WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    HomePageHelper home;
    ContactHelper contact;
    UserHelper user;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Tests start in Chrome browser");
        }
        else
            if (browser.equalsIgnoreCase("safari")){
                driver = new SafariDriver();
                logger.info("Tests start in Safari browser");
            }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://telranedu.web.app");
        logger.info("Current url -->" + driver.getCurrentUrl());
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        home = new HomePageHelper(driver);
        contact = new ContactHelper(driver);
        user = new UserHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public HomePageHelper getHome() {
        return home;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public String getBrowser() {
        return browser;
    }
}
