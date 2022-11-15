package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsPracticeForm extends TestConfig {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestDate testDate = new TestDate();

    @Test
    void fillPracticeFormWithAllData() {

        step("Открываем форму", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем поля формы", () -> {
            registrationFormPage
                    .setFirstName(testDate.firstName)
                    .setLastName(testDate.lastName)
                    .setEmail(testDate.email)
                    .setGender(testDate.gender)
                    .setUserNumber(testDate.phoneNumber)
                    .setBirthDate(testDate.dayOfBirth,testDate.monthOfBirth,testDate.yearOfBirth)
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
                    .checkResult("Student Name",testDate.firstName+" "+testDate.lastName)
                    .checkResult("Student Email",testDate.email)
                    .checkResult("Gender",testDate.gender)
                    .checkResult("Mobile",testDate.phoneNumber)
                    .checkResult("Date of Birth",
                            testDate.dayOfBirth+" "+testDate.monthOfBirth+","+testDate.yearOfBirth)
                    .checkResultArray("Subjects",testDate.subjects)
                    .checkResultArray("Hobbies",testDate.hobbies)
                    .checkResult("Picture",testDate.pictureName)
                    .checkResult("Address",testDate.currentAddress)
                    .checkResult("State and City",testDate.state+" "+testDate.city);
        });
    }

    @Test
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
                    .checkResult("Student Name",testDate.firstName+" "+testDate.lastName)
                    .checkResult("Gender",testDate.gender)
                    .checkResult("Mobile",testDate.phoneNumber);
        });
    }
}
