import java.io.*;
import java.util.*;

public class Maze{

    private char[][] board;
    private int rows = 25;
    private int cols = 85;

    private String clearScreen="[0;0H\n";

    private void delay(int n)
    {
	try
	    {Thread.sleep(n);}
	catch(InterruptedException e)
	    {}
    }

    public Maze(String filename){
	try{
	    board = new char[cols][rows];
	    int row = 0;
	    int col = 0;

	    for (row = 0; row < rows; row++){
		for (col = 0; col < cols ; col++){
		    board[col][row] = ' ';
		}
	    }


	    File file = new File(filename);
	    FileReader reader = new FileReader(file);
	    BufferedReader breader = new BufferedReader(reader);

	    String line;
	    row = 0;
	    while( (line=breader.readLine()) != null )  {
		for (col = 0; col < line.length()-1 ; col++){
		    board[col][row] = line.charAt(col);
		}
		row++;
	    }

	} catch (IOException e){
	    e.printStackTrace();
	}


    }

    public String toString(){
	int row,col;
	String result = "";
	for (row = 0; row < rows; row++){
	    for (col = 0; col < cols; col++){
		result = result + board[col][row];
	    }
	    result = result +"\n";
	}
	return result;
    }

    public boolean solve(int col,int row){

      if(board[col][row] == '$'){
        return true;
      }
      //base cases
      if(board[col][row] == ' '
        || board[col][row] == 'z'
        || board[col][row] == '.'){
          return false;
        }

      //put ourselves in the maze
      board[col][row] = 'z';

      //Recursive calls
      boolean solved = solve(col+1,row); //checks the one below
      if(!solved){
        solved = solve(col-1, row); //checks the one above
      }
      if(!solved){
        solved = solve(col, row+1); //checks the one to the right
      }
      if(!solved){
        solved = solve(col, row-1); //checks the one to the left
      }

      //since we are not done yet remove ourselves
      board[col][row] = '.';
	    return solved;
    }




}
