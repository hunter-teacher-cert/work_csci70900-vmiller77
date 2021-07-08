/**
   lab skeleton
   encapsulation / SuperArray

   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
  //instance vars
  private int[] data;           //where the actual data is stored
  private int numberElements;   //number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size )
  {
    data = new int[size];
    numberElements = 0;
  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    data = new int[10];
    numberElements = 0;
  }


  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void add( int value ){
    // test to see if we need to grow, then grow
    // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER
    if(numberElements < data.length){ //still room to add more elements
      // add item
      data[numberElements] = value;

      // increment numberElements
      numberElements = numberElements + 1;

    }else{//not enough room have to grow
      grow(); //data array should be bigger by 1
      data[numberElements] = value; //storing the new value into the growth space created
      numberElements = numberElements + 1; //incrementing numberElements since we added another item to the list
    }



  }//end add()

//add value to data[index]
public void add(int index, int value){
  // 1,44,5,6
  // 1,44,5,6,_ //grow
  // 1,100,44,5,6

  //create temporary array to hold items after index
  int[] temp = new int[data.length - index];

  //copy over array
  for(int i = 0; i < temp.length; i++){
    temp[i] = data[i+index];
  }

  //grow the data array by size 1
  grow();

  //insert the value at index
  data[index] = value;

  //copy over the elements after index
  for(int i = 0; i < temp.length; i++){
    //System.out.println("Placing temp["+i+"] into data["+(i+index+1)+"]");
    data[i+index+1] = temp[i];
  }

  numberElements = numberElements + 1;
}

  //removes the value at the index
public void remove(int index){
  if(index < numberElements){
    //have a for loop that starts at the index provided, # of elements -1
    for(int i = index; i<numberElements-1; i++)
    {
      data[i]=data[i+1];
    }
    //decrease # of numberElements
    numberElements--;

  }else{
    System.out.println("Out of bounds, cannot remove.");
  }
  }

  //checks to see if SuperArray empty
  public boolean isEmpty()
  {
    if(numberElements == 0){
      return true;
    }else{
      return false;
    }
  }

  public int get(int index)
  {
    return data[index];
  }


  public String toString()
  {
    //create an empty String
    String allItems = "";
    //for loop all elements of the arrays
    for(int i=0; i < numberElements; i++){
        //concatenate each array element to the string
        allItems = allItems + data[i] + ",";
    }
     return allItems;
  }//end toString()


  //helper method for debugging/development phase
  public String debug()
  {
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  private void grow() //grow data by size of 1
  {
    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?
    int[] biggerArray = new int[numberElements + 1];

    // copy over all the elements from the old array to the new one
    //copy over the old array into the new arrays
    for(int i =0; i<numberElements; i++)
    {
      biggerArray[i] = data[i];
    }

    // point data to the new array
    data = biggerArray;

  }//end grow()

}//end class
