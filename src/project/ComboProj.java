package project;


public class ComboProj {
	
	static double factorial(int x) {
		double result = 1;
		for (int i = 1; i <= x; i++) {
			result *= i;
		}
		return result;
	}
	
	static double choose(int n, int r) {
		return (factorial(n) / (factorial(r) * factorial(n - r)));
	}

	public static void main(String[] args) {

		System.out.println("This program will find the number of strategically different poker hands.\n");
		
		//Case 1: Pocket Pair (both of the player's cards are the same denomination)
		//Step 1: Choose a denomination for the pocket pair - we can do this in (13 choose 1) ways
		double step1 = choose(13, 1);
		
		
		//Step 2: Make both cards of the chosen denomination - we can do this in (1) way
		double step2 = 1;
		
		//Total outcomes = (13 choose 1) * (1) by Multiplication Principle
		double case1 = step1 * step2;
		
		
		//Case 2: Suited Cards (both of the player's cards are the same suit)	
		//Step 1: Choose the first card from any of the 13 denominations - we can do this (13 choose 1) ways
		//*Note: We do not choose the suit in the first step since suited cards of the same denomination
		//	play the same.
		step1 = choose(13, 1);
		
		//Step 2: Choose the second card from the remaining 12 denominations - we can do this (12 choose 1) ways
		step2 = choose(12, 1);
		
		
		//Total outcomes = (13 choose 1) * (12 choose 1) by the Multiplication Principle
		double case2 = step1 * step2;
		
		//Step 3: To eliminate hand repeats (like K-Q and Q-K), we must un-order the hand. To do this,
		//	we will divide the total arrangements by 2!.
		case2 = case2 / factorial(2);
		
		
		//Case 3: Unsuited Cards (both of the player's cards are different suits)	
		//Step 1: Choose the first card from any of the 13 denominations - we can do this (13 choose 1) ways
		//*Note: We do not choose the suit in the first step since unsuited cards of the same denomination
		//	play the same.
		step1 = choose(13, 1);
		
		//Step 2: Choose the second card from the remaining 12 denominations - we can do this (12 choose 1) ways
		step2 = choose(12, 1);
		
		
		//Total outcomes = (13 choose 1) * (12 choose 1) by the Multiplication Principle
		double case3 = step1 * step2;
		
		//Step 3: To eliminate hand repeats (like 8-7 and 7-8), we must un-order the hand. To do this,
		//	we will divide the total arrangements by 2!.
		case3 = case3 / factorial(2);		
		
		
		//Since all cases are disjoint, we can find the total number of strategically different
		//	poker starting hands by the Addition Principle
		double total = case1 + case2 + case3;
		
		System.out.println("The total number of strategically different poker hands is: " + (int)total);
		
	}

}
