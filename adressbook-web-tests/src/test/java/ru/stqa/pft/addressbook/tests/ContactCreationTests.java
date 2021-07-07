package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationTests() throws Exception {
        app.getContactHelper().gotoGroupPage("add new");
        app.getContactHelper().fillContactForm(new ContactData("name1", "lastname1","adress1", "111-11-11", "222-22-22", "333-33-33", "1@mail.ru", "2@mail.ru", "3@mail.ru", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().gotoGroupPage("home");
    }
}
