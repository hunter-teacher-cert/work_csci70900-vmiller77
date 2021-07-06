//Victoria - vmiller77
//Brian - brianmueller
//Michele -learncs0


// instantiate a newly-created Time object with specified value(s)
// assign a Time var the value null
// assign a Time var the value of an existing Time var
// print all of the above (See multiple ways to do this? Try all -- and document in comments!)
// test for equality of each of the Time instances above. Print results.
// add two Time objects and print results
// add two Time objects and save the result in another Time object

import java.io.*;
import java.util.*;

public class Driver {

  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    //time is the object that has not been made yet; I will point to a time object
    Time t; //lower case t small box

    //assign var the address of a newly-apportioned Time object
    t = new Time(); //big box; new makes the big box (new instance of type time); make an object of type time with hour 0 and minute 0 because default constructor sets it to 0

    Time t1 = new Time(0,33); //value constructor to make hour 0 and minute 33
    Time t2 = new Time(); //hour = 0, minute = 0; use default constructor to make hour and minute zero

    // get
    System.out.println("t1  hour: " + t1.getHour()); //gets hour of object t1
    System.out.println("t1  min: " + t1.getMinute()); //gets minute of objcet 1
    System.out.println("t2  hour: " + t2.getHour()); //gets hour of t2
    System.out.println("t2  min: " + t2.getMinute()); //gets minute of t2

    // set
    System.out.println("Change t1 minute to 25");
    t1.setMinute(25);

    // get
    System.out.println("t1  new min: " + t1.getMinute());

    // toString
    System.out.println("t1 " + t1.toString()); //t1 The time is: 8:25

    // check for equality;
    System.out.println("Does t equal t2? " + t.equals(t2));
    System.out.println("Does t1 equal t2? " + t1.equals(t2));

    Time t3 = new Time(-5,33);
    t3.setHour(-5);
    System.out.println("t3  hour: " + t3.getHour());


  }//end main()

}//end class
