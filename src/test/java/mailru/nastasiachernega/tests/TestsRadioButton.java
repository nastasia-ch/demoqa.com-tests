package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.pages.RadioButtonPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsRadioButton extends TestConfig {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

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

        step("Проверяем отображение под переключателями текста: " +
                "You have selected " + radioName, () -> {
            radioButtonPage.checkResult(radioName);
        });

    }

}
