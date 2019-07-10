package test;

import java.util.HashMap;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class IndividualDay
{
    public int month;
    public int dayOfMonth;
    public int year;
    public double startTime; //  Will treat time from 0 - 24

    private String desc;
	private String urgency;

    public IndividualDay(HashMap<String, Integer> timeData, HashMap<String, String> info)
    {
        month = timeData.get("month");
        dayOfMonth = timeData.get("day");
        year = timeData.get("year");
        startTime = timeData.get("startTime");

        desc = info.get("description");
		urgency = info.get("urgency");
    }

    public void deleteDay()
    {  //  For when they want to do modifications

    }

    public void saveDay()
    {
		File f = new File("DayTasksLog.txt");
		FileWriter fWriter;
		if (!f.exists())
		{
			f.createNewFile();
		}
		fWriter = new FileWriter(f);
		fWriter.write(Integer.toString(month) + "/" + Integer.toString(dayOfMonth) + "/" + Integer.toString(year) + " " + startTime + " " + desc + " " + urgency);
    }

}