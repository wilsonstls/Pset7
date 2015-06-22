
package pset7;
 
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
 
 
/** 
  * User: wilsonstls 
  * Date: 6/3/15
  * Time: 1:40 AM 
  */ 
 
 
@Entity
@Table(name="stops")
public class Stop {


     @Id
     @GeneratedValue(strategy = IDENTITY)
     @Column(name = "stop_id", unique = true, nullable = false) 
     private Integer stopID;
     @Column(name = "stop_name")
     private String stopName;


     public String getStopName() {return stopName; }
     public void setStopName(String stopName) {this.stopName = stopName; } 

     public Integer getStopID() {return stopID;}
     public void setStopID(Integer stopID) {this.stopID = stopID;}



} 
 

