package mailru.nastasiachernega.pages.widgets;

import com.codeborne.selenide.SelenideElement;
import mailru.nastasiachernega.pages.components.CalendarComponent;
import mailru.nastasiachernega.utils.DateFormatter;
import mailru.nastasiachernega.utils.YearSearch;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatePickerPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private DateFormatter dateFormatter = new DateFormatter();
    private YearSearch yearSearch = new YearSearch();

    private SelenideElement
            dateInput = $("#datePickerMonthYearInput"),
            dateAndTimeInput = $("#dateAndTimePickerInput");

    private final static String TITLE_TEXT = "Date Picker";

    public DatePickerPage openPage() {
        open("/date-picker");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public DatePickerPage selectDate(String day, String month, String year) {
        dateInput.click();
        calendarComponent
                .setMonth(month)
                .setYear(year)
                .setDay(day);
        return this;
    }

    public DatePickerPage checkSelectDateResult(String day, String month, String year) {
        dateInput.shouldHave(attribute("value",
                        dateFormatter.formatDate(day, month, year, "MM/dd/yyyy")));
        return this;
    }

    public DatePickerPage selectDateAndTime(String day, String month, String year, String time) {
        dateAndTimeInput.click();
        $(".react-datepicker__month-dropdown-container").click();
        $$(".react-datepicker__month-option").findBy(text(month)).click();
        $(".react-datepicker__year-dropdown-container").click();
        yearSearch.search(year);
        calendarComponent
                .setDay(day)
                .setTime(time);
        return this;
    }

    public DatePickerPage checkSelectDateAndTimeResult(String day, String month,
                                                       String year, String time) {
        dateAndTimeInput.shouldHave(attribute("value",
                        dateFormatter.formatDateAndTime(day, month,
                                year, time, "MMMM d, yyyy h:mm a")));
        return this;
    }

}
