package mailru.nastasiachernega.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YearSearch {

    private final SelenideElement
            upcomingButton = $(".react-datepicker__navigation--years-upcoming"),
            previousButton = $(".react-datepicker__navigation--years-previous");

    private final ElementsCollection
            listOfYears = $$(".react-datepicker__year-option");

    public void search(String year) {

        int searchingYear = Integer.parseInt(year);
        int upperYear = Integer.parseInt(getText(listOfYears.get(1)));
        int lowYear = Integer.parseInt(getText(listOfYears.get(11)));
        int differenceInYears;
        if (upperYear < searchingYear) {
            differenceInYears = searchingYear - upperYear;
            for (int i = 0; i < differenceInYears; i++) {
                upcomingButton.click();
            }
            listOfYears.get(1).click();
        }
        if (lowYear > searchingYear) {
            differenceInYears = lowYear - searchingYear;
            for (int i = 0; i < differenceInYears; i++) {
                previousButton.click();
            }
            listOfYears.get(11).click();
        } else {
            listOfYears.findBy(text(year)).click();
        }
    }

    private String getText(SelenideElement element) {
        String text = element.toString();
        int beginIndex = (text.indexOf(">")) + 1;
        int endIndex = text.indexOf("</");
        return text.substring(beginIndex, endIndex);
    }

}
