package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Boris on 07.04.2017.
 */
public class RegistrationHelper extends HelperBase {
//  private final ApplicationManager app;
//  private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    super(app);
//    this.app = app;
//    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));

  }
}
