import java.io.*;
import java.util.*;

public class Date {
    public static void main(String[] args){
		String day = "Monday";
		int date = 31;
		String month = "May";
		int year = 2021;
		
        System.out.println("The day is: " + day);
		System.out.println("The month is: " + month);
		System.out.println("The date is: " + date);
		System.out.println("The year is: " + year);

		//american format
		System.out.println("American format:");
		String americanFormat = String.format("%s, %s %d, %d", day, month, date, year);
		System.out.println(americanFormat);
		
		//european format
		System.out.println("European format:");
		String euroFormat = String.format("%s %d %s %d", day, date, month, year);
		System.out.println(euroFormat);
    }
	
}