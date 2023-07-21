package mailru.nastasiachernega.tests.widgets;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.widgets.TabsPage;
import mailru.nastasiachernega.tests.TestDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TestsTabs extends WebDriverProvider {

    TabsPage tabsPage = new TabsPage();
    TestDate testDate = new TestDate();

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка описания раздела Tabs")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tabs", url = "https://demoqa.com/tabs")
    @DisplayName("Проверка описания раздела Tabs")
    @Test
    void checkSectionDescription() {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем описание раздела Tabs", () -> {
            tabsPage.checkDescription();
        });

    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка наличия раздела в Tabs")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Tabs", url = "https://demoqa.com/tabs")
    @DisplayName("Проверка наличия раздела в Tabs")
    @ValueSource(strings = {
            "What",
            "Origin",
            "Use",
            "More"
    })
    @ParameterizedTest
    void checkTabs(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем наличие раздела " + tabName + " в Tabs", () -> {
            tabsPage.shouldHaveTab(tabName);
        });

    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка недоступности вкладки More для клика")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tabs", url = "https://demoqa.com/tabs")
    @DisplayName("Проверка недоступности вкладки More для клика")
    @ValueSource(strings = {
            "More"
    })
    @ParameterizedTest
    void checkTabShouldBeDisabled(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Проверяем, что вкладка " + tabName + " не доступна для клика", () -> {
            tabsPage
                    .tabShouldBeDisabled(tabName);
        });
    }

    static Stream<Arguments> checkOneTabActiveAndOthersHidden() {
        return Stream.of(
                Arguments.of("What", new String[]{"Origin", "Use", "More"}),
                Arguments.of("Origin", new String[]{"What", "Use", "More"}),
                Arguments.of("Use", new String[]{"What", "Origin", "More"})
        );
    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка, что при открытии одной вкладки, текст остальных вкладкок скрыт")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Tabs", url = "https://demoqa.com/tabs")
    @DisplayName("Проверка, что при открытии одной вкладки, текст остальных вкладкок скрыт")
    @MethodSource()
    @ParameterizedTest
    void checkOneTabActiveAndOthersHidden(String activeTab, String[] hiddenTabs) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Нажимаем на вкладку " + activeTab, () -> {
            tabsPage
                    .clickTab(activeTab)
                    .tabShouldBeActive(activeTab);
        });

        step("Проверяем, что другие вкладки " + Arrays.toString(hiddenTabs) + " не активны", () -> {
            tabsPage
                    .tabsShouldBeAHidden(hiddenTabs);
        });
    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка текста в открытой вкладке")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Tabs", url = "https://demoqa.com/tabs")
    @DisplayName("Проверка текста в открытой вкладке")
    @ValueSource(strings = {
            "What",
            "Origin",
            "Use"
    })
    @ParameterizedTest
    void checkTabText(String tabName) {

        step("Открываем раздел Tabs", () -> {
            tabsPage.openPage();
        });

        step("Нажимаем на вкладку " + tabName, () -> {
            tabsPage
                    .clickTab(tabName)
                    .tabShouldBeActive(tabName);
        });

        step("Проверяем текст на вкладке " + tabName, () -> {
            tabsPage.checkTabText(testDate.tabs, tabName);
        });
    }

}
