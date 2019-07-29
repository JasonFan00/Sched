package test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class PlanEvent
{
    private int month;
    private int dayOfMonth;
    private int year;
    private double startTime; //  Will treat time from 0 - 24

    private PrintStream pStream;
    private String desc;
	private String urgency;
    private final String urgencyLvls[] = {"!", "!!", "!!!"};
    private static String monthsOfYr[] = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    private HashMap<String, String> planData;

    public PlanEvent() throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        planData = new HashMap<>();
        pStream = new PrintStream(new File("EventLog.txt"));
        promptAddInfo(console);
        promptDescInfo(planData, console);
        System.out.println(this);
    }

    private void promptAddInfo(Scanner console)
    {
        String date = "";
        for (int i = 0; i < monthsOfYr.length; i++)
        {
            System.out.printf("%s %d]", "[" + monthsOfYr[i], i+1);
        }
        System.out.print("\nEnter the date you wish to schedule for [MM/DD/YY]: ");
        date = console.next();
        try
        {
            month      = Integer.parseInt(date.substring(0, 2));
            dayOfMonth = Integer.parseInt(date.substring(3, 5));
            year       = Integer.parseInt(date.substring(6, 8));
            System.out.println("Plan scheduled for: " + this.month + "/" + this.dayOfMonth + "/" + this.year);
        } catch (NumberFormatException e) {
            System.out.println("Numberformatexception");
        }
    }

    private void promptDescInfo(HashMap<String, String> planData, Scanner console)
    {
        System.out.printf("%-2s", "What do you have planned?");
        planData.put("description", console.nextLine());
        System.out.print("Enter urgency [");
        for (int i = 0; i < urgencyLvls.length; i++)
        {
            System.out.print(urgencyLvls[i]);
        }
        System.out.print("]: ");
        planData.put("urgency", console.next());
    }

    public boolean equals(Object o)
    {
        if (o instanceof PlanEvent && ((PlanEvent)o).dayOfMonth == this.dayOfMonth && ((PlanEvent)o).month == this.month
            && ((PlanEvent)o).year == this.year && ((PlanEvent)o).startTime == this.startTime)
        {

        }
        return false;
    }

    public String toString()
    {
        String event = this.month + "/" + this.dayOfMonth + this.year + ": " + this.planData.get("description") + this.planData.get("urgency");
        return event;
    }

}