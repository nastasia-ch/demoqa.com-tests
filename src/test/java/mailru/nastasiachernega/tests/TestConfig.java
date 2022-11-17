package mailru.nastasiachernega.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mailru.nastasiachernega.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestConfig {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://demoqa.com";
//      Configuration.holdBrowserOpen = true;

        Configuration.browser = browserName;
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");

        String remoteUrl= System.getProperty("remoteURL");
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    private static String browserName = getBrowserName();
    private static String getBrowserName() {
        String browserName = System.getProperty("browser", "chrome");
        return  browserName;
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if(browserName.equals("firefox") == false) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
    }

}
