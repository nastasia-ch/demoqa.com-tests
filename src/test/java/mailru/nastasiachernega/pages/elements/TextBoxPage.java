package mailru.nastasiachernega.pages.elements;

import com.codeborne.selenide.SelenideElement;
import mailru.nastasiachernega.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");

    private final static String TITLE_TEXT = "Text Box";

    public TextBoxPage openPage() {
        open("/text-box");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public TextBoxPage isResultsFieldVisible() {
        $("#output").should(appear);
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultsTableComponent.checkResultsValue("#output",key,value);
        return this;
    }

    public TextBoxPage isResultFieldEmpty() {
        $("#output div").shouldBe(empty);
        return this;
    }

    public TextBoxPage isEmailInputWrong() {
        emailInput.shouldHave(cssClass("field-error"));
        emailInput.shouldHave(cssValue("border","1px solid rgb(255, 0, 0)"));
        return this;
    }

    public TextBoxPage isResultsFieldHidden() {
        $("#output").should(hidden);
        return this;
    }

}
