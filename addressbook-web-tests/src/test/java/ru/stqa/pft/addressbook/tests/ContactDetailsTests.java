package ru.stqa.pft.addressbook.tests;

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
    String contactDetails = null;
    contactDetails = app.contact().contactDetails();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm2();
    assertThat(contactDetails, equalTo(mergeContactDetails(contactInfoFromEditForm)));
  }

  private String mergeContactDetails(ContactData contact) {
    return Arrays.asList(
            Arrays.asList(Arrays.asList(contact.getFirstName(),contact.getLastName()).stream().filter((s) -> !s.equals(""))
                    .collect(Collectors.joining(" ")),contact.getAddress()).stream().filter((s) -> !s.equals(""))
                    .collect(Collectors.joining("\n")),
            Arrays.asList(Arrays.asList("H:",contact.getHomePhone()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining(" "))
                          ,Arrays.asList("M:",contact.getMobilePhone()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining(" "))
                          ,Arrays.asList("W:",contact.getWorkPhone()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining(" ")))
                    .stream().collect(Collectors.joining("\n")),
            Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3()).stream().filter((s) -> !s.equals(""))
                    .collect(Collectors.joining("\n"))
            )
            .stream()
            .filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n\n"));
  }

}
