package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Boris on 07.04.2017.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration(){

    app.registration().start("user","user1@localhost.localdomain");

  }
}
