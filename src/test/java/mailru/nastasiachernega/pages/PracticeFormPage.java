package mailru.nastasiachernega.pages;

import com.codeborne.selenide.SelenideElement;
import mailru.nastasiachernega.pages.components.CalendarComponent;
import mailru.nastasiachernega.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    // Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $(".react-datepicker-wrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureChoice = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper");

    private final static String TITLE_TEXT = "Student Registration Form";

    // Actions

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent
                .setMonth(month)
                .setYear(year)
                .setDay(day);
        return this;
    }

    public PracticeFormPage setSubjects(String[] value) {
        for (String currentValue : value) {
            subjectsInput.setValue(currentValue).pressEnter();
        }
        return this;
    }

    public PracticeFormPage setHobbies(String[] value) {
        for (String currentValue : value) {
            hobbiesInput.$(byText(currentValue)).click();
        }
        return this;
    }

    public PracticeFormPage choosePicture(String value) {
        pictureChoice.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public PracticeFormPage isResultsTableVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResultsValue(".table-responsive", key, value);
        return this;
    }

    public PracticeFormPage checkResultArray(String key, String value[]) {
        resultsTableComponent.checkResultsArray(key, value);
        return this;
    }
}