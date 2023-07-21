package mailru.nastasiachernega.tests;

import mailru.nastasiachernega.utils.RandomArray;
import mailru.nastasiachernega.utils.RandomDate;
import com.github.javafaker.Faker;

import java.util.*;

public class TestDate {

    private final RandomDate randomDate = new RandomDate();
    private final RandomArray randomArray = new RandomArray();
    Faker faker = new Faker(new Locale("en"));

    // Массивы возможных значений поле Practice Form
    public String[] genderList = {"Male","Female","Other"};
    public String[] subjectsList = {"Accounting","Arts","Biology","Civics","Chemistry",
            "Computer Science","Commerce","Economics","English","Hindi",
            "History","Maths","Physics","Social Studies"};
    public String[] hobbiesList = {"Sports", "Reading", "Music"};
    public String[] namePicturesList = {"cat.jpeg","owl.jpeg","raccoon.jpeg"};
    public String[] statesList = {"NCR","Uttar Pradesh","Haryana","Rajasthan"};
    public String[] citiesNCRList = {"Delhi","Gurgaon","Noida"};
    public String[] citiesUttarPradeshList = {"Agra","Lucknow","Merrut"};
    public String[] citiesHaryanaList = {"Karnal","Panipat"};
    public String[] citiesRajasthan = {"Jaipur","Jaiselmer"};

    // Тестовые данные - генерация/выбор рандомных
    public String fullName = faker.name().fullName(),
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

    public String[] subjects = randomArray.chooseFewRandomValuesFromArray(subjectsList),
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

    // Значения для Tabs
    public HashMap<String, ArrayList<String>> tabs = new HashMap<>();
    {
        tabs.put("What", new ArrayList<>());
        tabs.get("What").add(0,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        tabs.put("Origin", new ArrayList<>());
        tabs.get("Origin").add(0,"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
        tabs.get("Origin").add(1, "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
        tabs.put("Use", new ArrayList<>());
        tabs.get("Use").add("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
    }


}
