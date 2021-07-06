// heading
//Victoria - vmiller77
//Brian - brianmueller
//Michele -learncs0

public class Fib {

  // PSEUDOCODE
  // Base case:
    // fib(0) ==> 0
    // fib(1) ==> 1
  // Recursive reduction:
    // fib(n) ==> fib(n-1) + fib(n-2)
    // Examples:
    // fib(2) ==> fib(2-1)+fib(2-2) = fib(1)+fib(0) = 1+0 = 1
    // fib(3) ==> fib(3-1)+fib(3-2) = fib(2)+fib(1) = 2+1 = 3
    // fib(10) ==> fib(9)+fib(8)
      // fib(9) ==> fib(8)+fib(7) = ...
      // fib(8) ==> fib(7)+fib(6) = ...

  //your implementation of fib(n) here
  // assume n >= 0 (no negative inputs)
  public static int fib(int n){
    // Base case:
      if(n == 0){ // fib(0) ==> 0
        return 0;
      }else if(n == 1){ // fib(1) ==> 1
        return 1;
      }else{ // fib(n) ==> fib(n-1) + fib(n-2)
        return fib(n-1) + fib(n-2);
      }
  }

  public static void main( String[] args ) {


    System.out.println( fib(0) ); // -> 0
    System.out.println( fib(1) ); // -> 1
    System.out.println( fib(2) ); // -> 1
    System.out.println( fib(3) ); // -> 2
    System.out.println( fib(4) ); // -> 3
    System.out.println( fib(5) ); // -> 5

    //now go big:
    System.out.println( fib(10) ); // -> 55
    System.out.println( fib(20) ); // -> 6765
    System.out.println( fib(40) ); // -> 102334155
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()

}//end class Fib
