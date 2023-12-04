/**
 * 
 */
package com.algorithm.util;

import java.util.Arrays;

/**
 * 
 */
public class Util {

	public static int[] getEvenSubset(int numbers[])
	{
		return Arrays.stream(numbers).filter(number -> number %2 ==0).distinct().toArray();
		
	}
	
	public static int getReactanglearea(int length,int bredth)
	{
		return length*bredth;
	}
	public static int[] getSwap(int number1,int number2)
	{
		number1=number1+number2;
		number2=number1-number2;
		number1=number1-number2;
		int result[]= {number1,number2};
		return result;
	}


}
