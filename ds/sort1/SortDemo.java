import java.io.*;
import java.util.*;

/*

Setup:
 1.Make a folder under your work repo named: ds
 2. Make another folder under that named sort1
 3. Copy this file and SortDemoDriver.java into the ds/sort1 folder

Lab:

Part 1:
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
   the behavior of the constructors.

Part 2:
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortDemoDriver to test.

Part 3:
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortDemoDriver to test.

*/

public class SortDemo{

    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    private Random r;

    // creates new array list, r as a new random object
    // fills arraylist with random numbers between 0-19  20 numbers
    public SortDemo(){
      data = new ArrayList<Integer>();
      r = new Random();
      //only fills first 15 slots in the array
      for (int i=0;i<15;i++){
          data.add(r.nextInt(20));
      }// end of loop

      //if you wanted to delegate the tasks to the second constructor that takes a parameter
      // public SortDemo(){
      //   SortDemo(15);
      // }

    }// end of SortDemo()

    //2nd constructor- why do they have same 2 lines?
    // could rewrite to make 2nd call on first
    //
    public SortDemo(int size){
      data = new ArrayList<Integer>();
      r = new Random();
      for (int i=0;i<size;i++){
          data.add(r.nextInt(20));
	    }// end loop

    }// end of SortDemo(size)

    //returns the value at index in data arraylist
    public int get(int index){
      return data.get(index);
    }// end of get


    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
      6 which is the index with the smallest value from start to end

    */
    public int findSmallestIndex(int start){
      int smallIndex = start;
      int smallestValue = data.get(smallIndex);
      // start a variable at the one after start
      for (int i = start+1; i<data.size(); i++){ //loop through the arraylist starting at the index start
        if (data.get(i) < smallestValue){ //if the element at index i is smaller than the smallestValue
          smallIndex = i; //update the smallestIndex to be i where we find the smaller value
          smallestValue = data.get(i); //update the smallestValue to be the value at index i
        }
      }
      return smallIndex;
    }// end of findSmallestIndex

    public void sort(){
      int i;
 	    for (i=0;i < data.size()-1; i++){
 	    // find the smallest index from i to end
      int smallestIndex = findSmallestIndex(i);
 	    int valueAtSmallestIndex = data.get(smallestIndex);

 	    // swap the item at that index and i
 	    int temp = data.get(i);
      data.set(i, valueAtSmallestIndex);
      data.set(smallestIndex, temp);



 	    } //end of loop
    }//end of sort()



    /* If you finish the lab early you can get started on this */
    public int linearSearch(int value){
	// loop through the ArrayList data
	// and if the value you're searchign for is in the ArrayList, return it.
	// return -1 if it isn't there.


	return 0; // replace this return
    }

    /* If you finish the lab early you can get started on this */
    public int binarySearch(int value){
	boolean replacethiswithrealexpression=false;
	int lowerIndex = 0;
	int upperIndex = data.size();
	int middleIndex = data.size()/2;

	/* if upper crosses lower it's not there and the lop should exit the loop
	   and if the item is at middle you should exit the loop

           you have to replace the "replacethiswithrealexpression" boolean
           with a correct expression based on lowerIndex and upperIndex
	*/
	while (replacethiswithrealexpression)
	    {
		// update lower and upper.
		// remember if value is less than data.get(middleIndex) you want to search next time
		// from lower to the middle and otherwise from the middle to the upper.
		//
		// then update middleIndex based on new lowerIndex and upperIndex.

	    }

	/* replace this return to either return the value if it was found and -1
	   if upperIndex and lowerIndex crossed
	*/

	return 0; // replace this return
    }


    public String toString(){
	return ""+data;
    };

}
