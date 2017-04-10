package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Boris on 07.04.2017.
 */
public class RegistrationTests extends TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testRegistration(){
    app.registration().start("user","user1@localhost.localdomain");
  }

  @AfterMethod(alwaysRun = true)
  public void startMailServer(){
    app.mail().stop();
  }
}
