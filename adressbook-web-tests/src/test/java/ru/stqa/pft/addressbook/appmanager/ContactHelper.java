package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
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

    public void editContact(int index) {
        WebElement editCell = wd.findElement(By.id("maintable")).findElements(By.tagName("tr")).get(index + 1 ).findElements(By.tagName("td")).get(7).findElements(By.tagName("img")).get(0);
        editCell.click();
    }

    public void editContactById(int id) {
       wd.findElement(By.cssSelector("a[href$= 'edit.php?id=" + id + "']")).click();
    }

    public void create(ContactData contact, boolean b) {
        gotoGroupPage("add new");
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;
        gotoGroupPage("home");
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        submitContactCreation();
        contactCache = null;
        gotoGroupPage("home");
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        gotoGroupPage("home");
    }
    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
        gotoGroupPage("home");
    }

    public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        WebElement maintable = wd.findElement(By.id("maintable"));
        ArrayList<WebElement> elements = new ArrayList<>(maintable.findElements(By.tagName("tr")));
        elements.remove(0);
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (WebElement element : elements) {
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }


    private Contacts contactCache=null;


    public Contacts all() {
        if(contactCache != null){ return new Contacts(contactCache); }
        WebElement maintable = wd.findElement(By.id("maintable"));
        ArrayList<WebElement> elements = new ArrayList<>(maintable.findElements(By.tagName("tr")));
        elements.remove(0);
        contactCache = new Contacts();
        for (WebElement element : elements) {
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
                    withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHome(home).withMobile(mobile).withWork(work);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value = '%s']", id)));
        WebElement row = checkbox.findElement(By.xpath(".//..//.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}

