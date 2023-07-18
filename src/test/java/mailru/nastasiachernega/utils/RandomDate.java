package mailru.nastasiachernega.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    private LocalDate generateRandomDate() {

        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2100, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

        return randomBirthDate;
    }

    public String getRandomDay() {
        DateTimeFormatter dayFormat = new DateTimeFormatterBuilder().
                parseCaseInsensitive().
                appendPattern("dd").
                toFormatter(Locale.US);
        String randomDay = generateRandomDate().format(dayFormat);
        return randomDay;
    }

    public String getRandomMonth() {
        DateTimeFormatter monthFormat = new DateTimeFormatterBuilder().
                parseCaseInsensitive().
                appendPattern("MMMM").
                toFormatter(Locale.US);
        String randomMonth = generateRandomDate().format(monthFormat);
        return randomMonth;
    }

    public String getRandomYear() {
        DateTimeFormatter yearFormat = new DateTimeFormatterBuilder().
                parseCaseInsensitive().
                appendPattern("yyyy").
                toFormatter(Locale.US);
        String randomYear = generateRandomDate().format(yearFormat);
        return randomYear;
    }

    private String generateRandomHour() {
        int hourInt = random.nextInt(0, 23);
        String hourString = hourInt + "";
        if (hourInt < 10) {
            hourString = "0" + hourInt;
        }
        return hourString;
    }

    private String generateRandomMinutes() {
        int randomNumber = random.nextInt(0,3);
        int minutesInt = 15*randomNumber;
        String minutesString = minutesInt + "";
        if (minutesInt < 10) {
            minutesString = "0" + minutesInt;
        }
        return minutesString;
    }

    public String getRandomTime() {
        return generateRandomHour() + ":" + generateRandomMinutes();
    }

}
