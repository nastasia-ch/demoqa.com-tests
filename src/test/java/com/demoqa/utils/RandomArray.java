package com.demoqa.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArray {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    // Для полей, где можно ввести/выбрать более 1ого значения:
    // генерация массива, в который рандомно включается одно или несколько из возможных значений
    public String[] chooseFewRandomValuesFromArray(String[] valuesList) {
        int randomNumber = random.nextInt(1, valuesList.length)+1;
        String[] values = new String[randomNumber];
        for (int i = 0; i < randomNumber; i++) {
            String value = valuesList[random.nextInt(valuesList.length)];
            if (Arrays.asList(values).contains(value)) {
                i--;
            } else {
                values[i] = value;
            }
        }
        return values;
    }

    // Для полей, где можно ввести/выбрать только 1 значение:
    // рандомный выбор одного из возможных значений
    public String chooseOneRandomValueFromArray(String[] valuesList) {
        String value = valuesList[random.nextInt(valuesList.length)];
        return value;
    }

}
