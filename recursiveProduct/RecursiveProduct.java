package recursiveProduct;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveProduct {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numberArray = new int[5];//variable to assign empty array to a value of 5
		
		System.out.println("enter 5 numbers to be multiplied by each other");
		for(int i = 0; i < numberArray.length; i++) {//loop runs 5 times to collect info for all slots [0,1,2,3,4]
			numberArray[i] = scan.nextInt(); 
		}
		int result = recursiveTest(numberArray, 0);// calls the recursive method starting at index 0, stores the final product in result
		System.out.println("Numbers entered: " + Arrays.toString(numberArray));//shows stored numbers provided by user
		System.out.println(result);
	}
	
	public static int recursiveTest(int numberArray[], int x){
		if(x == 4) {//base case. stopping point at index 4. 
			System.out.println(numberArray.length+ " Numbers have been stored");//confirms all 5 numbers were stored
			return numberArray[4];// returns the last element; this value unwinds back through the call stack
		}
		return numberArray[x] * recursiveTest(numberArray, x + 1); // RECURSIVE CASE: multiply current element by the product of all elements after it
		}
		
	}

	


