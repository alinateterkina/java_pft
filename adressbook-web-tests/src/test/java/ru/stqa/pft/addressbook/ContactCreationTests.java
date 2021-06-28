package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.openqa.selenium.*;

public class ContactCreationTests {

  private WebDriver wd;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    WebDriverUtils.setupWebDriverProperties();
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreationTests() throws Exception {
    gotoGroupPage("add new");
    fillContactForm(new ContactData("name1", "lastname1","adress1", "111-11-11", "222-22-22", "333-33-33", "1@mail.ru", "2@mail.ru", "3@mail.ru"));
    submitContactCreation();
    gotoGroupPage("home");
    gotoGroupPage("Logout");
  }

  private void gotoGroupPage(String groups) {
    wd.findElement(By.linkText(groups)).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactData.getHome());
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactData.getWork());
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
  }
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    if (wd != null) {
      wd.quit();
    }
  }

}
