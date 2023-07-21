package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.ToolTipsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsToolTip extends WebDriverProvider {

    ToolTipsPage toolTipsPage = new ToolTipsPage();
    TestDate testDate = new TestDate();

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверка описания раздела Tool Tips")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tool Tips", url = "https://demoqa.com/tool-tips")
    @DisplayName("Проверка описания раздела Tool Tips")
    @Test
    void checkSectionDescription() {

        step("Открываем раздел Tool Tips", () -> {
            toolTipsPage.openPage();
        });

        step("Проверяем описание раздела Tool Tips", () -> {
            toolTipsPage.checkDescription();
        });

    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверяем возникновение подсказки при наведении на кнопку")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tool Tips", url = "https://demoqa.com/tool-tips")
    @DisplayName("Проверяем возникновение подсказки при наведении на кнопку")
    @Test
    void checkToolTipForButton() {

        step("Открываем раздел Tool Tips", () -> {
            toolTipsPage.openPage();
        });

        step("Наводим курсор на кнопку", () -> {
            toolTipsPage.hoverOnButton();
        });

        step("Проверяем возникновение подсказки", () -> {
            toolTipsPage
                    .isToolTipAppear()
                    .checkToolTipTextForButton();
        });

    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверяем возникновение подсказки при наведении на поле ввода")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tool Tips", url = "https://demoqa.com/tool-tips")
    @DisplayName("Проверяем возникновение подсказки при наведении на поле ввода")
    @Test
    void checkToolTipForInputField() {

        step("Открываем раздел Tool Tips", () -> {
            toolTipsPage.openPage();
        });

        step("Наводим курсор на поле ввода", () -> {
            toolTipsPage.hoverOnInputField();
        });

        step("Проверяем возникновение подсказки", () -> {
            toolTipsPage
                    .isToolTipAppear()
                    .checkToolTipTextForField();
        });

    }

    @Epic("demoqa.com")
    @Feature("Tabs")
    @Story("Проверяем возникновение подсказки при наведении на текст")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Ссылка на Tool Tips", url = "https://demoqa.com/tool-tips")
    @DisplayName("Проверяем возникновение подсказки при наведении на текст")
    @ValueSource(strings = {
            "Contrary",
            "1.10.32"
    })
    @ParameterizedTest
    void checkToolTipForText(String text) {

        step("Открываем раздел Tool Tips", () -> {
            toolTipsPage.openPage();
        });

        step("Наводим курсор на текст", () -> {
            toolTipsPage.hoverOnText(text);
        });

        step("Проверяем возникновение подсказки", () -> {
            toolTipsPage
                    .isToolTipAppear()
                    .checkToolTipTextForText(text);
        });

    }

}
