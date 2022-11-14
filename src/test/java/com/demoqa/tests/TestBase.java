package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.utils.RandomArray;
import com.demoqa.utils.RandomDate;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.*;

public class TestBase {

    private final RandomDate randomDate = new RandomDate();
    private final RandomArray randomArray = new RandomArray();
    Faker faker = new Faker(new Locale("en"));

    // Массивы возможных значений поле Practice Form
    String[] genderList = {"Male","Female","Other"};
    String[] subjectsList = {"Accounting","Arts","Biology","Civics","Chemistry",
            "Computer Science","Commerce","Economics","English","Hindi",
            "History","Maths","Physics","Social Studies"};
    String[] hobbiesList = {"Sports", "Reading", "Music"};
    String[] namePicturesList = {"cat.jpeg","owl.jpeg","raccoon.jpeg"};
    String[] statesList = {"NCR","Uttar Pradesh","Haryana","Rajasthan"};
    String[] citiesNCRList = {"Delhi","Gurgaon","Noida"};
    String[] citiesUttarPradeshList = {"Agra","Lucknow","Merrut"};
    String[] citiesHaryanaList = {"Karnal","Panipat"};
    String[] citiesRajasthan = {"Jaipur","Jaiselmer"};

    // Тестовые данные - генерация/выбор рандомных
    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           email = faker.internet().emailAddress(),
           gender = randomArray.chooseOneRandomValueFromArray(genderList),
           phoneNumber = faker.phoneNumber().subscriberNumber(10),
           monthOfBirth = randomDate.getRandomMonth(),
           yearOfBirth = randomDate.getRandomYear(),
           dayOfBirth = randomDate.getRandomDay(),
           pictureName = randomArray.chooseOneRandomValueFromArray(namePicturesList),
           currentAddress = faker.address().fullAddress(),
           state = randomArray.chooseOneRandomValueFromArray(statesList),
           city = chooseRandomCity();

    String[] subjects = randomArray.chooseFewRandomValuesFromArray(subjectsList),
             hobbies = randomArray.chooseFewRandomValuesFromArray(hobbiesList);

    private String chooseRandomCity() {
        switch (state) {
            case ("NCR"):
                city = randomArray.chooseOneRandomValueFromArray(citiesNCRList);
                break;
            case ("Uttar Pradesh"):
                city = randomArray.chooseOneRandomValueFromArray(citiesUttarPradeshList);
                break;
            case ("Haryana"):
                city = randomArray.chooseOneRandomValueFromArray(citiesHaryanaList);
                break;
            case ("Rajasthan"):
                city = randomArray.chooseOneRandomValueFromArray(citiesRajasthan);
                break;
        }
        return city;
    }

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }
}
