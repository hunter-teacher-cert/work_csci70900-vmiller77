//authors: Victoria and Peter
import java.io.*;
import java.util.*;

public class Pair{
    public static void barGraphify(int[] nums){
        for(int i = 0; i < nums.length; i++){
          System.out.print(i + ": ");
          for(int j = 0; j < nums[i]; j++){
            System.out.print("=");
          }
          System.out.println("");
        }
    }

    public static void vertBarGraphify(int[] nums){
      int m = max(nums);
      char[][] graph = new char[m+1][nums.length];

      for (int i = 0; i < graph[0].length; i++) {
        char c = (char)i;
        graph[m][i] = c;
        //graph[m][i] = '*';
      }
      System.out.println(toString(graph));

    }

    public static void vertBarGraphify2(int[] nums){
      int m = max(nums);
      String[] graph = new String[m+1];

      //build graph upside down
      for(int i = 0; i < graph.length; i ++){
          graph[i] = ""; //Replace null with empty string

          if(i == 0){//index row
            for(int j = 0; j < nums.length; j++){
              graph[i] = graph[i] + j + " ";
            }
          }else{ //bar chart star representation
            for(int j = 0; j < nums.length; j++){
              if(i<=nums[j]){//index is less than the value at nums- can have star
                graph[i] = graph[i] + "* "; //put star to represent
              }else{
                graph[i] = graph[i] + "  "; //put space because empty
              }
            }
          }


      }

      printVertGraph(graph);
    }

    public static void printVertGraph(String[] graph){
      //prints the bar graph upside down
      for(int i = graph.length - 1; i >=0; i--){
        System.out.println(graph[i]);
      }
    }

    public static int max(int[] nums){
      int m = nums[0];
      for (int i = 0; i < nums.length; i++){
        if (nums[i] > m){
          m = nums[i];
        }
      }
      return m;
    }

    public static String toString(char[][] board){
    	int row,col;
      int rows = board.length;
      int cols = board[0].length;

      System.out.println("rows: "+rows);
      System.out.println("cols: "+cols);

    	String result = "";
    	for (row = 0; row < rows; row++){
    	    for (col = 0; col < cols; col++){
        		result = result + board[row][col];
    	    }
    	    result = result +"\n";
    	}
    	return result;
    }



    public static void main(String[] args) {
      int[] test = new int[]{1,2,3,4,5};
      int[] test1 = new int[]{4,2,3,1,2};

      barGraphify(test);
      barGraphify(test1);
      vertBarGraphify2(test);

    }


}
