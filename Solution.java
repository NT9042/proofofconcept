package drivers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.xml.sax.ext.LexicalHandler;

public class Solution {

	static String collapseString(String input) {
		StringBuilder str = new StringBuilder();
		Map<Character, Integer> collapsedStringMap = new LinkedHashMap<Character, Integer>();
		if (input.isEmpty()) {
			return "";
		} else {
			int count = 0;
			char lastChar = input.charAt(0);
			char thisChar;
			for (int i = 0; i < input.length(); i++) {
				thisChar = input.charAt(i);
				if (thisChar == lastChar) {
					count++;
				} else {
					collapsedStringMap.put(lastChar, count);
					str.append(count).append(lastChar);
					count = 1;
					lastChar = thisChar;
				}

				collapsedStringMap.put(input.charAt(input.length() - 1), count);
				str.append(count).append(lastChar);
			}
		}

		collapsedStringMap.entrySet().stream()
				.forEach(e -> str.append(e.getValue()).append(e.getKey()));

		return str.toString();

	}

	static long calculatePossibleCombinations(String input) {
		HashSet<String> strComboString = new HashSet<>();
		int j = 1;
		StringBuilder strCombo = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			for (int k = 0; k < input.length(); k++) {
				if (k != i)
					strCombo.append(input.charAt(k)).append("-");
				else
					strCombo.append(input.charAt(k));
			}
			strComboString.add(strCombo.toString());
			strCombo = new StringBuilder();
		}

		for (Iterator iterator = strComboString.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string.toString());
			for (int i = 0; i < string.length(); i++) {
				int count = 0;

				for (int m = 0; j < string.length(); m++) {
					if (string.charAt(m) == '-') {
						count++;
					}

				}

			}

		}

		return strComboString.size();
	}

	static int getMagicNumber(String s, int k, int b, int m) {
		Scanner d;
		List<String> substrings = new ArrayList<String>();
		for (int i = 0; i < s.length() - k + 1; i++) {
			substrings.add(s.substring(i, k + i));
		}
		IntSummaryStatistics stats = substrings.stream()
				.map(i -> convert(i, b)).mapToInt(i -> i % m)
				.summaryStatistics();
		return (int) stats.getSum();
	}

	static int convert(String numberStr, int base) {
		int result = 0;
		for (int i = 0; i < numberStr.length(); i++) {
			int place = numberStr.length() - 1 - i;
			int digit = Integer
					.parseInt(String.valueOf(numberStr.charAt(place)));
			int mult = (int) Math.pow(base, i);
			result = result + digit * mult;
		}
		return result;
	}

	public static void main(String[] args) {
		new Solution().add(1,2);
		new Solution().add(1,2,3);
		new Solution().add(1,2,3,4);
		new Solution().add(1,2,3,4,5);
		
	}

	class Holder implements Comparable<Holder> {
		int sum;
		List<Integer> pairs = new ArrayList<>();

		@Override
		public int compareTo(Holder o) {
			return Integer.compare(this.sum, o.sum);
		}

	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		StringBuilder formedWord = null;
		List<String> palindromeArray = new ArrayList<String>(words.length
				* words.length);
		int k = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				List<Integer> innerList = new ArrayList<>();
				if (i != j) {
					formedWord = new StringBuilder(words[i] + words[j]);
					if (checkAndPut(formedWord, palindromeArray)) {
						innerList.add(i);
						innerList.add(j);
						outerList.add(innerList);
						innerList = new ArrayList<>();
					}
				}
			}
		}
		List<Holder> holderL = new ArrayList<Solution.Holder>();
		for (List<Integer> list : outerList) {
			Solution.Holder holder = new Solution().new Holder();
			holder.sum = list.get(0) + list.get(1);
			holder.pairs = list;
			holderL.add(holder);
		}
		Collections.sort(holderL);
		outerList = new ArrayList<List<Integer>>();
		for (Holder hol : holderL) {
			outerList.add(hol.pairs);
		}
		return outerList;
	}

	public boolean checkAndPut(StringBuilder word,
			final List<String> palindromeArray) {
		int size = word.length();
		for (int i = 0; i < size; i++) {
			if ((word.charAt(i) != word.charAt(size - 1 - i))
					|| palindromeArray.contains(word)) {
				return false;
			}
		}
		palindromeArray.add(word.toString());
		return true;
	}

	public int calc(String word) {
		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			sum = sum + word.charAt(i);
		}
		return sum;
	}

	public boolean isInterleave(String s1, String s2, String s3) {

		return true;
	}

	public List<Integer> lexicalOrder(int n, boolean k) {
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i <=  n; i++) {
			String num = String.valueOf(i);
			String s = num.substring(0, 1);
			switch (s) {
			case "1":
				list.get(0).add(new String(num));
				break;
			case "2":
				list.get(1).add(new String(num));
				break;

			case "3":
				list.get(2).add(new String(num));
				break;

			case "4":
				list.get(3).add(new String(num));
				break;

			case "5":
				list.get(4).add(new String(num));
				break;

			case "6":
				list.get(5).add(new String(num));
				break;

			case "7":
				list.get(6).add(new String(num));
				break;

			case "8":
				list.get(7).add(new String(num));
				break;
			case "9":
				list.get(8).add(new String(num));
				break;
			}
			
		}
		List<Integer> listtt = new ArrayList<Integer>();
		
		for (List<String> integers : list) {
			Collections.sort(integers);
			for (String string : integers) {
				listtt.add(new Integer(string));
			}
		}
		return listtt;
	}
	
	public List<Integer> lexicalOrder(int n) {
		
		
		return null;
		
	}

		void add(int...nums){
			int sum=0;
			for (int i = 0; i < nums.length; i++) {
					sum = sum + nums[i];
					if(i !=0) {
						System.out.print("+"+ nums[i]);
					}else{
						System.out.print(nums[i]);
					}
					if(i == nums.length -1){
						System.out.println("=" + sum);
					}
			}
			
		}
	
}
