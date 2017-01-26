package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
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

  public void selectContact(int index) {
//    if (!wd.findElement(By.name("selected[]")).isSelected()) {
//      click(By.name("selected[]")).get;
//    }
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void initContactModification() {
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contactData/*, boolean b*/) {
    initContactCreation();
    fillContactForm(contactData/*,true*/);
    submitContactForm();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement element : rows){
        String firstname = element.findElements(By.tagName("td")).get(2).getText();
        String lastname = element.findElements(By.tagName("td")).get(1).getText();
        ContactData contact = new ContactData(firstname, lastname, null,null,null,null);
        contacts.add(contact);
    }
    return contacts;
  }
}
