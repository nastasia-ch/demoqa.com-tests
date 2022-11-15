package com.demoqa.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RadioButtonPage {

    private final static String TITLE_TEXT = "Radio Button";

    public RadioButtonPage openPage() {
        open("/radio-button");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RadioButtonPage clickRadio(String nameOfRadio) {
        $("[for="+nameOfRadio.toLowerCase()+"Radio]").click();
        return this;
    }

    public RadioButtonPage checkResult(String nameOfRadio) {
        $("[for="+nameOfRadio.toLowerCase()+"Radio]").parent().parent().lastChild().
                shouldHave(text("You have selected " + nameOfRadio));
        return this;
    }

}
