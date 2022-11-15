package com.demoqa.tests;

import com.demoqa.pages.RadioButtonPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestRadioButton extends TestBase {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @ValueSource(strings = {
            "Yes",
            "Impressive",
            "No"
    })
    @ParameterizedTest
    void clickOnRadioButton(String nameOfRadio) {

        step("Открываем форму", () -> {
            radioButtonPage.openPage();
        });

        step("Нажимаем на переключатель с названием " + nameOfRadio, () -> {
            radioButtonPage.clickRadio(nameOfRadio);
        });

        step("Проверяем отображение под переключателями текста: " +
                "You have selected " + nameOfRadio, () -> {
            radioButtonPage.checkResult(nameOfRadio);
        });

    }

}
