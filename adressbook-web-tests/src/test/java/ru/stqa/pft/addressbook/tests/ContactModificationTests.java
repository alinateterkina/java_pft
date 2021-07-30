package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("test1").withLastname("test2").withAddress("test3").withHome("test4")
                    .withMobile("test5").withWork("test6").withEmail("test7").withEmail2("test8")
                    .withEmail3("test9").withGroup("test10"), true);
        }
    }
@Test
    public void testContactModificationTests()  {

        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("test2").withLastname("lastname2").withAddress("test3").withHome("test4").withMobile("test5").withWork("test6").withEmail("test7").withEmail2("test8").withEmail3("test9");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
