package mailru.nastasiachernega.tests;

import io.qameta.allure.*;
import mailru.nastasiachernega.config.WebDriverProvider;
import mailru.nastasiachernega.pages.ProgressBarPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsProgressBar extends WebDriverProvider {

    ProgressBarPage progressBarPage = new ProgressBarPage();

    @Epic("demoqa.com")
    @Feature("Progress Bar")
    @Story("Запуск Progress Bar")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Progress Bar", url = "https://demoqa.com/progress-bar")
    @DisplayName("Запуск Progress Bar")
    @CsvSource(value = {
            "29",
            "78"
    })
    @ParameterizedTest
    void startProgressBar(int targetProgress) throws InterruptedException {

        step("Открываем раздел Progress Bar", () -> {
            progressBarPage.openPage();
        });

        step("Нажимаем Start", () -> {
            progressBarPage
                    .checkStartStopButtonName("Start")
                    .clickStart();
        });

        step("Ждем " + targetProgress * 100 + " миллисекунд (до прогресса "
                + targetProgress + "%)", () -> {
            progressBarPage.waiting(targetProgress);
        });

        step("Нажимаем Stop", () -> {
            progressBarPage
                    .checkStartStopButtonName("Stop")
                    .clickStop();
        });

        step("Проверяем, что Progress Bar достигла "
                + targetProgress + "%", () -> {
            progressBarPage
                    .checkProgress(targetProgress);
        });

    }

    @Epic("demoqa.com")
    @Feature("Progress Bar")
    @Story("Сброс Progress Bar")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Progress Bar", url = "https://demoqa.com/progress-bar")
    @DisplayName("Сброс Progress Bar")
    @Test
    void resetProgressBar() {

        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем 1000 миллисекунд (до прогресса 100%)", () -> {
                progressBarPage.waiting(100);
            });

            step("Проверяем, что Progress Bar достигла 100%", () -> {
                progressBarPage
                        .checkProgress(100);
            });

        });

        step("Тестовые шаги", () -> {

            step("Нажимаем Reset", () -> {
                progressBarPage.clickReset();
            });

            step("Проверяем сброс прогресса", () -> {
                progressBarPage
                        .checkProgress(0)
                        .checkStartStopButtonName("Start");
            });

        });

    }

    @Epic("demoqa.com")
    @Feature("Progress Bar")
    @Story("Проверка цвета прогресса Progress Bar")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Progress Bar", url = "https://demoqa.com/progress-bar")
    @DisplayName("Проверка цвета прогресса Progress Bar")
    @ValueSource(strings = {
            "45"
    })
    @ParameterizedTest
    void checkProgressColor(int targetProgress) {
        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем " + targetProgress * 100 + " миллисекунд (до прогресса "
                    + targetProgress + "%)", () -> {
                progressBarPage.waiting(targetProgress);
            });

            step("Нажимаем Stop", () -> {
                progressBarPage
                        .checkStartStopButtonName("Stop")
                        .clickStop();
            });

            step("Проверяем, что Progress Bar достигла "
                    + targetProgress + "%", () -> {
                progressBarPage
                        .checkProgress(targetProgress);
            });

        });

        step("Тестовые шаги", () -> {

            step("Проверяем цвет Progress Bar: должен быть голубой", () -> {
                progressBarPage.checkProgressColor();
            });

        });
    }

    @Epic("demoqa.com")
    @Feature("Progress Bar")
    @Story("Проверка цвета 100% прогресса Progress Bar")
    @Owner("Anastasia Chernega")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Progress Bar", url = "https://demoqa.com/progress-bar")
    @DisplayName("Проверка цвета 100% прогресса Progress Bar")
    @Test
    void checkFullProgressColor() {

        step("Предусловия", () -> {

            step("Открываем раздел Progress Bar", () -> {
                progressBarPage.openPage();
            });

            step("Нажимаем Start", () -> {
                progressBarPage
                        .checkStartStopButtonName("Start")
                        .clickStart();
            });

            step("Ждем 1000 миллисекунд (до прогресса 100%)", () -> {
                progressBarPage.waiting(100);
            });

            step("Проверяем, что Progress Bar достигла 100%", () -> {
                progressBarPage
                        .checkProgress(100);
            });

        });

        step("Тестовые шаги", () -> {

            step("Проверяем цвет Progress Bar: должен быть зеленый", () -> {
                progressBarPage.checkFullProgressColor();
            });

        });

    }


}
