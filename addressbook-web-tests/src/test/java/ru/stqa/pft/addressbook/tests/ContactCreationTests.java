package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("name1", "name2", "testaddress", "11223344", "test@test.com"));
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
    }

}
