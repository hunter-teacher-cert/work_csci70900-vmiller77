/**
authors:

vmiller77, skabanakis, mlaks23

skeleton file for
 class twoDimArray
  ...practice working with 2D arrays
*/

public class TwoDimArray
{

  //print each row of 2D integer array a on its own line,
  // using a FOR loop
  public static void print1( int[][] a ) {
   for(int row = 0; row < a.length; row++){ //changed i to row
     for(int col = 0; col < a[row].length; col++){ //changes j to col
       System.out.print(a[row][col]); //print out each element
     }
     System.out.println(""); //print a line for spacing
   }
  }


  //print each row of 2D integer array a on its own line,
  // using a FOREACH loop
  public static void print2( int[][] a ) {
    for(int[] row: a){  //going through each row
      for(int element: row){ //going through each element in a row
        System.out.print(element);
      }
      System.out.println("");
    }
  }


  //return sum of all items in 2D integer array a
  public static int sum1( int[][] a ) {
    int total =0;
	  int value =0;
    for(int row =0; row<a.length; row++)
    {
      for(int col =0; col<a[row].length;col++)
      {
        value =a[row][col];
        total= total +value; //adding each element to our total
      }
    }
    return total;
  }

  //return sum of all items in 2D integer array a
  // using helper fxn sumRow
  public static int sum2( int [][] m ) {
    //loop through each row and take the sumRow
    //then add the sumRows together
    int total = 0;
    for(int row = 0; row < m.length; row ++){
      total = total + sumRow(row, m);
    }
    return total;
  }

  //return sum of all items on row r of 2D integer array a
  // using a FOR loop
  public static int sumRow( int r, int[][] a ) {
    int sumRowTotal= 0;
      for(int col=0; col<a[r].length; col++){
        sumRowTotal = sumRowTotal + a[r][col];
      }
  return sumRowTotal;
  }


  //return sum of all items on row r of 2D integer array a
  // using a FOREACH loop
  public static int sumRow2( int r, int[][] m ) {
    int sumRowTotal = 0;
    for (int[] row: m){
      for(int element: row){
        sumRowTotal = sumRowTotal + element;
      }
    }
    return sumRowTotal;
  }


  public static void main( String [] args )
  {

       int [][] m1 = new int[4][2];
       int [][] m2 = { {2,4,6}, {3,5,7} };
       int [][] m3 = { {2}, {4,6}, {1,3,5} };

       System.out.println("Print1 Array m1");
       print1(m1);
       System.out.println("Print 1 Array m2");
       print1(m2);
       System.out.println("Printing m3");
       print1(m3);

       System.out.println("Print2 Array m1");
       print2(m1);
       System.out.println("Print2 Array m2");
       print2(m2);
       System.out.println("Print2 Array m3");
       print2(m3);


       System.out.print("testing sum1...\n");
       System.out.println("sum m1 : " + sum1(m1));
       System.out.println("sum m2 : " + sum1(m2));
       System.out.println("sum m3 : " + sum1(m3));

       System.out.print("testing sum2...\n");
       System.out.println("sum m1 : " + sum2(m1));
       System.out.println("sum m2 : " + sum2(m2));
       System.out.println("sum m3 : " + sum2(m3));
  }//end main()

}//end class TwoDimArray
