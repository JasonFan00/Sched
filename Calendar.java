package test;
import java.util.*;
import java.io.*;

public class Calendar
{
    private final int MAX_EVENTS_PER_DAY = 12;
    private Object calendar[][];
    private int daysPerMonth[];
    int days;

    public Calendar()
    {
        calendar = new Object[365][MAX_EVENTS_PER_DAY]; //  [Days][Specific events (of type individualday)]
        /*daysPerMonth = new int[12];
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
        */
    }

    public boolean add(PlanEvent day) throws FileNotFoundException
    {
        File f = new File("schedule.txt");  //  If exists, overwrite, if not create new file
        PrintStream pStream = new PrintStream(f);
        pStream.println(day);
        return false;
    }

    public String toString()
    {
        String display = "";
        return display;
    }
}
