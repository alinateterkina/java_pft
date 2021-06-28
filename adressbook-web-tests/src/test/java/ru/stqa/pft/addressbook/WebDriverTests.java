package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverTests {

    private static final String URL_TEST = "http://chsu.ru/";

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverUtils.setupWebDriverProperties();
        driver = new ChromeDriver();
    }

    @Test
    public void testContactCreationTests() throws Exception {
        driver.get(URL_TEST);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
