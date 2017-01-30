package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Boris on 29.12.2016.
 */
public class ContactModificationTests extends TestBase   {

  @Test(enabled = false)
  public void testContactModification(){
    app.goTo().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("name1", "name2", "testaddress",
              "11223344", "test@test.com", "test1")/*,true*/);
    }
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
//    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"name1", "name2",
            "testaddress", "11223344", "test@test.com",null);
    app.getContactHelper().fillContactForm(contact/*,false*/);
    app.getContactHelper().submitContactModification();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());


    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
