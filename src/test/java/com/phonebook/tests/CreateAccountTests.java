package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {
    SoftAssert softAssert = new SoftAssert();                                                              // делается для того чтоб при "падении теста" при ассертемтест проболжался (не рекомендуется!)

    // задать порядок выполнения тестов
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){                 // если нет этого "isLoginLinkPresent"элемента
             app.getUser().click0nSign0utButton();                // то кликни на "click0nSign0utButton"
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {

        //int i = (int)((System.currentTimeMillis()/1000)%3600);                                           //переменная для авто.создания email(разных)

        app.getUser().clickOmLoginLinc();                                                                 //1.click on Login link - кликнуть на ссылку с Логин

        //app. getUser().fillRegisterLoginForm(new User().setEmail(manuel"+i+"@gmail.com").setPasswordsetPassword("Aa23456789!"));       //автоматическое создание разных email
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD)); //2.enter Email - ввести Емаил и Пароль
        app.getUser().clickOnRegistrationBytton();                                                        //3.click on "Registration" button - кликнуть кнопу "Регистрация"
        Assert.assertTrue(app.getUser().isSignOutPresent());                                              //5.verify SignOut is displayed - убидится что регистрация прошла успешно по кнопке Sign Out
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOmLoginLinc();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationBytton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());                                          // проверка на всплывающее окно
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());                                     // проверка на "надпись error 400 бла бла.."
        softAssert.assertAll();                                                                           // завершает "пропуски" ассертов
    }
}