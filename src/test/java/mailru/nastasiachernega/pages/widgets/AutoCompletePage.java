package mailru.nastasiachernega.pages.widgets;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutoCompletePage {

    private final static String TITLE_TEXT = "Auto Complete";

//    private SelenideElement
//            singleFieldInput = $("#autoCompleteSingleInput"),
//            multipleFieldInput = $("#autoCompleteMultipleInput"),
//            containerSingleFieldInput = $("#autoCompleteSingleContainer"),
//            containerMultipleFieldInput = $("#autoCompleteMultipleContainer");

    private SelenideElement getFieldInput(Enum fieldType) {
        return $("#autoComplete" + fieldType + "Input");
    }

    private SelenideElement getContainerOfFieldInput(Enum fieldType) {
        return $("#autoComplete" + fieldType + "Container");
    }

    public AutoCompletePage openPage() {
        open("/auto-complete");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public AutoCompletePage typeOneColor(Enum fieldType, String value) {
        getFieldInput(fieldType).click();
        getFieldInput(fieldType).sendKeys(value);
        getFieldInput(fieldType).pressEnter();
        return this;
    }

    public AutoCompletePage colorShouldBeFixed(Enum fieldType, String value) {
        getContainerOfFieldInput(fieldType).shouldHave(text(value));
        return this;
    }

    public AutoCompletePage colorShouldNOTBeFixed(Enum fieldType, String value) {
       getContainerOfFieldInput(fieldType).shouldNotHave(text(value));
        return this;
    }

    public AutoCompletePage typeSomeColors(Enum fieldType, List<String> values) {
        getFieldInput(fieldType).click();
        for (String value : values) {
           getFieldInput(fieldType).sendKeys(value);
           getFieldInput(fieldType).pressEnter();
        }
        return this;
    }

    public AutoCompletePage someColorsShouldBeFixed(Enum fieldType, List<String> values) {
        for (String value: values) {
            getContainerOfFieldInput(fieldType).shouldHave(text(value));
        }
        return this;
    }

    public AutoCompletePage someColorShouldNOTBeFixed(Enum fieldType, List<String> values) {
        for (String value: values) {
            getContainerOfFieldInput(fieldType).shouldNotHave(text(value));
        }
        return this;
    }

    public AutoCompletePage clearInputValueByBackspace(Enum fieldType, String value) {
        int valueLength = value.length();
        for(int i=0; i < valueLength; i++) {
            getFieldInput(fieldType).sendKeys(Keys.BACK_SPACE);
        }
        return this;
    }

}
