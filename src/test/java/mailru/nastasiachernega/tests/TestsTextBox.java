package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsTextBox extends TestConfig {
    @Test

     void fillTextBoxForm() {

        TextBoxPage textBoxPage = new TextBoxPage();
        TestDate testDate = new TestDate();

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            textBoxPage.
                    setFullName(testDate.fullName).
                    setEmail(testDate.email).
                    setCurrentAddress(testDate.currentAddress).
                    setPermanentAddress(testDate.permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем, появилось ли поле с результатами", () -> {
            textBoxPage.isResultsFieldVisible();
        });

        step("Проверяем вывод результата", () -> {
            textBoxPage.
                    checkResult("Name:",testDate.fullName).
                    checkResult("Email:",testDate.email).
                    checkResult("Current Address :",testDate.currentAddress).
                    checkResult("Permananet Address :",testDate.permanentAddress);
        });

    }

}
