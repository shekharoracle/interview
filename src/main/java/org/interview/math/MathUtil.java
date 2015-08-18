package org.interview.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


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
 * 4. Sub Set : 
 * 5. Factorial Trailing Zeros : Number of zeros in n!?
 * 6. Is Happy Number : repeated sum of digit is 1.
 * 
 * TODO : 
 * 1. Write a programme to put () around repeated decimal number example : 5/7 = 0.(*****)
 * 2. Plus One : to list of digits.
 * 
 *
 */

public class MathUtil {
	
	
	public boolean isHappy(int n) throws InterruptedException{
		
		HashSet<Integer> numberList = new HashSet<Integer>();
		
		while(!numberList.contains(n)){
			numberList.add(n);
			n = sumOfDigit(n);
			System.out.println(""+n);
			if(n == 1)return true;
			Thread.sleep(2000);
		}
		return false;
	}
/**
 * 
 * @param n
 * @return
 */
	private int sumOfDigit(int n) {
		int sum = 0;
		while(n != 0){
			int mod = n % 10;
			sum = sum + (int)pow(mod, 2);
			n = n /10;
		}
		return sum;
	}

	public int numberOfZeros(int n){
		if(n < 5)return 0;
		
		int count = 0;
		
		for(int i = 5; n/i >= 1 ; i*=5){
			count += n/i;
		}
		return count;
	}
	public void SubSet(int[] S){
		
		
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i < S.length ; i++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> a : result){
				temp.add(new ArrayList<Integer>(a));
			}
			System.out.println("1 "+temp);
			
			for(ArrayList<Integer> a : temp){
				a.add(S[i]);
			}
			
			System.out.println("2 "+temp);
			
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
			
			System.out.println("3 "+temp);
			result.addAll(temp);
			
			System.out.println("======");
		}
		
		System.out.println("Result : "+result);
	}
	
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
		
		int[] arr = {1, 2, 3};
		mathUtil.SubSet(arr);
		
		System.out.println("# of trailing zero : "+mathUtil.numberOfZeros(26));
		
		
		try {
			System.out.println("is Happy # : "+mathUtil.isHappy(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/**
 * Temp Code for Fractional decimal point : 
 * int num = 5;
		int den = 7;
		
		long res = num/den;
		long rem = (num % den)*10;
		String result = String.valueOf(res);
		result = result + ".";
		System.out.println(""+res);
		System.out.println(""+rem);
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		while(rem != 0){
			System.out.println("Reminder : "+rem);
			
			if(map.containsKey(rem)){
				int beg = map.get(rem);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 +")";
				System.out.println(""+result);
				break;
			}
			map.put(rem, result.length());
			res = rem /den;
			result += String.valueOf(res);
			rem = (rem % den) * 10;
		}
 * 
 */

