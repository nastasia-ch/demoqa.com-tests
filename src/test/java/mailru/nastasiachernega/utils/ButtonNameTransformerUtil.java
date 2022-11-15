package mailru.nastasiachernega.utils;

public class ButtonNameTransformerUtil {

    public String buttonNameTransformer(String buttonName) {
        if(buttonName == "Double Click Me") {
            buttonName = buttonName.substring(0,11).toLowerCase();
        };
        if(buttonName == "Right Click Me") {
            buttonName = buttonName.substring(0,10).toLowerCase();
        };
        if(buttonName == "Click Me") {
            buttonName = "dynamic" + " " + buttonName.substring(0,4).toLowerCase();
        };
        return buttonName;
    }

}
