package homework_csv.homework_csv;
import java.io.IOException;

import homework_csv.homework_csv.firstTask.ConfigurationFirstTask;
import homework_csv.homework_csv.secondTask.ConfigurationSecondTask;
import homework_csv.homework_csv.thirdTask.ConfigurationThirdTask;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ConfigurationThirdTask thirdTask = new ConfigurationThirdTask();
    	thirdTask.runThirdTask();
    	ConfigurationSecondTask secondTask = new ConfigurationSecondTask();
    	secondTask.runSecondTask();
    	ConfigurationFirstTask firstTask = new ConfigurationFirstTask();
    	firstTask.runFirstTask();
    }
}
