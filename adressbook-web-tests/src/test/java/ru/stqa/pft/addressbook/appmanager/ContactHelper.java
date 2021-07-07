package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage(String groups) {
        wd.findElement(By.linkText(groups)).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        WebElement deleteButton = wd.findElements(By.tagName("input")).stream().filter(new Predicate<WebElement>() {
            @Override
            public boolean test(WebElement webElement) {
                return webElement.getAttribute("value").equals("Delete");
            }
        }).collect(Collectors.toList()).get(0);
        deleteButton.click();
    }

    public void editFirstContact() {
        WebElement editCell = wd.findElement(By.id("maintable")).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(7).findElements(By.tagName("img")).get(0);
        editCell.click();
    }
}

