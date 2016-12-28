package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Boris on 28.12.2016.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/span[1]/input")).isSelected()) {
        click(By.xpath("//div[@id='content']/form/span[1]/input"));
      }
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }
}