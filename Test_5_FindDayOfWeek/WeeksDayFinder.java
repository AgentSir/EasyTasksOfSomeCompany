package Test_5_FindDayOfWeek;

import java.util.LinkedList;
import java.util.List;

/**
 * WeeksDayFinder serves for search name of the weeks day from entered number of day in the month,
 * and number of month in the year then known the weeks day name of first day of year.
 * This applications work correctly only for no leap-year.
 */
public class WeeksDayFinder {

    // Array stored number of days in months
    private final int [] AMOUNT_OF_DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int MAX_NUMBER_OF_WEEKS_DAYS = 7;

    // Array stored names of week days
    private List<String> daysOfWeek = new LinkedList<String>();

    // The constructor that takes as parameter number of weeks day assuming that the first weeks day is a Monday
    public WeeksDayFinder (int firstDayOfYear) {
        //Set up the weeks days names in the right order
        daysOfWeek.add("MON");
        daysOfWeek.add("TUS");
        daysOfWeek.add("WED");
        daysOfWeek.add("THU");
        daysOfWeek.add("FRI");
        daysOfWeek.add("SAT");
        daysOfWeek.add("SUN");

        // The loop set up the first day of year as first day of week in weeks days list
        // At the same time shifting all other days
        for (int i = 0; i < daysOfWeek.size() - (firstDayOfYear - 1); i++) {
           daysOfWeek.add(i, daysOfWeek.get(firstDayOfYear + i - 1));
           daysOfWeek.remove(firstDayOfYear + i);
        }
    }

    /** Implementation the search name of the weeks day from date
     *
     * @param day - number of day in the month.
     * @param month - number of month in the year.
     * @return name of weeks day as "String"
     */
    public String findDayOfWeek(int day, int month) {
        int numberOfDaysFromBeginningYear = 0;

        for (int i = 0; i < month - 1; i++) {
            numberOfDaysFromBeginningYear += AMOUNT_OF_DAYS_IN_MONTHS[i];
        }
        numberOfDaysFromBeginningYear += day;

        int integerPart = numberOfDaysFromBeginningYear / MAX_NUMBER_OF_WEEKS_DAYS;
        int numberOfDaysFromBeginningYearTwo = integerPart * MAX_NUMBER_OF_WEEKS_DAYS;

        return daysOfWeek.get((numberOfDaysFromBeginningYear - numberOfDaysFromBeginningYearTwo) - 1);
    }

    // Test drive
    public static void main(String[] args) {
        WeeksDayFinder finder = new WeeksDayFinder(3);
        System.out.println(finder.findDayOfWeek(17, 7));
    }
}
