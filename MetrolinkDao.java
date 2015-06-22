package pset7; 

import java.util.List; 
 
 
/** 
  * User: wilsonstls
  * Date: 6/3/15 
  * Time: 1:48 AM 
  */ 
public interface MetrolinkDao { 
 
 
     public List<Stop> getStopsAllStops();
     public List<StopTime> getStopTimeMyStop();

} 
