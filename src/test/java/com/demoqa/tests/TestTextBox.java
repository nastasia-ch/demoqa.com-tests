package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestTextBox {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String name = "Egor";
        String email = "egor@gmail.com";
        String currentAddress = "Current address";
        String permanentAddress = "Permanent address";

        open("/text-box");
        $("#userName").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("#output #name").shouldHave(Condition.text(name));
        $("#output #email").shouldHave(Condition.text(email));
        $("#output #currentAddress").shouldHave(Condition.text(currentAddress));
        $("#output #permanentAddress").shouldHave(Condition.text(permanentAddress));
    }

}
