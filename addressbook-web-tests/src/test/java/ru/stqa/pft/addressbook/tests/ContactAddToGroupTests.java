package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Boris on 03.04.2017.
 */
public class ContactAddToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().HomePage();
      app.contact().create(new ContactData().withFirstName("John")
              .withLastName("Smith").withAddress("testaddress")
              .withEmail("test@test.com").withHomePhone("11223344")/*.withGroup("test1")*/);
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().HomePage();
    Contacts before = app.db().contacts();
//    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("John")
            .withLastName("Smith").withAddress("testaddress")
            .withEmail("test@test.com").withHomePhone("11223344")
            .withWorkPhone("5125551").withMobilePhone("23423532")
            .withCompany("Apple").withTitle("CEO")/*.withGroup("test1")*/;
    app.goTo().HomePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.db().contacts();

//    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }




}
