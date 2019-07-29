package test;

import test.RegistrationInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Scheduler {
    private static String monthsOfYr[] = {"January", "February", "March", "April", "May",
                                   "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        Calendar calendar = new Calendar();
        String username = "", timezone = "", cmd = "";
        PlanEvent event = null;
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
        System.out.printf("%-2s %s\n", "Welcome back ", username);
        while (!cmd.equals("Quit"))
        {
            cmd = getCmd(console);
            if (cmd.toLowerCase().equals("add"))
            {
                event = new PlanEvent();
            }
            else if(cmd.toLowerCase().equals("save"))
            {
                if (event != null)
                {
                    calendar.add(event);
                }
                else
                {
                    System.out.println("Please make a new event first to save!");
                }
            }
        }
        System.out.println("Goodbye!");
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
            System.out.printf("%-2s", "Enter a command [View Schedule, Add, Remove, Quit]: ");
            cmd = console.nextLine();
        } while (!(cmd.toLowerCase().equals("view schedule")) && !(cmd.toLowerCase().equals("add") && !(cmd.toLowerCase().equals("remove") && !(cmd.toLowerCase().equals("quit")))));
        return cmd;
    }

}

