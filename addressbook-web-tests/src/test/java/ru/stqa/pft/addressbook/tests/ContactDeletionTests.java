package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Boris on 29.12.2016.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
      app.goTo().HomePage();
      app.contact().create(new ContactData().withFirstName("John")
              .withLastName("Smith").withAddress("testaddress")
              .withEmail("test@test.com").withHomePhone("11223344").withGroup("test1"));
    }
  }


  @Test
  public void testContactDeletion(){
    Contacts before = app.db().contacts();
    ContactData deleletedContact = before.iterator().next();
    app.contact().delete(deleletedContact);
    assertThat(app.contact().count(),equalTo(before.size()-1));
    Contacts after = app.db().contacts();

//    assertEquals(after.size(),before.size() - 1);
    assertThat(after, equalTo(before.without(deleletedContact)));
  }


}
