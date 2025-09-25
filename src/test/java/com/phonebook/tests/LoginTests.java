package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    // задать порядок выполнения тестов
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){                 // если нет этого "isLoginLinkPresent"элемента
             app.getUser().click0nSign0utButton();                // то кликни на "click0nSign0utButton"
        }
    }

    @Test
    public void loginPositiveTest(){
        logger.info("Login with data --> login:"+ UserData.EMAIL + " password:"+ UserData.PASSWORD);
        //1.click on Login link - кликнуть на ссылку с Логин
        app.getUser().clickOmLoginLinc();
        //2.enter Email - ввести Емаил
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //4.click on Login button
        app.getUser().clickOnLoginButton();
        //5.verify SignOut is displayed - убидится что регистрация прошла успешно по кнопке Sign Out
        Assert.assertTrue(app.getUser().isSignOutPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        //1.click on Login link - кликнуть на ссылку с Логин
        app.getUser().clickOmLoginLinc();
        //2.enter Email - ввести Емаил
        app.getUser().fillRegisterLoginForm(new User().setPassword(UserData.PASSWORD)) ;
        //4.click on Login button
        app.getUser().clickOnLoginButton();
        //5.verify SignOut is displayed - убидится что регистрация прошла успешно по кнопке Sign Out
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
