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
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return new Contacts(contactCache);
  }


}
