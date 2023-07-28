package mailru.nastasiachernega.pages.interractions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SortablePage {

    ElementsCollection list
            = $("#demo-tabpane-list").$$(".list-group-item");

    private final static String TITLE_TEXT = "Sortable";
    private List<String> initialList = new ArrayList<>();
    private List<String> sortableList = new ArrayList<>();

    public SortablePage openPage() {
        open("/sortable");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public SortablePage dragAndDrop(String boxFrom, String boxTo) {
        SelenideElement sourceElement = list.findBy(text(boxFrom));
        SelenideElement targetElement = list.findBy(text(boxTo));
                actions().dragAndDrop(sourceElement,targetElement).perform();
        return this;
    }

    public SortablePage checkInitialOrder() {
        initialList = Arrays.asList("One","Two","Three","Four","Five","Six");
        int i = 0;
        for (SelenideElement element : list) {
            element.shouldHave(text(initialList.get(i)));
            i++;
        }
        return this;
    }

    public SortablePage checkNewOrder(String boxFrom, String boxTo) {
        sortableList = getNewOrder(boxFrom, boxTo);
        int i = 0;
        for (SelenideElement element : list) {
            element.shouldHave(text(sortableList.get(i)));
            i++;
        }
        return this;
    }

    private List<String> getInitialOrder() {
        List<String> initialList = new ArrayList<>();
        for (SelenideElement element : list) {
            initialList.add(element.text());
        }
        return initialList;
    }

    private List<String> getNewOrder(String boxFrom, String boxTo) {
        initialList = getInitialOrder();
        List<String> sortableList = new ArrayList<>();
        if (initialList.indexOf(boxFrom) > initialList.indexOf(boxTo)) {
            for (int i = 0; i < initialList.indexOf(boxFrom); i++) {
                sortableList.add(initialList.get(i));
            }
            for (int i = initialList.indexOf(boxFrom); i <= initialList.indexOf(boxTo); i++) {
                if (i == initialList.indexOf(boxTo)) {
                    sortableList.add(boxFrom);
                }
                else {
                    sortableList.add(initialList.get(i+1));
                }
            }
            for (int i = initialList.indexOf(boxTo)+1; i < initialList.size(); i++) {
                sortableList.add(initialList.get(i));
            }
        }
        else {
            for (int i = 0; i < initialList.indexOf(boxTo); i++) {
                sortableList.add(initialList.get(i));
            }
            for (int i = initialList.indexOf(boxTo); i <= initialList.indexOf(boxFrom); i++) {
                if (i == initialList.indexOf(boxTo)) {
                    sortableList.add(boxFrom);
                }
                else {
                    sortableList.add(initialList.get(i+1));
                }
            }
            for (int i = initialList.indexOf(boxFrom)+1; i < initialList.size(); i++) {
                sortableList.add(initialList.get(i));
            }
        }

        return sortableList;
    }


}
