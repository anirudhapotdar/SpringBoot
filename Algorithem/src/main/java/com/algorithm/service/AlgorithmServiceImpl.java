package com.algorithm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.algorithm.request.AlgorithmRequest;
import com.algorithm.util.Util;


public class AlgorithmServiceImpl implements AlgorithmService {
	


	@Override
	public boolean isPrime(int number) {
		if (number == 2 || number == 3)
			return true;
		if (number <= 1)
			return false;
		if (number % 2 == 0)
			return false;
		for (int i = 3; i < number; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public boolean isPalindrome(int number) {
		int temp = number;
		int rev = 0;
		while (temp != 0) {
			int digits = temp % 10;
			rev = (rev * 10) + digits;
			temp = temp / 10;
			;
		}
		if (rev == number)
			return true;
		else
			return false;
	}

	@Override
	public int getFactorial(int number) {
		if (number <= 1)
			return 1;
		int fact = 1;
		while (number > 0) {
			fact = fact * number;
			number--;
		}
		return fact;
	}

	@Override
	public int getNthFiboNumber(int number) {
		// TODO Auto-generated method stub
		if (number <= 0)
			return 0;
		if (number == 1)
			return 1;
		int fibonacciNum[] = new int[number + 1];
		fibonacciNum[0] = 0;
		fibonacciNum[1] = 1;
		for (int i = 2; i <= number; i++) {
			fibonacciNum[i] = (fibonacciNum[i - 1] + fibonacciNum[i - 2]) % 1000000007;
		}
		return fibonacciNum[number];
	}

	@Override
	public boolean checkPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}

		return true;
	}

	@Override
	public int[] getFiboSeriesUptoNthNumber(int number) {
		if (number <= 1)
			return new int[] { 0, 1 };
		int[] fibonacciSeries = new int[number + 1];
		fibonacciSeries[0] = 0;
		fibonacciSeries[1] = 1;
		for (int i = 2; i <= number; i++) {
			fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
		}
		return fibonacciSeries;
	}

	@Override
	public int findDiff(int number) {
		int temp = number;
		int sum = 0;
		int pos = 1;
		while (temp > 0) {
			int digit = temp % 10;
			if (digit == 6)
				digit = digit + 3;
			else if (digit == 9)
				digit = digit - 3;
			temp = temp / 10;
			sum = sum + (digit * pos);
			pos = pos * 10;
		}
		return (sum > number) ? sum - number : number - sum;
	}

	@Override
	public List<List<Integer>> Allsubsets(AlgorithmRequest request) {
		List<List<Integer>> powerSet = new ArrayList<>();
		powerSet.add(new ArrayList<>());
		int[] numbers = request.getNumbers();
		for (int number : numbers) {
			int n = powerSet.size();
			for (int i = 0; i < n; i++) {
				List<Integer> temp = new ArrayList<Integer>(powerSet.get(i));
				temp.add(number);
				powerSet.add(temp);
			}
		}
		return powerSet;
	}

	@Override
	public int getEvenSubsetCount(AlgorithmRequest request) {
		// TODO Auto-generated method stub
		List<List<Integer>> powerset = new ArrayList<>();
		powerset.add(new ArrayList<>());
		int[] numbers = request.getNumbers();
		for (int num : Util.getEvenSubset(numbers)) {
			int length = powerset.size();
			for (int i = 0; i < length; i++) {
				List<Integer> temp = new ArrayList<>(powerset.get(i));
				temp.add(num);
				powerset.add(temp);
			}
		}
		return powerset.size() - 1;
	}

