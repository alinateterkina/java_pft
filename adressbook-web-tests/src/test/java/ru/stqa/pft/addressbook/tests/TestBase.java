package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.model.WebDriverUtils;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    // TODO : здесь можно выбрать браузер в котором запустятся тесты
    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        WebDriverUtils.setupWebDriverProperties();
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }
}
