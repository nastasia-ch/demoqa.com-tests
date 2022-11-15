package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestTextBox extends TestBase {

    @Test
    void fillTextBoxForm() {

        TextBoxPage textBoxPage = new TextBoxPage();

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем форму", () -> {
            textBoxPage.
                    setFullName(fullName).
                    setEmail(email).
                    setCurrentAddress(currentAddress).
                    setPermanentAddress(permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем вывод результата", () -> {
            textBoxPage.
                    checkResult("Name:",fullName).
                    checkResult("Email:",email).
                    checkResult("Current Address :",currentAddress).
                    checkResult("Permananet Address :",permanentAddress);
        });

    }

}
