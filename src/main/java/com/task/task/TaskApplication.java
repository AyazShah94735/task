package com.task.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static java.sql.DriverManager.println;


@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

		String input = "ayya";

		// Check if the input is a palindrome
		boolean isPalindrome = plandrom(input);
		if (isPalindrome) {
			System.out.println("The input is a palindrome.");
		} else {
			System.out.println("The input is not a palindrome.");
		}

		String input2 = "cbacdcbc";
		String result = new TaskApplication().removeDuplicateLetters(input2);
		System.out.println("After removing duplicates: " + result);


		String substringInput = "pwwkew"; // Change this input as needed
		int longestLength = lengthOfLongestSubstring(substringInput);
		System.out.println("Length of the longest substring without repeating characters: " + longestLength);
	}

	public static boolean plandrom(String input) {
		int i;
		int j = input.length() - 1;
		for (i = 0; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(j)) {
				System.out.println("Input is not palindrome");
				return false;
			}
			j--;
		}
		System.out.println("Input is palindrome");
		return true;
	}

	public String removeDuplicateLetters(String s) {
		ArrayList<Integer> lastOccurrence = new ArrayList<>(26);
		ArrayList<Boolean> inResult = new ArrayList<>(26);
		List<Character> result = new LinkedList<>();


		for (int i = 0; i < 26; i++) {
			lastOccurrence.add(-1);
			inResult.add(false);
		}

		for (int i = 0; i < s.length(); i++) {
			lastOccurrence.set(s.charAt(i) - 'a', i);
		}

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);


			if (inResult.get(currentChar - 'a')) continue;


			while (!result.isEmpty() && result.get(result.size() - 1) > currentChar &&
					lastOccurrence.get(result.get(result.size() - 1) - 'a') > i) {
				inResult.set(result.remove(result.size() - 1) - 'a', false);
			}


			result.add(currentChar);
			inResult.set(currentChar - 'a', true);
		}


		StringBuilder stringBuilder = new StringBuilder();
		for (char ch : result) {
			stringBuilder.append(ch);
		}

		return stringBuilder.toString();
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int n = s.length();

		for (int start = 0; start < n; start++) {
			HashSet<Character> charSet = new HashSet<>();
			for (int end = start; end < n; end++) {
				char currentChar = s.charAt(end);

				if (charSet.contains(currentChar)) {
					break;
				}

				charSet.add(currentChar);
				maxLength = Math.max(maxLength, end - start + 1);
			}
		}

		return maxLength; // Return the maximum length found
	}
}