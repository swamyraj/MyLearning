package com.practice.java.utility;

public class CharacterTest {

	public static void main(String[] args) {
		
		System.out.println("\n=======general======");
		System.out.println(Character.SIZE);
		System.out.println(Character.BYTES);
		System.out.println(Character.MAX_CODE_POINT);
		System.out.println(Character.MAX_HIGH_SURROGATE);
		System.out.println(Character.UnicodeScript.KANNADA);
		System.out.println(Character.compare('c', 'c'));
		System.out.println(Character.digit('A', 2));
		System.out.println(Character.digit(95, 2));
		
		System.out.println("\n=======isDigit======");
		System.out.println(Character.isDigit('1'));
		System.out.println(Character.isDigit('a'));
		
		System.out.println("\n=======isLetter======");
		System.out.println(Character.isLetter('1'));
		System.out.println(Character.isLetter('A'));
		
		System.out.println("\n=======isLetterOrDigit======");
		System.out.println(Character.isLetterOrDigit('#'));
		System.out.println(Character.isLetterOrDigit('1'));
		
		System.out.println("\n=======isLowerCase======");
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isLowerCase('A'));
		
		System.out.println("\n=======isSpaceChar======");
		System.out.println(Character.isSpaceChar(' '));
		System.out.println(Character.isSpaceChar('\n'));
		System.out.println(Character.isSpaceChar('\t'));
		
		System.out.println("\n=======isWhitespace======");
		System.out.println(Character.isWhitespace(' '));
		System.out.println(Character.isWhitespace('\n'));
		System.out.println(Character.isWhitespace('\t'));

		System.out.println("\n=======isUpperCase======");
		System.out.println(Character.isUpperCase('a'));
		System.out.println(Character.isUpperCase('A'));
		
		System.out.println("\n=======toCodePoint======");
		System.out.println(Character.toCodePoint('a', 'b'));
		System.out.println(Character.toCodePoint('a', 'z'));
		
		System.out.println("\n=======instance methods======");
		Character c = new Character('a');
		System.out.println(c.equals('a'));
		System.out.println(c == 'a');
		System.out.println(c.compareTo('a'));
		
	}
}

