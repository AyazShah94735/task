package com.task.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.sql.DriverManager.println;


@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

		String input = "ayya";

		boolean isPalindrome = plandrom(input);
		if (isPalindrome) {
			System.out.println("The input is a palindrome.");
		} else {
			System.out.println("The input is not a palindrome.");
		}

		String result = removeDuplicate(input);
		System.out.println("After removing duplicates: " + result);
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


	public static String removeDuplicate(String input) {
		StringBuilder unDLetter = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if(i!=0 && !unDLetter.contains(input.charAt(i))){
				unDLetter.append(input.charAt(1));
			}
		}
		return unDLetter.toString();
	}


	public static void longestSubstring(String input) {
		StringBuilder unDLetter = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if(i!=0 && !unDLetter.contains(input.charAt(i))){
				unDLetter.append(input.charAt(1));
			}
		}
	}


	public static String subSubstring(String input) {
		StringBuilder longestSubString = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if(i!=0 && !longestSubString.contains(input[i])){ {
				return longestSubString.toString();
			} else {
				longestSubString.append(input[i]);
			}
		}
		return longestSubString.toString();
	}
}