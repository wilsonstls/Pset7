
package pset7; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

 
/** 
  * User: wilsonstls
  * Date: 6/22/15
  */ 
 

@Component 
public class MetrolinkCommandLineApp { 
 
 
     public static void main(String[] varArgs) throws ParseException {
         ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml"); 
         MetrolinkCommandLineApp metrolinkCommandLineApp = 
                 (MetrolinkCommandLineApp) context.getBean("metrolinkCommandLineApp"); 
         metrolinkCommandLineApp.run(); 
     } 
 
 
     private void run() throws ParseException {
        /* list name, id of all metrolink stops */
         List<Stop> stopsAllStops = metrolinkDao.getStopsAllStops();
         for (Stop stop : stopsAllStops) { 
             appOutput.print(String.format("--- %s ---    %s", stop.getStopName(), stop.getStopID()));
         }

        /* calculates number of minutes for next train arrival */
         List<StopTime> stopTimeMyStop = metrolinkDao.getStopTimeMyStop();
         for (StopTime stoptime : stopTimeMyStop) {
             SimpleDateFormat format = new SimpleDateFormat("HH:mm");
             Date date1 = format.parse(String.valueOf(LocalTime.now()));  //current time
             Date date2 = format.parse(stoptime.getArrivalTime());        //next arrival time
             long diffMinutes = (date2.getTime() - date1.getTime()) / 60 / 1000;
             appOutput.print(String.format("next train arrives in  " +diffMinutes+ "  minutes"));
         }

     }


     @Autowired 
     private MetrolinkDao metrolinkDao; 
     @Autowired 
     private AppOutput appOutput; 
 
 
} 

