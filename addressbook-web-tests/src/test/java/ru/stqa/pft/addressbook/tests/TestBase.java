package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Boris on 27.12.2016.
 */
public class TestBase {

  //protected final ApplicationManager app = new ApplicationManager();
  protected final ApplicationManager app = new ApplicationManager();
  //FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
