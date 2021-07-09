/**
   lab -- Day 7 | 0b111 | 0x7

   class: Foogle

   A mystery class for code analysis and search exploration.

   USAGE:
   As a team, read through at least once. Dialogue.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   (get handy with your editor's find/replace shortcuts...)
   Insert comment preceding each method to summarize functionality.

   T. Mykolyk, F. Dragon
   June 2021
**/

import java.io.*;
import java.util.*;

public class Foogle
{

  //iterates through array ArrayList
  //compares each item in the arrayList to the target
  //when the item found equals the target, return the index of the first found item
  public static int foo( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end foo()


  //fills an arrayList with random numbers between low and high parameters
  //fill it numItems amount of times
  //returns the arraylist
  public static ArrayList gizmo(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,hi)
    }
    return retArr;
  }//end gizmo()


  // creates an arraylist and each element is a number between [lo,hi) more than the previous one
  public static ArrayList wooHa(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    //return empty arrayList if the numItems is 0 or negative
    if ( numItems<1 )
      return retArr;

    //adds a random number between 0 and lo
    retArr.add(
               (int)(lo * Math.random())
               );

    //fills the arrayList, each element is the prior one plus a random int between lo and hi
    //if the lo:0 and hi:5 then each element will be a number between 0-5 more than the prior one
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,hi)
      //System.out.println(retArr.get(i-1));  //diag.
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) );
    }

    return retArr;
  }//end wooHa()


  public static void main( String[] args )
  {
    // test battery for gizmo()
/*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = gizmo(0,0,0);
    System.out.println(al000);
    System.out.println(foo(al000,3));

    System.out.println("\n"+"al01"+":");
    ArrayList al01 = gizmo(5,0,100);
    System.out.println(al01);
    System.out.println(foo(al01,3));

    System.out.println("\n"+"al02"+":");
    ArrayList al02 = gizmo(5,3,10);
    System.out.println(al02);
    System.out.println(foo(al02,3));

    System.out.println("\n"+"al05"+":");
    ArrayList al05 = gizmo(20,1,5);
    System.out.println(al05);
    System.out.println(foo(al05,3));

      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


    // test battery for wooHa()
/*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = wooHa(0,0,0);
    System.out.println(sal000);
    System.out.println(foo(sal000,3));

    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = wooHa(5,0,100);
    System.out.println(sal00);
    System.out.println(foo(sal00,3));

    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = wooHa(5,0,100);
    System.out.println(sal01);
    System.out.println(foo(sal01,3));

    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = wooHa(5,3,100);
    System.out.println(sal02);
    System.out.println(foo(sal02,3));

    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = wooHa(5,0,100);
    System.out.println(sal03);
    System.out.println(foo(sal03,3));

    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = wooHa(20,0,3);
    System.out.println(sal04);
    System.out.println(foo(sal04,3));

    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = wooHa(20,1,5);
    System.out.println(sal05);
    System.out.println(foo(sal05,3));

      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = gizmo(,0,100);
    System.out.println(al);

    */
  }//end main

}//end class
