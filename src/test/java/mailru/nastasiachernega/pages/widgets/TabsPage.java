package mailru.nastasiachernega.pages.widgets;

import java.util.ArrayList;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TabsPage {

    private final static String TITLE_TEXT = "Tabs";

    public TabsPage openPage() {
        open("/tabs");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TabsPage checkDescription() {
        $("#tabsContainer").$("div").shouldHave(text("Details about Lorem Ipsum"));
        return this;
    }

    public TabsPage shouldHaveTab(String tabName) {
        $(".nav-tabs").$$("a").findBy(id("demo-tab-" + tabName.toLowerCase()))
                .shouldHave(text(tabName));
        return this;
    }

    public TabsPage clickTab(String tabName) {
        $("#demo-tab-" + tabName.toLowerCase()).click();
        return this;
    }

    public TabsPage tabShouldBeDisabled(String tabName) {
        $("#demo-tab-" + tabName.toLowerCase())
                .shouldHave(cssClass("disabled"));
        return this;
    }

    public TabsPage tabShouldBeActive(String tabName) {
        $("#demo-tabpane-" + tabName.toLowerCase())
                .shouldHave(attribute("aria-hidden", "false"))
                .shouldHave(cssClass("active"));
        return this;
    }

    public TabsPage tabsShouldBeAHidden(String[] tabs) {
        for (String tabName : tabs) {
            $("#demo-tabpane-" + tabName.toLowerCase())
                    .shouldHave(attribute("aria-hidden", "true"));
        }
        return this;
    }

    public TabsPage checkTabText(Map<String, ArrayList<String>> tabs, String tabName) {
        checkText(tabs, tabName);
        return this;
    }


    private TabsPage checkText(Map<String, ArrayList<String>> tabs, String tabName) {
        int numberOfParagraphs = tabs.get(tabName).size();
        for (int i = 0; i < numberOfParagraphs; i++) {
            $("#demo-tabpane-" + tabName.toLowerCase()).$$("p").get(i)
                    .shouldHave(text(tabs.get(tabName).get(i)));
        }
        return this;
    }

}
