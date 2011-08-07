package practice;

import java.util.Arrays;

public class ArraysNStrings {

	/*
	 * Function checks if a string has all unique characters.
	 * 
	 * @returns true if all are unique / false if not Complexity O(n) No buffer
	 * used
	 */
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static void removeDuplicateChars1(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			System.out.println(str);
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		System.out.println(str);
	}

	public static String removeDuplicateChars(char[] str) {
		if (str == null || str.length < 2)
			return str.toString();
		int checker = 0;
		for (int i = 0; i < str.length; i++) {
			int val = str[i] - 'a';
			int temp = i;
			while((checker & (1 << val)) > 0 && temp++ < str.length-1) {
				val = str[temp] - 'a';
			}
			if(temp < str.length) {
				str[i] = str[temp];
				checker |= (1 << val);
			}
			if(temp == str.length)
				str[i] = 0;
		}
		System.out.println(str);
		return str.toString();
	}
	
	public static boolean areAnagrams(String str1, String str2) {
		Arrays.sort(str1.toCharArray());
		Arrays.sort(str2.toCharArray());
		if(str1.equals(str2))  return true;
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(ArraysNStrings.isUniqueChars("abc"));
		//ArraysNStrings.removeDuplicateChars1("aab".toCharArray());
		//ArraysNStrings.removeDuplicateChars("iloveyou".toCharArray());
		System.out.println(ArraysNStrings.areAnagrams("abc", "cba"));
	}
}
