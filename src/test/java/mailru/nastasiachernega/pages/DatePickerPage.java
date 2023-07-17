package mailru.nastasiachernega.pages;

import mailru.nastasiachernega.pages.components.CalendarComponent;
import mailru.nastasiachernega.utils.DateFormatter;

import java.text.ParseException;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatePickerPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private DateFormatter dateFormatter = new DateFormatter();

    private final static String TITLE_TEXT = "Date Picker";

    public DatePickerPage openPage() {
        open("/date-picker");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public  DatePickerPage selectDate(String day, String month, String year) {
        $("#datePickerMonthYearInput").click();
        calendarComponent.setDate(day,month,year);
        return  this;
    }

    public DatePickerPage checkSelectDateResult(String day, String month, String year) {
        $("#datePickerMonthYearInput")
                .shouldHave(attribute("value",
                        dateFormatter.formatDate(day, month, year, "MM/dd/yyyy")));
        return  this;
    }

}
