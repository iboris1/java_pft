package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.List;

/**
 * Created by Boris on 29.12.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData/*, boolean creation*/) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());

//    if (creation){
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//    } else{
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
//    }

  }


  public void initContactCreation() {
      click(By.linkText("add new"));
  }

//  public void selectContact(int index) {
//    if (!wd.findElements(By.name("selected[]")).get(index).isSelected()) {
//    wd.findElements(By.name("selected[]")).get(index).click();
//    }
//  }

  public void selectContactById(int id) {
    if (!wd.findElement(By.cssSelector("input[value='" + id +"']")).isSelected()) {
      wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }
  }

//  public void initContactModification(int index) {
//   wd.findElements(By.name("entry")).get(index).findElement(By.xpath("td[8]/a/img")).click();
//  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href*='edit.php?id="+id+"']")).click();
  }

  public void viewContactDetailsById(int id) {
    wd.findElement(By.cssSelector("a[href*='view.php?id="+id+"']")).click();
  }

  public void initContactModificationViaButton() {
    wd.findElement(By.name("modifiy")).click();
  }


  public void viewContactDetails() {
//    WebElement row = wd.findElement(By.xpath("tr[name=entry"));
//    List<WebElement> cells = row.findElements(By.tagName("td"));
//    cells.get(6).findElement(By.tagName("a")).click();
    wd.findElement(By.xpath("//tr/td[7]/a")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
    returnToHomePage();
  }

  public void create(ContactData contactData/*, boolean b*/) {
    initContactCreation();
    fillContactForm(contactData/*,true*/);
    submitContactForm();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact/*,false*/);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  private Contacts contactCache = null;


  public Contacts all() {
    if(contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows){
      String firstname = element.findElements(By.tagName("td")).get(2).getText();
      String lastname = element.findElements(By.tagName("td")).get(1).getText();
      String allPhones = element.findElements(By.tagName("td")).get(5).getText();
      String allEmails = element.findElements(By.tagName("td")).get(4).getText();
      String address = element.findElements(By.tagName("td")).get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public String contactDetails() {
    viewContactDetails();
    //    int id = contact.getId();
    String contactDetails = wd.findElement(By.cssSelector("div[id=content]")).getText();
//    wd.navigate().back();
    return contactDetails;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  public ContactData infoFromEditForm2() {
    initContactModificationViaButton();
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withFirstName(firstName).withLastName(lastName)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

}
