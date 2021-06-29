import java.io.*;
import java.util.*;

public class Time {
	final static int TOTAL_SECONDS_IN_DAY = 86400;
	
	public static int calcSecondsSinceMidnight(int hour, int minute, int second){
		int totalSeconds = second;
		
		//convert minutes to seconds and add
		totalSeconds += (minute*60);
		
		//convert hours to seconds and add
		totalSeconds+= (hour*3600);
		
		return totalSeconds;
	}
	
	public static int secondsRemainingInDay(int hour, int minute, int second){
		//find difference between seconds in the day and seconds that have occurred
		int remainingSeconds = TOTAL_SECONDS_IN_DAY - calcSecondsSinceMidnight(hour, minute, second);
		
		return remainingSeconds;
	}
	
	public static float percentageOfDayPassed(int hour, int minute, int second){
		float secondsPassed = calcSecondsSinceMidnight(hour,minute,second);
		float totalSeconds = TOTAL_SECONDS_IN_DAY;
		
		return (secondsPassed/totalSeconds)*100;
	}
	
    public static void main(String[] args){
		int hour = 23;
		int minute = 4;
		int second = 2;
		
		System.out.println("The number of seconds since midnight is: " + calcSecondsSinceMidnight(hour, minute, second));
		System.out.println("The number of seconds left in the day are: " + secondsRemainingInDay(hour,minute,second));
		System.out.println("Percentage of the day that has passed is : " + percentageOfDayPassed(hour,minute,second));
		
		int startTime = calcSecondsSinceMidnight(hour,minute,second);
		
		minute = 15;
		second = 34;
		
		int timeElapsed = calcSecondsSinceMidnight(hour,minute,second) - startTime;
		System.out.println("Time elpased since started working: " + timeElapsed);
    }
	
	
}