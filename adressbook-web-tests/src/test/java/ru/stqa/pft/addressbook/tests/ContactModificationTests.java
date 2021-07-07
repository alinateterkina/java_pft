package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModificationTests() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editFirstContact();
        app.getContactHelper().fillContactForm(new ContactData("name1", "lastname1","adress1", "111-11-11", "222-22-22", "333-33-33", "1@mail.ru", "2@mail.ru", "3@mail.ru", null), false);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().gotoGroupPage("home");
    }
}
