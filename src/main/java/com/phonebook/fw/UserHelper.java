package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {

        super(driver);
    }

    public void clickOnRegistrationBytton() {

        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOmLoginLinc() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {
        //return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
        return isElementPresent(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void click0nSign0utButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
