/**
 * 
 */
package com.algorithm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorithm.request.AlgorithmRequest;
import com.algorithm.service.AlgorithmService;

/**
 * 
 */
@RestController
@RequestMapping("/algorithmassignment")
public class AlgorithmController {

	@Autowired
	AlgorithmService algorithmService;
	
	//1
	@GetMapping("/isPrime")
	public ResponseEntity<String> isPrime(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		boolean prime = algorithmService.isPrime(number);
		return new ResponseEntity<String>(String.valueOf(prime),HttpStatus.OK);
	}
	//2
	@GetMapping("/isPalindrome")
	public ResponseEntity<String> isPalindrome(@RequestParam(required =false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		boolean palindrome = algorithmService.isPalindrome(number);
		String response= palindrome ?"Yes" :"No";
		return new ResponseEntity<String> (response,HttpStatus.OK);
	}
	//3
	@GetMapping("/getFactorial")
	public ResponseEntity<String> getFactorial(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int factorial = algorithmService.getFactorial(number);
		return new ResponseEntity<String>(String.valueOf(factorial), HttpStatus.OK);
	}
	//4
	
		@GetMapping("/palindromString")
		public ResponseEntity<String> checkPalindromeString(@RequestParam(required = false) String str)
		{
			if(str.isEmpty())
			{
				return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
			}
			boolean checkPalindrome = algorithmService.checkPalindrome(str);
			return new ResponseEntity<String>(String.valueOf(checkPalindrome), HttpStatus.OK);
		}
	
	//5
	@GetMapping("/getNthFiboNumber")
	public ResponseEntity<String> nthFiboNumber(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int nthFiboNumber = algorithmService.getNthFiboNumber(number);
		return new ResponseEntity<String>(String.valueOf(nthFiboNumber), HttpStatus.OK);
	}
	//6
	@GetMapping("/getFibonacciSeriesUptoNthNumber")
	public ResponseEntity<String> fibonacciSeriesUptoNthNumber(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int[] fiboSeriesUptoNthNumber = algorithmService.getFiboSeriesUptoNthNumber(number);
		return new ResponseEntity<String>(Arrays.toString(fiboSeriesUptoNthNumber), HttpStatus.OK);
	}
	//7
	@GetMapping("/confusedPappu")
	public ResponseEntity<String> findDiff(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int findDiff = algorithmService.findDiff(number);
		return new ResponseEntity<String>(String.valueOf(findDiff), HttpStatus.OK);
	}
	//8
	@GetMapping("/getUniqueSubset")
	public ResponseEntity<String> getUniqueSubset(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		List<List<Integer>> allsubsets = algorithmService.Allsubsets(algorithmRequest);
		return new ResponseEntity<String>(allsubsets.toString(),HttpStatus.OK);
	}
	//9
	@GetMapping("/countEvenSubset")
	public ResponseEntity<String> countEvenSubset(@RequestBody (required = false) AlgorithmRequest request)
	{
		if(request==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int evenSubsetCount = algorithmService.getEvenSubsetCount(request);
		return new ResponseEntity<String>(String.valueOf(evenSubsetCount),HttpStatus.OK);
	}
	//10
	@GetMapping("/getMaxRectangleArea")
	public ResponseEntity<String> getMaxRectangleArea(@RequestBody(required = false) int[][] request)
	{
		if(request==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int maxRectangleArea = algorithmService.getMaxRectangleArea(request);
		return new ResponseEntity<String>(String.valueOf(maxRectangleArea),HttpStatus.OK);

	}
	//11
	@GetMapping("/getImmidiateSmallerElement")
	public ResponseEntity<String> immidiateSmallerElement(@RequestBody(required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int[] immidiateSmallerElement = algorithmService.getImmidiateSmallerElement(algorithmRequest);
		return new ResponseEntity<String>(Arrays.toString(immidiateSmallerElement), HttpStatus.OK);

	}
	
	//12
	@GetMapping("/zigZagArray")
	public ResponseEntity<String> getZigZag(@RequestBody(required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int[] zigZagArray = algorithmService.getZigZagArray(algorithmRequest);
		return new ResponseEntity<String>(Arrays.toString(zigZagArray), HttpStatus.OK);
	}
	//13
	
	@GetMapping("/thirdLargestElement")
	public ResponseEntity<String> getThirdElement(@RequestBody(required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		int thirdLargestElement = algorithmService.getThirdLargestElement(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(thirdLargestElement),HttpStatus.OK);
	}
	//14
	@GetMapping("/smallestAndSecondSmallestElement")
	public ResponseEntity<String> getsmallestAndSecondSmallestElement(@RequestBody(required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		List<Integer> smallestAndSecondSmallestElement = algorithmService.getSmallestAndSecondSmallestElement(algorithmRequest);
		return new ResponseEntity<String>(smallestAndSecondSmallestElement.toString(),HttpStatus.OK);
	}
	
	//15
	@GetMapping("/getCountOfRemovedCharForAnagram")
	public ResponseEntity<String> getRemovedChar(@RequestParam String str1,@RequestParam String str2)
	{
		if(str1.isEmpty() || str2.isEmpty())
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Strings to Check..",HttpStatus.BAD_REQUEST);
		}
		int countForAnagram = algorithmService.getCountForAnagram(str1,str2);
		return new ResponseEntity<String>(String.valueOf(countForAnagram),HttpStatus.OK);
	}
	
	//16
	@GetMapping("/sieveOfEratosthenes")
	public ResponseEntity<String> getSieveOfEratosthenes(@RequestParam(required = false) Integer number)
	{
		if(number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		List<Integer> sieveOfEratosthenes = algorithmService.sieveOfEratosthenes(number);
		return new ResponseEntity<String>(sieveOfEratosthenes.toString(),HttpStatus.OK);
	}
	//17
	@GetMapping("/checkSubSequence")
	public ResponseEntity<String> checkSubsequence(@RequestParam (required = false) String str1,@RequestParam (required = false) String str2)
	{
		if(str1.isEmpty() || str2.isEmpty())
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Strings to Check..",HttpStatus.BAD_REQUEST);
		}
		boolean checkSubsequence = algorithmService.checkSubsequence(str1,str2);
		return new ResponseEntity<String>(String.valueOf(checkSubsequence),HttpStatus.OK);
	}
	//18
	@GetMapping("/firstAndLastOccuernce")
	public ResponseEntity<String> checkFirstAndLastOccuence(@RequestBody (required = false) AlgorithmRequest algorithmRequest,@RequestParam(required = false,name = "number") Integer x)
	{
		if(algorithmRequest==null || x== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Number to Check..",HttpStatus.BAD_REQUEST);
		}
		HashMap<String, Integer> firstAndLastoccuerence = algorithmService.getFirstAndLastoccuerence(algorithmRequest, x);
		return new ResponseEntity<String>(firstAndLastoccuerence.toString(),HttpStatus.OK);
	}
	//19
	@GetMapping("/mergeStrings")
	public ResponseEntity<String> mergeStrings(@RequestParam (required = false) String str1,@RequestParam (required = false) String str2)
	{
		if(str1.isEmpty() || str2.isEmpty())
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Strings to merge..",HttpStatus.BAD_REQUEST);
		}
		String mergeTwoStrings = algorithmService.mergeTwoStrings(str1,str2);
		return new ResponseEntity<String>(mergeTwoStrings,HttpStatus.OK);
	}
	//20
	@GetMapping("/goodOrBadString")
	public ResponseEntity<String> isStringGoodOrBad(@RequestParam (required = false) String str1)
	{
		if(str1.isEmpty())
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Strings to merge..",HttpStatus.BAD_REQUEST);
		}
		boolean goodOrBadString = algorithmService.isGoodOrBadString(str1);
		String response=goodOrBadString? "Good":"Bad";
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	//21
	@GetMapping("/uniqueNumberOfOccurence")
	public ResponseEntity<String> getUniqueNumberOfOccurence(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		boolean uniqueNumberOfOccurence = algorithmService.getUniqueNumberOfOccurence(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(uniqueNumberOfOccurence),HttpStatus.OK);
	}
	
	//22
	@GetMapping("/stockBuyAndSell")
	public ResponseEntity<String> stockBuySell(@RequestBody (required = false)  AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		List<ArrayList<Integer>> stockBuyAndSell = algorithmService.getStockBuyAndSell(algorithmRequest);
		return new ResponseEntity<String>(stockBuyAndSell.toString(),HttpStatus.OK);
	}
	
	//23
	@GetMapping("/maxProfitInStock")
	public ResponseEntity<String> stockBuySell2(@RequestBody (required = false)  AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int maxProfit = algorithmService.maxProfit(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(maxProfit),HttpStatus.OK);
	}

	//24
	@GetMapping("/addMinChar")
	public ResponseEntity<String> addMinimumCharForPalindrome(@RequestParam (required = false) String str)
	{
		if(str== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Strings to merge..",HttpStatus.BAD_REQUEST);
		}
		int countOfMinChar = algorithmService.countOfMinChar(str);
		return new ResponseEntity<String>(String.valueOf(countOfMinChar),HttpStatus.OK);
	}
	//25
	@GetMapping("/missingNumber")
	public ResponseEntity<String> getMissingNumber(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int missingnumber = algorithmService.getMissingnumber(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(missingnumber),HttpStatus.OK);
	}
	//26
	@GetMapping("/kthSmallestElement")
	public ResponseEntity<String> getKthSmallestNumber(@RequestBody (required = false) AlgorithmRequest algorithmRequest,@RequestParam (required = false) Integer number)
	{
		if(algorithmRequest== null || number == null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int kthSmallestNumber = algorithmService.getKthSmallestNumber(algorithmRequest,number);
		return new ResponseEntity<String>(String.valueOf(kthSmallestNumber),HttpStatus.OK);
	}
	//27
	@GetMapping("/equilibriumPoint")
	public ResponseEntity<String> getEquilibriumPoint(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int equilibriumPoint = algorithmService.getEquilibriumPoint(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(equilibriumPoint),HttpStatus.OK);
	}
	
	//28
	
	@GetMapping("/secondLargestElement")
	public ResponseEntity<String> getSecondLargestElement(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int secondLargestElement = algorithmService.secondLargestElement(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(secondLargestElement),HttpStatus.OK);
	}
	//29
	@GetMapping("/countSumPairs")
	public  ResponseEntity<String> getSumPairs(@RequestBody (required = false) AlgorithmRequest algorithmRequest,@RequestParam (required = false)Integer number)
	{
		if(algorithmRequest== null || number==null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int sumPairs = algorithmService.getSumPairs(algorithmRequest,number);
		return new ResponseEntity<String>(String.valueOf(sumPairs),HttpStatus.OK);
	}
	//30
	@GetMapping("/getMaxProduct")
	public  ResponseEntity<String> getMaxProduct(@RequestBody (required = false) AlgorithmRequest algorithmRequest)
	{
		if(algorithmRequest== null)
		{
			return new ResponseEntity<String>("Bad Request !! Please Provide Numbers to merge..",HttpStatus.BAD_REQUEST);
		}
		int maxProduct = algorithmService.getMaxProduct(algorithmRequest);
		return new ResponseEntity<String>(String.valueOf(maxProduct),HttpStatus.OK);
	}
	
	


}
