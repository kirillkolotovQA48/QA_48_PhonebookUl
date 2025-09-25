package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactAdded(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contacts){
            if (el.getText().contains(name))
                return true;
        }
        return false;
    }

    public void deleteContact() {
        click(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div[1]"));
        click(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/button[2]"));
    }

    public int size0fContacts()                                                                   // метод "(подсчет контактов до удоления)"
    {
        if(isElementPresent(By.xpath(
                "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div[1]")))            // если такая карточка существует
        {
            return driver.findElements(By.xpath(
                    "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div[1]")).size(); // тогда верни кол-во карточек
        }
        return 0;
    }
}
