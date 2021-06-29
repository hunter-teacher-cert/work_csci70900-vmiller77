import java.io.*;
import java.util.*;
public class Nim{
	
	public static void main (String[] args) {
		
		int stones = 12;
		int stonesTaken;
		
		Scanner in = new Scanner(System.in);
		
		//loop while game is running
			while (stones >= 0) {
				//ask user how many stones, limiting user input to valid turns
				do {
					System.out.print("How many stones do you want to take? Take 1, 2, or 3: ");
					stonesTaken = in.nextInt();
					
					//if user tries to take too few or too many stones
					if (stonesTaken != 1 && stonesTaken != 2 && stonesTaken != 3) {
						System.out.println("Invalid turn. Try again.");
					}
					
					//if user tries to take more stones than are in the bag
					if(stones - stonesTaken < 0) {
						System.out.println("You cannot take that many stones. Try again.");
						stonesTaken = 0;
					}
				} while(stonesTaken != 1 && stonesTaken != 2 && stonesTaken != 3);
				
				
				//calculate number of stones left and tell user
				stones = stones - stonesTaken;
				System.out.println("There are " + stones + " stones left.");
				
				//you win if stones is 0 at this point
				if(stones == 0) {
					System.out.println("You won!");
					break;
				}
				
				// computer's turn to pick a random number of stones, but only if there are that many stones left
				do {
				Random random = new Random();
				stonesTaken = random.nextInt(2) + 1;
				} while(stones - stonesTaken < 0);
				
				//calculate number of stones left and tell user
				stones = stones - stonesTaken;
				System.out.println("The computer took " + stonesTaken + " stones.");
				System.out.println("There are " + stones + " stones left.");
				
				//computer wins if stones is 0 at this point
				if(stones == 0) {
					System.out.println("The computer won. Better luck next time.");
					break;
				}
				
			}
				
		
	}
	
	
}