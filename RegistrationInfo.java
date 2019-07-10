package test;

import java.util.*;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class RegistrationInfo
{
    public String name = "";
    public String timezone = "";

    private String nameRegistration(Scanner console)
    {
        String name = console.nextLine();
        System.out.print("Is " + name + " your desired name? [Y / N]: ");
        if (console.nextLine().equals("N"))
        {
            do
            {
                System.out.print("Please enter your name: ");
                name = console.nextLine();
                System.out.print("Is " + name + " your desired name? [Y / N]: ");
            } while (!console.nextLine().equals("Y"));
        }
        return name;
    }

    private String timezoneRegistration(Scanner console)
    {
        String timezone = console.nextLine();
        System.out.print("Is " + timezone + " your timezone? [Y / N]: ");
        if (console.nextLine().equals("N"))
        {
            do
            {
                System.out.print("Please enter your timezone [PST , CST , EST]: ");
                timezone = console.nextLine();
                System.out.print("Is " + timezone + " your timezone? [Y / N]: ");
            } while (!console.nextLine().equals("Y"));
        }
        return timezone;
    }

    public boolean saveConfig(Properties configP)
    {
        File fConfig = new File("config.txt");
        try
        {
            OutputStream outStream = new FileOutputStream(fConfig);
            configP.setProperty("name", name);
            configP.setProperty("timezone", timezone);
            configP.store(outStream, null);
        }
        catch (Exception e)
        {

        }
        return false;
    }

    public RegistrationInfo(boolean initialSetup)
    {
        Scanner console = new Scanner(System.in);
        Properties configProperties = new Properties();
        //  Setup first time if no config stuff available
        if (initialSetup)
        {
            System.out.print("-First Time Setup- \nPlease enter your name: ");
            name = nameRegistration(console);
            System.out.println("User name has been set to: " + name);
            System.out.print("Please enter your timezone [PST , CST , EST]: ");
            timezone = timezoneRegistration(console);
            System.out.println("-Setup Saved-");
            saveConfig(configProperties);
        }
        //  Load in data
        try
        {
            InputStream ins = new FileInputStream("config.txt");
            if (ins != null)
            {
                configProperties.load(ins);
            }
        }
        catch (Exception e)
        {

        }
        name = configProperties.getProperty("name");
        timezone = configProperties.getProperty("timezone");
    }
}
