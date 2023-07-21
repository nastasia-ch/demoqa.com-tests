package mailru.nastasiachernega.pages.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ToolTipsPage {
    private SelenideElement
            descriptionField = $("#buttonToolTopContainer").$("p"),
            button = $("#toolTipButton"),
            textInput = $("#toolTipTextField"),
            textArea = $("#texToolTopContainer"),
            tooltip = $(".tooltip-inner");

    private final static String TITLE_TEXT = "Tool Tips";

    public ToolTipsPage openPage() {
        open("/tool-tips");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public ToolTipsPage checkDescription() {
        descriptionField.shouldHave(text("Practice Tool Tips"));
        return this;
    }

    public ToolTipsPage hoverOnButton() {
        button.hover();
        return this;
    }

    public ToolTipsPage hoverOnInputField() {
        textInput.hover();
        return this;
    }

    public ToolTipsPage hoverOnText(String text) {
        textArea.$$("a").findBy(text(text)).hover();
        return this;
    }

    public ToolTipsPage isToolTipAppear() {
        tooltip.shouldBe(appear);
        return this;
    }

    public ToolTipsPage checkToolTipTextForButton() {
        tooltip.shouldHave(text("You hovered over the Button"));
        return this;
    }

    public ToolTipsPage checkToolTipTextForField() {
        tooltip.shouldHave(text("You hovered over the text field"));
        return this;
    }

    public ToolTipsPage checkToolTipTextForText(String text) {
        tooltip.shouldHave(text("You hovered over the " + text));
        return this;
    }

}
