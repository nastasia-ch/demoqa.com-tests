package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.PracticeFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsPracticeForm extends WebDriverProvider {

    PracticeFormPage registrationFormPage = new PracticeFormPage();
    TestDate testDate = new TestDate();

    @Epic("demoqa.com")
    @Feature("Practice Form")
    @Story("Заполнение полей формы и проверка вывода результата")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Practice Form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение ВСЕХ полей Practice Form и проверка вывода результата")
    @Test
    void fillPracticeFormWithAllData() {

        step("Открываем форму", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            registrationFormPage
                    .setFirstName(testDate.firstName)
                    .setLastName(testDate.lastName)
                    .setEmail(testDate.validEmail)
                    .setGender(testDate.gender)
                    .setUserNumber(testDate.phoneNumber)
                    .setBirthDate(testDate.dayOfBirth, testDate.monthOfBirth, testDate.yearOfBirth)
                    .setSubjects(testDate.subjects)
                    .setHobbies(testDate.hobbies)
                    .choosePicture(testDate.pictureName)
                    .setCurrentAddress(testDate.currentAddress)
                    .setState(testDate.state)
                    .setCity(testDate.city);
        });

        step("Нажимаем кнопку Submit", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Проверяем, появилась ли таблиица с результатами", () -> {
            registrationFormPage.isResultsTableVisible();
        });

        step("Проверяем вывод результата", () -> {
            registrationFormPage
                    .checkResult("Student Name", testDate.firstName + " " + testDate.lastName)
                    .checkResult("Student Email", testDate.validEmail)
                    .checkResult("Gender", testDate.gender)
                    .checkResult("Mobile", testDate.phoneNumber)
                    .checkResult("Date of Birth",
                            testDate.dayOfBirth + " " + testDate.monthOfBirth + "," + testDate.yearOfBirth)
                    .checkResultArray("Subjects", testDate.subjects)
                    .checkResultArray("Hobbies", testDate.hobbies)
                    .checkResult("Picture", testDate.pictureName)
                    .checkResult("Address", testDate.currentAddress)
                    .checkResult("State and City", testDate.state + " " + testDate.city);
        });
    }

    @Epic("demoqa.com")
    @Feature("Practice Form")
    @Story("Заполнение полей формы и проверка вывода результата")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Practice Form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение МИНИМАЛЬНО требуемых полей Practice Form и проверка вывода результата")
    @Test
    @Tag("minimum_of_tests")
    void fillPracticeFormWithMinimumData() {

        step("Открываем форму", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            registrationFormPage
                    .setFirstName(testDate.firstName)
                    .setLastName(testDate.lastName)
                    .setGender(testDate.gender)
                    .setUserNumber(testDate.phoneNumber);
        });

        step("Нажимаем кнопку Submit", () -> {
            registrationFormPage.clickSubmit();
        });

        step("Проверяем, появилась ли таблиица с результатами", () -> {
            registrationFormPage.isResultsTableVisible();
        });

        step("Проверяем вывод результата", () -> {
            registrationFormPage
                    .checkResult("Student Name", testDate.firstName + " " + testDate.lastName)
                    .checkResult("Gender", testDate.gender)
                    .checkResult("Mobile", testDate.phoneNumber);
        });
    }
}
