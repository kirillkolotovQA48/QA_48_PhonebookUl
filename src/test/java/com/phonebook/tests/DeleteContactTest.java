package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()){                 // если нет этого "isLoginLinkPresent"элемента
             app.getUser().click0nSign0utButton();                // то кликни на "click0nSign0utButton"
        }

        app.getUser().clickOmLoginLinc();                                                                 //1.click on Login link - кликнуть на ссылку с Логин
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD)); //2.enter Email - ввести Емаил
        app.getUser().clickOnLoginButton();

        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        //click SAVE button
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().size0fContacts();                   //создаем метод (подсчет контактов)
        app.getContact().deleteContact();

        app.getContact().pause(1000);
        int sizeAfter = app.getContact().size0fContacts();                     //используем тот же метод (подсчет контактов)

        Assert.assertEquals(sizeAfter,sizeBefore-1); //сравниваем количество каточек до и после удаления
    }

}
