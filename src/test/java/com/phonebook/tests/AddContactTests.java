package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{
    //pre-condition
    @BeforeMethod
    public void precondition(){

        if (!app.getUser().isLoginLinkPresent()){                 // если нет этого "isLoginLinkPresent"элемента
             app.getUser().click0nSign0utButton();                // то кликни на "click0nSign0utButton"
        }

        app.getUser().clickOmLoginLinc();                                                                 //1.click on Login link - кликнуть на ссылку с Логин
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD)); //2.enter Email - ввести Емаил
        app.getUser().clickOnLoginButton();                                                               //4.click on Login button
    }
    @Test
    public void addContactPositiveTest(){
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
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
    }


    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name,
                                                       String lastname,
                                                       String phone,
                                                       String email,
                                                       String address,
                                                       String description){
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(new Contact()
                      .setName(name)
                       .setLastName(lastname)
                        .setPhone(phone)
                         .setEmail(email)
                          .setAddress(address)
                           .setDescription(description));
        //click SAVE button
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }



    @Test(dataProvider = "addNewContactWithCsv",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact){
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(contact);
        //click SAVE button
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }

}
