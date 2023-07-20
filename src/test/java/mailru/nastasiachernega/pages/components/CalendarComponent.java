package mailru.nastasiachernega.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    public CalendarComponent setDay(String day) {
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public CalendarComponent setMonth(String month) {
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        return this;
    }

    public CalendarComponent setYear(String year) {
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        return this;
    }

    public CalendarComponent setTime(String time) {
        $$(".react-datepicker__time-list-item ").findBy(text(time)).click();;
        return this;
    }

}
