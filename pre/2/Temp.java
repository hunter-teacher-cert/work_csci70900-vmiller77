import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args){
        
		Scanner in = new Scanner(System.in);
		
		//prompt user for input
		System.out.println("Give me a temperature in Celcius to covert to Fahrenheit!");
		
		//read double value from keyboard
		double c = in.nextDouble();
		
		//calc result
		double f = (c*(9.0/5.0)+32);
		
		//format output to one decimal place
		String formatTemp = String.format("%.1f C = %.1f F", c, f);
		
		System.out.println(formatTemp);
		
    }
}