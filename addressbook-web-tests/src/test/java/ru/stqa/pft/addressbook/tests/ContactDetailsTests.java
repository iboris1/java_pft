package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Boris on 06.02.2017.
 */
public class ContactDetailsTests extends TestBase {

  @Test
  public void testContactDetails(){
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDetails = app.contact().contactDetails(contact);
    app.goTo().HomePage();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

//    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contactDetails, equalTo(mergeContactDetails(contactInfoFromEditForm)));
  }

  private String mergeContactDetails(ContactData contact) {
    return Arrays.asList(contact.getFirstName(),contact.getLastName(),contact.getAddress()
            ,contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone()
            ,contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","")
            .replaceAll("H:","")
            .replaceAll("M:","")
            .replaceAll("W:","");
  }

}
