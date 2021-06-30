package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.WebDriverUtils;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    // TODO : здесь можно выбрать браузер в котором запустятся тесты
    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverUtils.setupWebDriverProperties();
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
}
