package mailru.nastasiachernega.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mailru.nastasiachernega.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    @BeforeAll
    static void setUp() {

        System.getProperty("environment");

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class,System.getProperties());

        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        String remoteUrl= config.getRemoteURLForTestRun();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }

        Configuration.baseUrl = config.getBaseURL();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class,System.getProperties());
        if(config.getBrowserName().equals("firefox") == false) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
    }

}
