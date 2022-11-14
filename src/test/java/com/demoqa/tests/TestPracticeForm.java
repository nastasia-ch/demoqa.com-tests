package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class TestPracticeForm extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormWithAllData() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .choosePicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .isResultsTableVisible()
                .checkResult("Student Name",firstName+" "+lastName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phoneNumber)
                .checkResult("Date of Birth",dayOfBirth+" "+monthOfBirth+","+yearOfBirth)
                .checkResultArray("Subjects",subjects)
                .checkResultArray("Hobbies",hobbies)
                .checkResult("Picture",pictureName)
                .checkResult("Address",currentAddress)
                .checkResult("State and City",state+" "+city);
    }

    @Test
    void fillFormWithMinimumData() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit()
                .isResultsTableVisible()
                .checkResult("Student Name",firstName+" "+lastName)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phoneNumber);
    }
}
