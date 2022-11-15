package mailru.nastasiachernega.pages.components;

import mailru.nastasiachernega.utils.ButtonNameTransformerUtil;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ClickComponent {

    ButtonNameTransformerUtil buttonNameTransformerUtil = new ButtonNameTransformerUtil();

    public ClickComponent clickButton(String buttonName) {
        if(buttonName == "Double Click Me") {
            $$("button").findBy(exactText(buttonName)).doubleClick();
        };
        if(buttonName == "Right Click Me") {
            $$("button").findBy(exactText(buttonName)).contextClick();
        };
        if(buttonName == "Click Me") {
            $$("button").findBy(exactText(buttonName)).click();
        };
        return this;
    };

    public ClickComponent checkClickOnButton(String buttonName) {
        if(buttonName == "Double Click Me") {
            $("#doubleClickMessage").
                    shouldHave(text("You have done a " +
                            buttonNameTransformerUtil.buttonNameTransformer(buttonName)));
        };
        if(buttonName == "Right Click Me") {
            $("#rightClickMessage").
                    shouldHave(text("You have done a " +
                            buttonNameTransformerUtil.buttonNameTransformer(buttonName)));
        };
        if(buttonName == "Click Me") {
            $("#dynamicClickMessage").
                    shouldHave(text("You have done a " +
                            buttonNameTransformerUtil.buttonNameTransformer(buttonName)));
        };
        return this;
    };

}
