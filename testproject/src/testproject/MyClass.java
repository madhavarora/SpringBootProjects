package testproject;

import java.util.ArrayList;
import java.util.Arrays;

public class MyClass {
	
	private static ArrayList<String> cussWordsList  = new ArrayList(Arrays.asList("SHIP", "MISS", "DUCK", "PUNK","ROOSTER", "MOTHER", "BITS"));
	

	public static void main(String args[]){
		System.out.println("hello");
		
		boolean check = checkForCurseWords("kk", "mother");
		System.out.println("result" + check);
		
		Double d  = 1.5;
		d.compa
		
	}
	
public static boolean checkForCurseWords(String comment, String heading){
	
		String commentUpperCase = comment.toUpperCase();
		String headingUpperCase = heading.toUpperCase();
		String[] commentArray = commentUpperCase.split(" ");
		String[] headingArray = headingUpperCase.split(" ");
		//System.out.println(array[1]);
		
		 ArrayList commmentArrayList  = new ArrayList(Arrays.asList(commentArray));
		 ArrayList headingArrayList  = new ArrayList(Arrays.asList(headingArray));
		
	
		 for(String curseWord : cussWordsList){
			 if(commmentArrayList.contains(curseWord)|| headingArrayList.contains(curseWord)){
					return true;
				}
			 
			 
		 }
		
		
		
		return false;
	}
	
}
