
package pset7.dao; 

import org.hibernate.criterion.*;
import pset7.AppOutput;
import pset7.MetrolinkDao; 
import pset7.Stop;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;
import pset7.StopTime;
import java.util.List;
import java.util.Scanner;


@Repository 
public class SqliteJDBCDao implements MetrolinkDao { 
 
 
     @Autowired 
     private AppOutput appOutput; 
     @Autowired 
     private SessionFactory sessionFactoryBean; 


     public List<Stop> getStopsAllStops() {
         //@TODO
         appOutput.print("list of Metrolink stations... and ID number \n");
         sessionFactoryBean.getCurrentSession().beginTransaction(); 
         Criteria cr = sessionFactoryBean.getCurrentSession().createCriteria(Stop.class);
         cr.add( Restrictions.like("stopName", "%LINK STATION"));
         cr.addOrder( Order.asc("stopName") );
         List list = cr.list();
         sessionFactoryBean.getCurrentSession().getTransaction().commit(); 
         return list;
     }

    public List<StopTime> getStopTimeMyStop() {
        appOutput.print("\n Enter the ID of your current metrolink station and this program ");
        appOutput.print(" will calculate the number of minutes until the next train arrives \n");
        appOutput.print(" Enter your station's ID  ");
        Scanner userInput = new Scanner(System.in);
        int stationID = userInput.nextInt();
        appOutput.print("\n Station ID:  "+stationID +" \n");

        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria cr = sessionFactoryBean.getCurrentSession().createCriteria(StopTime.class);
        cr.add(Restrictions.eq("stopTimeID", stationID));
        cr.addOrder(Order.asc("arrivalTime"));
        /** retrieves 1st arrival_time that is > current time  */
        cr.add(Restrictions.sqlRestriction("arrival_time > (time('now','localtime'))"));
        cr.setFirstResult(0);
        cr.setMaxResults(1);
        List list = cr.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }


} 
 
