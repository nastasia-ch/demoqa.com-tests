package mailru.nastasiachernega.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProgressBarPage {

    private SelenideElement
            startStopButton = $("#startStopButton"),
            resetButton = $("#resetButton"),
            progressBar = $(".progress-bar");

    private final static String TITLE_TEXT = "Progress Bar";

    public ProgressBarPage openPage() {
        open("/progress-bar");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public ProgressBarPage clickStart() {
        startStopButton.click();
        return this;
    }

    public ProgressBarPage waiting(int targetProgress) throws InterruptedException {
        Thread.sleep(targetProgress * 100);
        return this;
    }

    public ProgressBarPage clickStop() {
        startStopButton.click();
        return this;
    }

    public ProgressBarPage checkStartStopButtonName(String buttonName) {
        startStopButton.shouldHave(text(buttonName));
        return this;
    }

    public ProgressBarPage clickReset() {
        resetButton.shouldHave(text("Reset"));
        resetButton.click();
        return this;
    }

    public ProgressBarPage checkProgress(int targetProgress) {
        progressBar.shouldHave(text(targetProgress + "%"));
        return this;
    }

    public ProgressBarPage checkProgressColor() {
        progressBar.shouldHave((cssValue("background-color", "rgba(23, 162, 184, 1)")));
        return this;
    }

    public ProgressBarPage checkFullProgressColor() {
        progressBar.shouldHave((cssValue("background-color", "rgba(40, 167, 69, 1)")));
        return this;
    }

}
