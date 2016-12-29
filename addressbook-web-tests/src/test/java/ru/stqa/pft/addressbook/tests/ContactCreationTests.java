package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

//    @BeforeMethod
//    public void setUp() throws Exception {
//        wd = new FirefoxDriver();
//        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        wd.get("http://localhost/addressbook/");
//        login("admin", "secret");
//    }

//    private void login(String username, String password) {
//        wd.findElement(By.id("LoginForm")).click();
//        wd.findElement(By.name("user")).click();
//        wd.findElement(By.name("user")).clear();
//        wd.findElement(By.name("user")).sendKeys(username);
//        wd.findElement(By.name("pass")).click();
//        wd.findElement(By.name("pass")).clear();
//        wd.findElement(By.name("pass")).sendKeys(password);
//        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
//    }

    @Test
    public void testContactCreation() {

        app.initContactCreation();
        app.fillContactForm(new ContactData("name1", "name2", "testaddress", "11223344", "test@test.com"));
        app.submitContactForm();
        app.gotoHomePage();
    }

    //    @AfterMethod
//    public void tearDown() {
//        wd.quit();
//    }
    
//    public static boolean isAlertPresent(FirefoxDriver wd) {
//        try {
//            wd.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
}
