package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.pages.ButtonsPage;
import mailru.nastasiachernega.utils.ButtonNameTransformerUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TestsButtons extends TestConfig {

    ButtonsPage buttonsPage = new ButtonsPage();
    ButtonNameTransformerUtil buttonNameTransformerUtil = new ButtonNameTransformerUtil();

    static Stream<Arguments> clickOnButton() {
        return  Stream.of(
                Arguments.of("Double Click Me"),
                Arguments.of("Right Click Me"),
                Arguments.of("Click Me")
        );
    }
    @MethodSource("clickOnButton")
    @ParameterizedTest
    void clickOnButton(String buttonName) {

        step("Открываем форму", ()-> {
            buttonsPage.openPage();
        });

        step("Нажимаем на кнопку" + "'" + buttonName + "'", ()-> {
            buttonsPage.clickButton(buttonName);
        });

        step("Проверяем отображение под кнопками текста: 'You have done a " +
                buttonNameTransformerUtil.buttonNameTransformer(buttonName) + "'", ()-> {
            buttonsPage.checkResultOfButtonClick(buttonName);
        });
    }

}
