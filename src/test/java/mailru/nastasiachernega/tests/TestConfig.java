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
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");

        if (System.getProperty("remote_url") != null) {
            Configuration.remote = System.getProperty("remote_url");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;

            SelenideLogger.addListener("allure", new AllureSelenide());
        }
    }

        @AfterEach
        void addAttachments () {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }

}
