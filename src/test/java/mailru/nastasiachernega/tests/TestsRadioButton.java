package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.RadioButtonPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsRadioButton extends WebDriverProvider {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @Epic("demoqa.com")
    @Feature("Radio Button")
    @Story("Переключение радиобаттонов и проверка вывода результата")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Radio Button", url = "https://demoqa.com/radio-button")
    @DisplayName("Нажатие на Radio и проверка вывода результата")
    @ValueSource(strings = {
            "Yes",
            "Impressive",
            "No"
    })
    @ParameterizedTest
    void clickOnRadioButton(String radioName) {

        step("Открываем форму", () -> {
            radioButtonPage.openPage();
        });

        step("Нажимаем на переключатель " + "'" + radioName + "'", () -> {
            radioButtonPage.clickRadio(radioName);
        });

        step("Проверяем отображение в поле результата текста: " +
                "You have selected " + radioName, () -> {
            radioButtonPage.checkResult(radioName);
        });

    }

}
