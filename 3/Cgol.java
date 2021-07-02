import java.io.*;
import java.util.*;


/**
authors- Mlaks23, Skabanakis,Vmiller77,

   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/
//group of 3 or 4 will live, anything more or less will die.
public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
      char[][] board = new char [rows][cols];
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col ++) {
          setCell(board,row,col,'.');
        }
    }
      return board;
  }


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[0].length; col ++) {
		    System.out.print(board[row][col] + " ");
      }
      System.out.println("");
    }
  }


  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;

  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
    int livingNeighbors = 0;

    if(isAlive(board,r-1,c-1)){
      livingNeighbors++;
    }
    if(isAlive(board,r-1,c)){
      livingNeighbors++;
    }
    if(isAlive(board,r-1,c+1)){
      livingNeighbors++;
    }
    if(isAlive(board,r,c-1)){
      livingNeighbors++;
    }
    if(isAlive(board,r,c+1)){
      livingNeighbors++;
    }
    if(isAlive(board,r+1,c-1)){
      livingNeighbors++;
    }
    if(isAlive(board,r+1,c)){
      livingNeighbors++;
    }
    if(isAlive(board,r+1,c+1)){
      livingNeighbors++;
    }
    //System.out.println("["+r+"]" +"["+c+"]" + "=" + livingNeighbors);
    return livingNeighbors;
  }

  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'L', dead '.')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
    int numNeighbours = countNeighbours(board, r, c);

    if(isAlive(board,r,c)){

      if(numNeighbours == 3 || numNeighbours == 2){
        return 'L'; //survival
      }else{
        return '.'; //death
      }

    }else{ //if cell starts out dead
      if(numNeighbours == 3){ //enough neighbors to birth
        return 'L';
      }else{
        return '.';
      }
    }
  }

public static char[][] copyBoard (char[][] oldBoard){

  char[][] newBoard = new char[oldBoard.length][oldBoard[0].length];
    for (int i = 0; i < newBoard.length  ; i ++) {
      for (int j = 0; j < newBoard[0].length; j++){
        newBoard[i][j] = oldBoard[i][j]; //stores the old board cells in the new board at the same place
      }
    }
    return newBoard;
}
//tells us if the cell is alive
public static boolean isAlive(char[][] board, int r, int c){
    //check to see if cell exists based on r and c
    if(r > board.length - 1 || c > board[0].length -1 || r < 0 || c < 0){
        return false;
      }else{ //cell exists - check if living
        if(board[r][c] == 'L'){
          return true;
        }else{
          return false;
        }
      }
  }

  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    //copy board to change
    char[][] newBoard = copyBoard(board);

    //go through the old board to change the new board
    for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col ++) {
          //get the nextGenCell for this cell at row,col
           char nextGenCellChar = getNextGenCell(board, row, col);

           //setting the cell of the new board
           setCell(newBoard,row,col,nextGenCellChar);
        }
    }
    return newBoard;

  }

  public static boolean isGameOver(char[][] board){
      //when everything is dead then game over
      int numAlive = 0;
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col ++) {
          if(isAlive(board,row,col)){ //if we find any cell that is alive, the game is not over
            return false;
          }
        }
      }
    return true; //if we went through all cells and none are alive then game is over
  }

  public static void main( String[] args ) {
    Scanner in = new Scanner(System.in);
    System.out.print("Welcome to the Game of Life! How long would you like your board? "); //use the variable twice for a square grid
    int size = in.nextInt();

    //board before the positions are in play
    char[][] board;
    board = createNewBoard(size,size);

    //prompt hpw many cell inputs user would like
    System.out.print("How many living cells would you like to start with? ");
    int live = in.nextInt();

    //This needs to repeat for number of cells
    for(int i = 0; i < live; i++){
      System.out.println("Where would you like to put the living cell? Choose a row and a column. "); //use x for row and y for column for now
      System.out.print("row: ");
      int x = in.nextInt();
      System.out.print("column: ");
      int y = in.nextInt();
      setCell(board, x, y, 'L');
    }



    System.out.print("How many rounds would you like to play? ");
    int rounds = in.nextInt();


    //breathe life into some cells:
    //setCell(board, 0, 0, 'L');
    //setCell(board, 0, 1, 'L');
    //setCell(board, 1, 0, 'L');
    //setCell(board, x, y, 'L');


    printBoard(board);


    int i = 0;
    while(i < rounds){
      board = generateNextBoard(board);
      System.out.println("Generation: " + (i+1));
      printBoard(board);
      if(isGameOver(board)){
        System.out.println("Your populations all died. GAME OVER.");
        break;
      }
      i++;
    }


  //check to see the amount of live neighbors based on the coordinates. This is a check
   /** for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col ++) {
          countNeighbours(board, row, col);

        }
    }**/



    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