	@Override
	public int[] getImmidiateSmallerElement(AlgorithmRequest assignment2Request) {
		int[] numbers = assignment2Request.getNumbers();
		int[] result = new int[numbers.length];
		result[numbers.length - 1] = -1;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i + 1])
				result[i] = -1;
			else
				result[i] = numbers[i + 1];
		}
		return result;
	}

	@Override
	public int getMaxRectangleArea(int[][] numbers) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			hashMap.put("reactangle " + i, Util.getReactanglearea(numbers[i][0], numbers[i][1]));
		}
		Optional<Entry<String, Integer>> max = hashMap.entrySet().stream().max(Map.Entry.comparingByValue());
		Entry<String, Integer> maxvalue = max.get();
		return maxvalue.getValue();
	}

	@Override
	public int[] getZigZagArray(AlgorithmRequest assignment2Request) {
		int[] number = assignment2Request.getNumbers();
		for (int i = 0; i < number.length - 1; i++) {
			if (i % 2 == 0 && number[i + 1] < number[i]) {
				int[] result = Util.getSwap(number[i], number[i + 1]);
				number[i] = result[0];
				number[i + 1] = result[1];
			} else if (i % 2 == 1 && number[i + 1] > number[i]) {
				int[] result = Util.getSwap(number[i], number[i + 1]);
				number[i] = result[0];
				number[i + 1] = result[1];
			}
		}
		return number;
	}

	@Override
	public int getThirdLargestElement(AlgorithmRequest assignment2Request) {
		int[] number = assignment2Request.getNumbers();
		if (number.length < 3)
			return 0;
		Arrays.sort(number);
		return number[number.length - 3];
	}

	@Override
	public List<Integer> getSmallestAndSecondSmallestElement(AlgorithmRequest assignment2Request) {
		int[] numbers = assignment2Request.getNumbers();
		List<Integer> resultArray = new ArrayList<Integer>();
		if (numbers.length <= 2)
			return resultArray;
		Arrays.sort(numbers);
		resultArray.add(numbers[0]);
		resultArray.add(numbers[1]);
		return resultArray;
	}

	@Override
	public int getCountForAnagram(String str1, String str2) {
		Map<Character, Integer> str1Hashmap = new HashMap<>();
		Map<Character, Integer> str2Hashmap = new HashMap<>();
		int deletedchar = 0;
		for (char c : str1.toCharArray()) {
			str1Hashmap.put(c, str1Hashmap.getOrDefault(c, 0) + 1);
		}
		for (char c : str2.toCharArray()) {
			str2Hashmap.put(c, str2Hashmap.getOrDefault(c, 0) + 1);
		}

		for (char c : str1Hashmap.keySet()) {
			int cnt1 = str1Hashmap.get(c);
			int cnt2 = str2Hashmap.getOrDefault(c, 0);
			deletedchar = Math.abs(cnt1 - cnt2) + deletedchar;
		}
		for (char c : str2Hashmap.keySet()) {
			if (!str1Hashmap.containsKey(c)) {
				deletedchar += str2Hashmap.get(c);
			}
		}
		return deletedchar;
	}

	@Override
	public List<Integer> sieveOfEratosthenes(int number) {
		int[] isPrime = new int[number + 1];
		Arrays.fill(isPrime, 1);
		isPrime[0] = isPrime[1] = 0;
		for (int i = 2; i <= number; i++) {
			if (isPrime[i] == 1) {
				for (int j = 2 * i; j <= number; j = j + i) {
					isPrime[j] = 0;
				}
			}
		}
		List<Integer> resultPrime = new ArrayList<>();
		for (int i = 0; i <= number; i++) {
			if (isPrime[i] == 1) {
				resultPrime.add(i);
			}
		}
		return resultPrime;
	}

	@Override
	public boolean checkSubsequence(String str1, String str2) {
		char charArrayStr1[] = str1.toLowerCase().toCharArray();
		char charArrayStr2[] = str2.toLowerCase().toCharArray();
		int cnt = 0;
		for (int i = 0; i < charArrayStr1.length; i++) {
			int flag = 0;
			for (int j = i; j < charArrayStr2.length; j++) {
				if (flag == 0) {
					if (charArrayStr1[i] == charArrayStr2[j]) {
						cnt++;
						flag = 1;
					}
				}
			}
		}
		return (cnt == str1.length()) ? true : false;
	}

	@Override
	public HashMap<String, Integer> getFirstAndLastoccuerence(AlgorithmRequest assignment2Request, int x) {
		int[] number = assignment2Request.getNumbers();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < number.length; i++) {
			if (number[i] == x) {
				list.add(i);
			}
		}
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("First Occuernce of " + x, list.get(0));
		hashMap.put("Last Occuernce of " + x, list.get(list.size() - 1));

		return hashMap;
	}

	@Override
	public String mergeTwoStrings(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < (str1.length() + str2.length()); i++) {
			if (i < str1.length())
				sb.append(str1.charAt(i));
			if (j < str2.length()) {
				sb.append(str2.charAt(j));
				j++;
			}
		}
		return sb.toString();
	}

	@Override
	public boolean isGoodOrBadString(String str1) {
		int vowelCount = 0;
		int consonantsCount = 0;
		for (char c : str1.toCharArray()) {
			if (c == '?' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowelCount++;
				consonantsCount = 0;
			} else {
				vowelCount = 0;
				consonantsCount++;
			}

			if (vowelCount >= 5 || consonantsCount >= 3) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean getUniqueNumberOfOccurence(AlgorithmRequest assignment2Request) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int[] number = assignment2Request.getNumbers();
		for (int num : number) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}
		HashSet<Integer> set = new HashSet<>();
		for (int element : hashMap.values()) {
			if (set.contains(element))
				return false;
			else
				set.add(element);
		}
		return true;
	}

	@Override
	public List<ArrayList<Integer>> getStockBuyAndSell(AlgorithmRequest assignment2Request) {
		List<ArrayList<Integer>> ans = new ArrayList<>();
		int[] number = assignment2Request.getNumbers();
		int buy = 0;
		int sell = 0;
		for (int i = 0; i < number.length - 1; i++) {
			if (number[i + 1] > number[i]) {
				sell++;
			} else {
				if (sell > buy) {
					ArrayList<Integer> li = new ArrayList<>();
					li.add(buy);
					li.add(sell);
					ans.add(li);
				}
				buy = i + 1;
				sell = i + 1;
			}
		}
		if (sell > buy) {
			ArrayList<Integer> li = new ArrayList<>();
			li.add(buy);
			li.add(sell);
			ans.add(li);
		}
		return ans;
	}

	@Override
	public int maxProfit(AlgorithmRequest assignment2Request) {
		int[] numbers = assignment2Request.getNumbers();
		int maxProfit = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i + 1]) {
				maxProfit += numbers[i + 1] - numbers[i];
			}
		}
		return maxProfit;
	}

	@Override
	public int countOfMinChar(String str) {
		if(checkPalindrome(str))
			return 0;
		StringBuilder sb=new StringBuilder(str);
		sb=sb.reverse();
		int cnt=0;
		for(int i=0;i<sb.length()-1;i++)
		{
			
			str=String.valueOf(sb.charAt(sb.length()-2-i))+str;
			cnt++;
			if(checkPalindrome(str) == Boolean.TRUE)
				break;
		}
		return cnt;
	}

	@Override
	public int getMissingnumber(AlgorithmRequest assignment2Request) {
		int[] number = assignment2Request.getNumbers();
		Arrays.sort(number);
		int cnt=number[0];
		for(int i=0;i<number.length;i++)
		{
			if(number[i] !=cnt)
				return cnt;
			cnt++;
		}
		return cnt;		
	}

	@Override
	public int getKthSmallestNumber(AlgorithmRequest assignment2Request,int k) {
		int[] number = assignment2Request.getNumbers();
		Arrays.sort(number);
		if (number.length < k)
			return -1;
		for (int i = 0; i < k; i++) {
			if (i == k-1)
				return number[i];
		}
		return -1;
	}

	@Override
	public int getEquilibriumPoint(AlgorithmRequest assignment2Request) {
		int[] number = assignment2Request.getNumbers();
		if(number.length==1) return 1;
		int leftSum=0;
		int rightSum=0;
		for(int i=1;i<number.length;i++)
		{
			rightSum=rightSum+number[i];
		}
		for(int i=0;i<number.length-1;i++)
		{
			if(leftSum==rightSum)
				return i+1;
			leftSum=leftSum+number[i];
			rightSum=rightSum-number[i+1];
		}
		return 0;
	}

	@Override
	public int secondLargestElement(AlgorithmRequest assignment2Request) {
		int[] number = assignment2Request.getNumbers();
		int[] array = Arrays.stream(number).distinct().sorted().toArray();
		return array[array.length-2];
	}

	@Override
	public int getSumPairs(AlgorithmRequest assignment2Request, int k) {
		int[] number = assignment2Request.getNumbers();
		int cnt=0;
		for(int i=0;i<number.length;i++)
		{
				for(int j=i+1;j<number.length;j++)
				{
					if(number[i]+number[j]==k)
					{
						cnt++;
					}
				}
		}
		return cnt;
	}

	@Override
	public int getMaxProduct(AlgorithmRequest assignment2Request) {
		int[] nums = assignment2Request.getNumbers();
		int leftProduct = 1;
		int rightProduct = 1;
		int result = nums[0];

		for (int i = 0; i < nums.length; i++) {
			int max;
			leftProduct = leftProduct == 0 ? 1 : leftProduct;
			rightProduct = rightProduct == 0 ? 1 : rightProduct;
			leftProduct = leftProduct * nums[i];
			rightProduct = rightProduct * nums[nums.length - 1 - i];
			max = Math.max(leftProduct, rightProduct);
			result = Math.max(result, max);
		}
		return result;		
	}


}
