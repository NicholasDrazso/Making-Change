//Name: Nicholas Drazso
//Date: May 15, 2019
//Program Description: This program will use Shallit's coin system and dynamic programming to offer an optimal solution for the amount of coins needed for n change
public class changeMaking {
	

	//Method returns minimum number of coins required to make change for given amount
	public static int makeChange (int cents) {
	
		//Creates array for all amounts
		int[] OPT = new int [cents + 1];
		
		//No coins necessary for 0 cents
		OPT[0] = 0;
		
		//Loops through all amounts up until the required amount
		for (int i = 1; i <= cents; i++) {
			
			//While only pennies can be used 
			if (i < 5) {
				OPT[i] = 1 + OPT[i - 1];
			}
			
			//While only pennies and nickels can be used
			else if (i < 18) {
				OPT[i] = Math.min(1 + OPT[i - 1], 1 + OPT[i - 5]);
			}
			
			//While only pennies, nickels, and 18 cent coins can be used
			else if (i < 25) {
				OPT[i] = min3(1 + OPT[i - 1], 1 + OPT[i - 5], 1 + OPT[i - 18]);
			}
			
			//Finds optimal solution for cents >= 25
			else {
				OPT[i] = min4(1 + OPT[i - 1], 1 + OPT[i - 5], 1 + OPT[i - 18], 1 + OPT[i - 25]);
			}
		}
		
		//Returns end position in array because thats where the answer will be
		return OPT[cents];
	}
	
	//Method for finding minimum of three numbers
	public static int min3(int a, int b, int c) {
		int min = Math.min(a, b);
		return Math.min(min, c);
	}

	//Method for finding minimum of four numbers
	public static int min4(int a, int b, int c, int d) {
		int min = Math.min(a, b);
		int min2 = Math.min(c, d);
		return Math.min(min, min2);
	}
}
