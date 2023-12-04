/**
 * 
 */
package com.algorithm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.algorithm.request.AlgorithmRequest;

/**
 * 
 */
public interface AlgorithmService {

	boolean isPrime(int number);

	boolean isPalindrome(int number);

	int getFactorial(int number);

	int getNthFiboNumber(int number);

	boolean checkPalindrome(String str);

	int[] getFiboSeriesUptoNthNumber(int number);

	int findDiff(int number);

	List<List<Integer>> Allsubsets(AlgorithmRequest algorithmRequest);

	int getEvenSubsetCount(AlgorithmRequest algorithmRequest);

	int[] getImmidiateSmallerElement(AlgorithmRequest algorithmRequest);

	int getMaxRectangleArea(int[][] algorithmRequest);

	int[] getZigZagArray(AlgorithmRequest algorithmRequest);

	int getThirdLargestElement(AlgorithmRequest algorithmRequest);

	List<Integer> getSmallestAndSecondSmallestElement(AlgorithmRequest algorithmRequest);

	int getCountForAnagram(String str1, String str2);

	List<Integer> sieveOfEratosthenes(int number);

	boolean checkSubsequence(String str1, String str2);

	HashMap<String, Integer> getFirstAndLastoccuerence(AlgorithmRequest algorithmRequest, int x);

	String mergeTwoStrings(String str1, String str2);

	boolean isGoodOrBadString(String str1);

	boolean getUniqueNumberOfOccurence(AlgorithmRequest algorithmRequest);

	List<ArrayList<Integer>> getStockBuyAndSell(AlgorithmRequest algorithmRequest);

	int maxProfit(AlgorithmRequest algorithmRequest);

	int countOfMinChar(String str);

	int getMissingnumber(AlgorithmRequest algorithmRequest);

	int getKthSmallestNumber(AlgorithmRequest algorithmRequest, int k);

	int getEquilibriumPoint(AlgorithmRequest algorithmRequest);

	int secondLargestElement(AlgorithmRequest algorithmRequest);

	int getSumPairs(AlgorithmRequest algorithmRequest, int number);

	int getMaxProduct(AlgorithmRequest algorithmRequest);



}
