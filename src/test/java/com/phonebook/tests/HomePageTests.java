package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    // задать порядок выполнения тестов
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHome().isHomeComponentPresent()){       // если нет этого "isHomeComponentPresent"элемента
            app.getHome().click0nHomeLink();               // то кликни на "click0nHomeLink"
        }
    }

    @Test
    public void isHomeComponentPresentTest(){
//      driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
//      System.out.println("Home Component - " + isHomeComponentPresent());   // метод распечатывает то что нашел в методе boolean
        Assert.assertTrue(app.getHome().isHomeComponentPresent());

    }

}
