package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsTextBox extends WebDriverProvider {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestDate testDate = new TestDate();

    @Epic("demoqa.com")
    @Feature("Text Box")
    @Story("Отправка валидно заполненной формы")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Text Box", url = "https://demoqa.com/text-box")
    @Test
     void fillTextBoxForm() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            textBoxPage.
                    setFullName(testDate.fullName).
                    setEmail(testDate.validEmail).
                    setCurrentAddress(testDate.currentAddress).
                    setPermanentAddress(testDate.permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем вывод в поле с результатами", () -> {
            textBoxPage
                    .isResultsFieldVisible()
                    .checkResult("Name:",testDate.fullName)
                    .checkResult("Email:",testDate.validEmail)
                    .checkResult("Current Address :",testDate.currentAddress)
                    .checkResult("Permananet Address :",testDate.permanentAddress);
        });

    }

    @Epic("demoqa.com")
    @Feature("Text Box")
    @Story("Отправка пустой формы")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Text Box", url = "https://demoqa.com/text-box")
    @Test
    void sendEmptyTextBoxForm() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем, что поле с результатами пустое", () -> {
            textBoxPage
                    .isResultsFieldVisible()
                    .isResultFieldEmpty();
        });

    }

    @Epic("demoqa.com")
    @Feature("Text Box")
    @Story("Отправка формы с невалидным электронным адресом")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Text Box", url = "https://demoqa.com/text-box")
    @Test
    void sendFormWithInvalidEmail() {

        step("Открываем форму", () -> {
            textBoxPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            textBoxPage.
                    setFullName(testDate.fullName).
                    setEmail(testDate.invalidEmail).
                    setCurrentAddress(testDate.currentAddress).
                    setPermanentAddress(testDate.permanentAddress);
        });

        step("Нажимаем кнопку Submit", () -> {
            textBoxPage.clickSubmit();
        });

        step("Проверяем, поле ввода email", () -> {
            textBoxPage
                    .isEmailInputWrong();
        });

        step("Проверяем, что поле с результатами пустое", () -> {
            textBoxPage
                    .isResultsFieldVisible()
                    .isResultFieldEmpty();
        });

    }

}
