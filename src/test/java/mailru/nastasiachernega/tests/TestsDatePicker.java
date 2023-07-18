package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.DatePickerPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsDatePicker extends WebDriverProvider {

    DatePickerPage datePickerPage = new DatePickerPage();
    TestDate testDate = new TestDate();

    @Test
    void selectDate() {

        step("Открываем раздел Date Picker", () -> {
            datePickerPage.openPage();
        });

        step("Выбираем дату в поле Select Date", () -> {
            datePickerPage
                    .selectDate(testDate.dayOfBirth,
                            testDate.monthOfBirth,
                            testDate.yearOfBirth);
        });

        step("Проверяем дату, зафиксированную в поле Select Date", () -> {
            datePickerPage
                    .checkSelectDateResult(testDate.dayOfBirth,
                            testDate.monthOfBirth,
                            testDate.yearOfBirth);
        });

    }

    @Test
    void selectDateAndTime() {
        datePickerPage
                .openPage()
                .selectDateAndTime(testDate.dayOfBirth,
                        testDate.monthOfBirth,
                        testDate.yearOfBirth,
                        testDate.time)
                .checkSelectDateAndTimeResult(testDate.dayOfBirth,
                        testDate.monthOfBirth,
                        testDate.yearOfBirth,
                        testDate.time);
    }


}
