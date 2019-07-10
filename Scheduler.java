package test;

import test.RegistrationInfo;

import java.io.File;
import java.util.*;


public class Scheduler {
    private static String monthsOfYr[] = {"January", "February", "March", "April", "May",
                                   "June", "July", "August", "September", "October", "November", "December"};
    static String urgencyLvls[] = {"!", "!!", "!!!"};

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        String username = "", timezone = "", cmd = "";
        if (!checkIntegrity())
        {
            RegistrationInfo regInfo = new RegistrationInfo(true);
            username = regInfo.name;
            timezone = regInfo.timezone;
        }
        else
        {
            RegistrationInfo regInfo = new RegistrationInfo(false);
            username = regInfo.name;
            timezone = regInfo.timezone;
        }
        System.out.printf("%-2s %s", "Welcome back ", username);
        while (true)
        {
            cmd = getCmd(console);
            if (cmd.equals("Add"))
            {
                HashMap<String, Integer> timeData = new HashMap<String, Integer>();
                HashMap<String, String> Info = new HashMap<String, String>();
                promptAddInfo(timeData, console);
                promptDescInfo(Info, console);
                IndividualDay day = new IndividualDay(timeData, Info);
            }
        }
    }

    //  Make sure config files are in place
    private static boolean checkIntegrity()
    {
        File fConfig = new File("config.txt");
        try
        {
            if (!fConfig.createNewFile())
            {
                RegistrationInfo regInfo = new RegistrationInfo(false);
                if (regInfo.name != null)
                {
                    //  File exists
                    return true;
                }
            }
            //  File does not exist, creates new one (Return false to show is first time setup)
            return false;
        } catch (Exception e) {

        }
        return false;
    }

    private static String getCmd(Scanner console)
    {
        String cmd = "";
        do
        {
            cmd = console.nextLine();
            System.out.printf("%-2s", "Enter a command [View Schedule, Add, Remove] for a schedule date:");
        } while (!(cmd.equals("View Schedule")) && !(cmd.equals("Add") && !(cmd.equals("Remove"))));
        return cmd;
    }

    private static void promptAddInfo(HashMap<String, Integer> timeData, Scanner console)
    {
        String date = "";
        for (int i = 0; i < monthsOfYr.length; i++)
        {
            System.out.printf("[%2d] %3s%-3s", monthsOfYr[i], i+1, " ");
            if (i == 6)
            {
                System.out.println();
            }
        }
        System.out.print("Enter the date you wish to schedule for [MM/DD/YY]: ");
        date = console.next();
        try
        {
            timeData.put("month", Integer.parseInt(date.substring(0, 2)));
            timeData.put("day", Integer.parseInt(date.substring(3, 5)));
            timeData.put("year", Integer.parseInt(date.substring(6, 8)));
        } catch (NumberFormatException e) {
            System.out.println("Numberformatexception");
        }
    }

    private static void promptDescInfo(HashMap<String, String> descData, Scanner console)
    {
        System.out.printf("%-2s", "What do you have planned?");
        descData.put("description", console.nextLine());
        System.out.print("Enter urgency [");
        for (int i = 0; i < urgencyLvls.length; i++)
        {
            System.out.print(urgencyLvls[i]);
        }
        System.out.print("]: ");
        descData.put("urgency", console.next());
    }
}

