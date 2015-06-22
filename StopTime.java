
package pset7;
 
import javax.persistence.*;
 
 
/** 
  * User: wilsonstls 
  * Date: 6/17/15
  */ 
 
 
@Entity
@Table(name="stop_times") 
public class StopTime {


     @Id
     @Column(name = "arrival_time")
     private String arrivalTime;
     @Column(name = "stop_id")
     private Integer stopTimeID;


     public String getArrivalTime() {return arrivalTime;}
     public void setArrivalTime(String arrivalTime) {this.arrivalTime = arrivalTime;}



} 
 

