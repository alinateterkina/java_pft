package ru.stqa.pft.addressbook.model;

public class WebDriverUtils {

    public static void setupWebDriverProperties() {
        System.setProperty("webdriver.chrome.driver", "E:\\devel\\webdrivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "E:\\devel\\webdrivers\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "E:\\devel\\webdrivers\\IEDriverServer.exe");
    }
}
