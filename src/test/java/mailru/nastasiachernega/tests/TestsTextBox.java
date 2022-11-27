package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsTextBox extends WebDriverProvider {
    @Test

    @Epic("demoqa.com")
    @Feature("Text Box")
    @Story("Заполнение полей формы и проверка вывода результата")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Text Box", url = "https://demoqa.com/text-box")
    @DisplayName("Заполнение полей Text Box и проверка вывода результата")
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
