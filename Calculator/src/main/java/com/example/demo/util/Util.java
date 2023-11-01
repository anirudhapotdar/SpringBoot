/**
 * 
 */
package com.example.demo.util;

/**
 * 
 */
public class Util {
	
	public static String getFormattedString(double ans)
	{
		return ans == (int) ans ? String.valueOf((int) ans) : String.valueOf(ans);
	}

}
