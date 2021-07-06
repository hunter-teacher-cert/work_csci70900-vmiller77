//Victoria - vmiller77
//Brian - brianmueller
//Michele -learncs0

// tell a Time object how to do the tasks necessary to achieve the above

import java.io.*;
import java.util.*;

public class Time {

  // parameters are inputs when defining a method or constructor
  // arguments are inputs when calling a method or instantiating a new object

  // your implementation of class Time here
  //instance variables
  private int hour; // 0-23
  private int minute; // 0-59

  // default constructor
  public Time(){
    this.hour = 0;
    this.minute = 0;
  }

  // value constructor
  public Time(int _hour, int _minute){
    this.setHour(_hour);
    this.minute =_minute;
  }

  // another constructor that works
  // public Time(int _hour, int _minute){
  //   hour = _hour;
  //   minute =_minute;
  // }

  // another constructor that works
  // public Time(int hour, int minute){
  //   this.hour = hour;
  //   this.minute = minute;
  // }

  // this constructor wouldn't work because the computer doesn't know the difference between the parameter and the instance variable
  // public Time(int hour, int minute){
  //   hour = hour;
  //   minute = minute;
  // }

  // equality operator (==) versus .equals() method
  // String name1 = new String("Brian");
  // String name2 = new String("Brian");
  // name1 == name2; // false -do these two things point to the same location in memory
  // name1.equals(name2); // true since they hold the same values in their instance variables

  //equals method to see if objects are equal (in the same location)
  //want to override default equals method to compare hour and minute instead
  public boolean equals(Time otherTime){ //function that returns boolean and returns time object
    //are the values of the two pairs of instance variables the same number
    // ex: t1.equals(t2) ==> this represents t1, otherTime represents t2
    boolean hourSame = this.hour == otherTime.getHour(); //checks to see if the hours are the same
    boolean minuteSame = this.minute == otherTime.getMinute(); //checks to see if the minutes are the same
    if(hourSame && minuteSame){ // BOTH must be the same
      return true;
    }else{
      return false;
    }

  }

  //setters (mutator/writer)
  public void setHour(int newHour){
    if(newHour < 0){ //makes sure user does not enter invalid entry
      this.hour = 0;
    }else if (newHour > 23){
      this.hour = 23;
    }else{
      this.hour = newHour;
    }


  }

  public void setMinute(int newMinute){
    this.minute = newMinute;
  }

  //getters (accessor/reader); integer needs to be proper type from line 17
  public int getHour(){
    return this.hour;
  }

  //getter for minute
  public int getMinute() {
    return this.minute;
  }

  //toString method
  public String toString(){
    return "The time is: " + this.hour + ":" + this.minute; //t1 The time is: 8:25
  }

}//end class
