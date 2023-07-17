package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.AutoCompletePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static mailru.nastasiachernega.helpers.ColorFieldsTypes.Single;
import static io.qameta.allure.Allure.step;
import static mailru.nastasiachernega.helpers.ColorFieldsTypes.Multiple;

public class TestsAutoComplete extends WebDriverProvider {

    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @ValueSource(strings = {
            "blue",
            "white"
    })
    @ParameterizedTest
    void typeValidColorInSingleField(String value) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле валидное значение цвета: " + value, () ->
                autoCompletePage.typeOneColor(Single, value)
        );

        step("Проверяем закрепление цвета в поле", () ->
                autoCompletePage.colorShouldBeFixed(Single, value)
        );

    }

    @ValueSource(strings = {
            "sun"
    })
    @ParameterizedTest
    void typeInvalidColorInSingleField(String value) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + value, () ->
                autoCompletePage.typeOneColor(Single, value)
        );

        step("Проверяем, что введенный цвет в поле не закрепился", () ->
                autoCompletePage.colorShouldNOTBeFixed(Single, value)
        );

    }

    static Stream<Arguments> typeValidColorInMultipleField() {
        return Stream.of(
                Arguments.of(List.of("white", "black", "green", "purple", "yellow"))
        );
    }

    @MethodSource()
    @ParameterizedTest
    void typeValidColorInMultipleField(List<String> values) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле валидные значение цвета: " + values, () ->
                autoCompletePage.typeSomeColors(Multiple, values)
        );

        step("Проверяем закрепление введенных цветов в поле", () ->
                autoCompletePage.someColorsShouldBeFixed(Multiple, values)
        );

    }

    static Stream<Arguments> typeInvalidColorInMultipleField() {
        return Stream.of(
                Arguments.of(List.of("sun", "moon", "hello"))
        );
    }

    @MethodSource()
    @ParameterizedTest
    void typeInvalidColorInMultipleField(List<String> values) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидные значения цвета: " + values, () ->
                autoCompletePage.typeSomeColors(Multiple, values)
        );

        step("Проверяем, что введенные цвета в поле не закрепились", () ->
                autoCompletePage.someColorShouldNOTBeFixed(Multiple, values)
        );

    }

    @CsvSource(value = {
            "sun, white"
    })
    @ParameterizedTest
    void typeInvalidAndThenValidColor1(String inValidValue, String validValue) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + inValidValue, () ->
                autoCompletePage.typeOneColor(Multiple, inValidValue)
        );

        step("Проверяем, что введенное невалидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(Multiple, inValidValue)
        );

        step("Вводим в поле валидное значение цвета: " + validValue, () ->
                autoCompletePage.typeOneColor(Multiple, validValue)
        );

        step("Проверяем, что введенное валидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(Multiple, validValue)
        );
    }

    @CsvSource(value = {
            "sun, white"
    })
    @ParameterizedTest
    void typeInvalidAndThenValidColor2(String inValidValue, String validValue) {

        step("Открываем форму", () ->
                autoCompletePage.openPage()
        );

        step("Вводим в поле невалидное значение цвета: " + inValidValue, () ->
                autoCompletePage.typeOneColor(Multiple, inValidValue)
        );

        step("Проверяем, что введенное невалидное значение цвета в поле не закрепилось", () ->
                autoCompletePage.colorShouldNOTBeFixed(Multiple, inValidValue)
        );

        step("Удаляем из поля невалидное значение цвета кнопкой Backspace", () ->
                autoCompletePage.clearInputValueByBackspace(Multiple, inValidValue)
        );

        step("Вводим в поле валидное значение цвета: " + validValue, () ->
                autoCompletePage.typeOneColor(Multiple, validValue)
        );

        step("Проверяем, что введенное валидное значение цвета в поле закрепилось", () ->
                autoCompletePage.colorShouldBeFixed(Multiple, validValue)
        );

    }

}
