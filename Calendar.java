package test;
import java.util.*;

public class Calendar
{
    private IndividualDay megaCalendar[][][];  //  [months][weeks][days]
    private int daysPerMonth[];
    int days;

    public Calendar(int targetMonth)
    {
        megaCalendar = new IndividualDay[12][52][7];
        daysPerMonth = new int[12];
        daysPerMonth[0] = 31;  // Jan
        daysPerMonth[1] = 28;  // Feb
        daysPerMonth[2] = 31;  // Mar
        daysPerMonth[3] = 30;  // April
        daysPerMonth[4] = 31;  // May
        daysPerMonth[5] = 30;  // June
        daysPerMonth[6] = 31;  // July
        daysPerMonth[7] = 31;  // Aug
        daysPerMonth[8] = 30;  // Sep
        daysPerMonth[9] = 31;  // Oct
        daysPerMonth[10] = 30; // Nov
        daysPerMonth[11] = 31; // Dec

    }

    public boolean add(IndividualDay day)
    {

        return false;
    }

    public IndividualDay[][][] addDate(int day)
    {

        return megaCalendar;
    }

    public String toString()
    {
        String display = "";
        return display;
    }
}
