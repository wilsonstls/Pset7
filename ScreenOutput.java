package pset7.util; 
 
import pset7.AppOutput; 
import org.springframework.stereotype.Service; 
 
 
/** 
  * User: wilsonstls
  * Date: 6/3/15
  * Time: 2:04 AM 
  */ 
 
 
@Service 
public class ScreenOutput implements AppOutput{ 
     @Override 
     public void print(String output) { 
         System.out.println(output); 
     } 
} 
