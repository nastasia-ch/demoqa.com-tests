package mailru.nastasiachernega.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mailru.nastasiachernega.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebDriverProvider {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 50000;
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }

}
