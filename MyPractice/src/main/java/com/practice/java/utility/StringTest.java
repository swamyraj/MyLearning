package com.practice.java.utility;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		
		
		
		System.out.println("=======codePoint======");
		String str = "myString";
		System.out.println(str.charAt(0));
		System.out.println(str.codePointAt(0));
		System.out.println(str.codePointBefore(1));
		System.out.println(str.codePointCount(1, 3));
		
		System.out.println("=======compareTo======");
		System.out.println(str.compareTo("my"));
		System.out.println(str.compareToIgnoreCase("MYSTRING"));
		
		System.out.println("=======concat,contains======");
		System.out.println(str.concat(" is Awesome"));
		System.out.println(str.contains("my"));
		
		System.out.println("=======contentEquals======");
		System.out.println(str.contentEquals("myString"));
		System.out.println(str.contentEquals(new StringBuffer("myString")));
		System.out.println(str.contentEquals(new StringBuffer("my")));
		
		System.out.println("=======equals======");
		System.out.println(str.endsWith("ing"));
		System.out.println(str.equals("myString"));
		System.out.println(str.equals(new StringBuffer("myString")));
		System.out.println(str.equalsIgnoreCase("MYSTRING"));
		
		System.out.println("=======indexOf======");
		System.out.println(str.indexOf("m"));
		System.out.println(str.indexOf("str"));
		System.out.println(str.indexOf("Str"));
		System.out.println(str.indexOf('S', 1));
		System.out.println(str.indexOf("Str",2));
		System.out.println(str.indexOf("Str",3));
		
		
		System.out.println("=======lastIndexOf======");
		str="StrmyString";
		System.out.println(str.lastIndexOf("m"));
		System.out.println(str.lastIndexOf("str"));
		System.out.println(str.lastIndexOf("Str"));
		System.out.println(str.lastIndexOf('S', 1));
		System.out.println(str.lastIndexOf("Str",2));
		System.out.println(str.lastIndexOf("Str",6));
		
		System.out.println("=======intern,empty,length======");
		String s1 = new String("abc");
		String s2="abc";
		String s3=s1.intern();
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		
		System.out.println("=======matches======");
		str="myString";
		System.out.println(str.matches("[*]"));
		System.out.println(str.matches("[a-zA-Z]"));
		System.out.println(Pattern.matches("a-zA-Z",str));
		System.out.println(str.offsetByCodePoints(1, 2));
		
		
		System.out.println("=======region matches======");
		str="Hello World!!!";
		String subStr="hi WoRld";
		System.out.println(str.regionMatches(str.indexOf("World"), subStr, subStr.indexOf("Rld"), subStr.indexOf(subStr.length())));
		System.out.println(str.regionMatches(false,str.indexOf("World"), subStr, subStr.indexOf("Rld"), subStr.indexOf(subStr.length())));
		
		System.out.println("=======replace======");
		str="malayalam123";
		System.out.println(str.replace('a', 'A'));
		System.out.println(str.replace("la", "LA"));
		System.out.println(str.replaceAll("[0-9]", "0"));
		System.out.println(str.replaceFirst("[0-9]", "0"));
		//Input: Java#8_version#10_k8;
		//output: Java##version##k
		String s = "Java#8_version#10_k8";
		System.out.println(s.replaceAll("[^a-zA-Z#]", ""));
		System.out.println(s.replaceAll("[0-9_]","").replaceAll("[#]", "$0$0"));
		
		System.out.println("=======starts with======");
		str="madam";
		System.out.println(str.startsWith("ma"));
		System.out.println(str.startsWith("am",3));
		System.out.println(str.startsWith("am",2));
		
		System.out.println("=======substring======");
		str="madam";
		System.out.println(str.substring(2));
		System.out.println(str.substring(2,4));
		
		System.out.println("=======Locale,cases======");
		str=" madam ";
		System.out.println(str.toCharArray());
		System.out.println(str.toLowerCase());
		System.out.println(str.toLowerCase(Locale.getDefault()));
		System.out.println(str.toLowerCase(Locale.CHINESE));
		System.out.println(str.toString());
		System.out.println(str.toUpperCase());
		System.out.println(str.toUpperCase(Locale.CANADA_FRENCH));
		System.out.println(str.trim());
		
		System.out.println("=======IntStream======");
		System.out.println(str.chars());
		str.chars().forEach(i->System.out.println(i));
		System.out.println(str.codePoints());
		str.codePoints().forEach(i->System.out.println(i));
		
		
		System.out.println("=======bytes======");
		System.out.println(str.getBytes());
		System.out.println(str.getBytes(Charset.defaultCharset()));
		try {
			System.out.println(str.getBytes(""));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception occured..."+e.getMessage());
		}
		System.out.println(str.getClass());
		
		
		System.out.println("=======Split======");
		str=" mad,am,gh,hl,kj ";
		System.out.println(Arrays.toString(str.split(",")));
		System.out.println(Arrays.toString(str.split(",", 2)));
		
	
		System.out.println("=======subsequence======");
		str="madammadm";
		System.out.println(str.subSequence(1, 5));
		System.out.println(String.copyValueOf(new char[] {'a','b','c'}));
		System.out.println(String.copyValueOf(str.toCharArray(), 1, 5));
		
		System.out.println("=======format======");
		str="google";
		System.out.println(String.format("My Company name is %s", str));
		System.out.println(String.format("My salary is %d", 10000));
		System.out.println(String.format("My salary is %.8f", 89.100089011178));
		System.out.println(String.format("My company is %1$s and %1$s and my salary is %2$d",str, 10000));
		
		
		System.out.println("=======join======");
		System.out.println(String.join("_", "abc","def","hig"));
		System.out.println(String.join("_", Arrays.asList("abc","def","hig")));
		System.out.println(String.join("", Arrays.asList("abc","def","hig")));
		System.out.println(String.join("_", Arrays.asList("abc","def",null)));
		
		System.out.println("=======valueOf======");
		str="google";
		System.out.println(String.valueOf(true));
		System.out.println(String.valueOf('c'));
		System.out.println(String.valueOf(new char[] {'a','b','c'}));
		System.out.println(String.valueOf(89.23));
		System.out.println(String.valueOf(89.23f));
		System.out.println(String.valueOf(89));
		System.out.println(String.valueOf(89L));
		System.out.println(String.valueOf(new char[] {'a','b','c','d'},1,3));
		
		
		System.out.println("======= case insensitive order======");
		String[] arr = new String[] {"cc","aa","EE", "DD"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("=======getChars======");
		str="malayalam";
		//deprecated
		//System.out.println(str.getBytes(srcBegin, srcEnd, dst, dstBegin));
		char[] charArray = new char[10] ;
		charArray[0]='X';
		charArray[1]='Y';
		charArray[2]='Z';
		str.getChars(2, 6, charArray, 1);
		System.out.println(Arrays.toString(charArray));
		
		
		
		
	}
	
}
