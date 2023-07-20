package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.utils.RandomArray;
import mailru.nastasiachernega.utils.RandomDate;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDate {

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
    String fullName = faker.name().fullName(),
           firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           validEmail = faker.internet().emailAddress(),
           invalidEmail = faker.name().username(),
           gender = randomArray.chooseOneRandomValueFromArray(genderList),
           phoneNumber = faker.phoneNumber().subscriberNumber(10),
           month = randomDate.getRandomMonth(),
           year = randomDate.getRandomYear(),
           day = randomDate.getRandomDay(),
           pictureName = randomArray.chooseOneRandomValueFromArray(namePicturesList),
           currentAddress = faker.address().fullAddress(),
           permanentAddress = faker.address().fullAddress(),
           state = randomArray.chooseOneRandomValueFromArray(statesList),
           city = chooseRandomCity(),
           time = randomDate.getRandomTime();

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

}
