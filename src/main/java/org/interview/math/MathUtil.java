package org.interview.math;

import java.util.ArrayList;


/**
 * 
 * @author shekharagrawal
 * Questions
 * 1. Check if a number is divisible by 7 without mod operator
 * 2. Function to multiple a number by 7 (Bit Wise Operator) [(n<<3)-n]//
 * 3. Function to check if a number is Power of Two 
 * 4. Multiply Two Integer without using *
 * 5. Check if given number is multiple of 3 or not in efficient manner : Bit wise operation 
 * count of event place bit - count of odd place bit if multiple of 3 then # too otherwise not.
 * http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
 * 
 * Programme Creek
 * 1. Reverse Integer
 * 2. Palindrome Number (Reverse and compare)
 * 3. Pow(x, y)
 *
 */

public class MathUtil {
	
	
	public double pow(int x, int y){
		if(y == 0)return 1;
		if(y < 0){
			return 1/(x * pow(x, (-y)-1));
		}else{
			return x * pow(x, y-1);
		}
	}
	
	
	
	public int reverseInteger(int x){
		int result = 0;
		while(x != 0){
			int mod = x % 10;
			result = result * 10 + mod;
			x = x/10;
		}
		return result;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public int multiply(int x, int y){
		if(y == -1)return -1;
		if(y == 0)return 0;
		return x + multiply(x, y-1);
	}
	/**
	 * Check if number is divisible by 7 without mod operator
	 * @param num : Number to be checked
	 * @param x : in this case 7
	 * Using divisibility rule i.e. double the last digit and subtract it from the rest of the number 
	 * and the answer is 0 or divisible by 7
	 */
	public void isDivisible(int num, int x){
		if(num < 0){
			isDivisible(-num, x);
		}
		if(num == 0 || num == 7){
			System.out.println("Divisible by 7!");
			return;
		}
		if(num < 10){
			System.out.println("Not divisible by 7!");
			return;
		}
		isDivisible((num/10-2*(num - num/10*10)), x);
	}
	
	
	/**
	 * To generate Prime number till n, we have to check if # is divided by any previous prime number or not. If yes then it is not prime otherwise it is.
	 * @param n
	 */
	public void generateAllPrimeNumber(int n){
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		primeList.add(1);
		primeList.add(2);
		for(int i=3; i<= n; i++){
			if(i%2 == 0)continue;
			if(isPrime(i, primeList))System.out.print(" "+i);
		}
		System.out.println("");
	}
	
	/**
	 * Check power of 2 using Bit wise operator 
	 * @param x
	 * @return
	 */
	public boolean isPowerOfTwo(int x){
		return x != 0 && (x & x-1) == 0;
	}
	
/**
 * 	
 * @param i
 * @param primeList
 * @return
 */
	private boolean isPrime(int i, ArrayList<Integer> primeList) {
		for(Integer prime : primeList){
			if(prime == 1)continue;
			if(i % prime == 0)return false;
		}
		primeList.add(i);
		return true;
	}
	
	public int multiplyBy7(int n){
		return ((n << 3) - n);
	}


	public static void main(String[] args) {
		MathUtil mathUtil = new MathUtil();
		mathUtil.isDivisible(7371, 7);
		mathUtil.generateAllPrimeNumber(50);
		System.out.println(""+mathUtil.isPowerOfTwo(64));
		System.out.println("Multply By 7 : "+mathUtil.multiplyBy7(7));
		
		System.out.println(mathUtil.multiply(2, 3));
		
		System.out.println("Revese Integer "+mathUtil.reverseInteger(1234));
		
		System.out.println("Power of 2 : "+mathUtil.pow(2, -2));
		
	}

}
