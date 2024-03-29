package mailru.nastasiachernega.tests.elements;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.elements.ButtonsPage;
import mailru.nastasiachernega.utils.ButtonNameTransformerUtil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TestsButtons extends WebDriverProvider {

    ButtonsPage buttonsPage = new ButtonsPage();
    ButtonNameTransformerUtil buttonNameTransformerUtil = new ButtonNameTransformerUtil();

    static Stream<Arguments> clickOnButton() {
        return Stream.of(
                Arguments.of("Double Click Me"),
                Arguments.of("Right Click Me"),
                Arguments.of("Click Me")
        );
    }

    @Epic("demoqa.com")
    @Feature("Buttons")
    @Story("Нажатие кнопок и проверка вывода результата")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на форму Buttons", url = "https://demoqa.com/buttons")
    @MethodSource("clickOnButton")
    @ParameterizedTest
    @Tag("button_tests")
    void clickOnButton(String buttonName) {

        step("Открываем форму", () -> {
            buttonsPage.openPage();
        });

        step("Нажимаем на кнопку " + "'" + buttonName + "'", () -> {
            buttonsPage.clickButton(buttonName);
        });

        step("Проверяем отображение в поле результата текста: 'You have done a " +
                buttonNameTransformerUtil.buttonNameTransformer(buttonName) + "'", () -> {
            buttonsPage.checkResultOfButtonClick(buttonName);
        });
    }

}
