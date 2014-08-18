package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class tester
	{

		/**
		 * @param args
		 */
		
		public static void main(String[] args) {
			ArrayList<String> dictionary;
			File file= new File("dictionary.txt");
			dictionary = readFromFile(file);
			System.out.print(dictionary.get(1));
		}

		public static ArrayList<String> readFromFile(File file) 
		  {
		    ArrayList<String> words = new ArrayList<String>();

		    try 
			{
		      /*
		       * Java's Scanner class is a simple lexer for Strings and primitive types
		       * (see the Java API, if you are unfamiliar).
		       */
		      Scanner fileInput = new Scanner(file);

		      /*
		       * The scanner can be directed how to delimit (or divide) the input. By
		       * default, it uses whitespace as the delimiter. The following statement
		       * specifies anything other than alphabetic characters as a delimiter (so
		       * that punctuation and such will be ignored). The string argument is a
		       * regular expression that specifies "anything but an alphabetic
		       * character". You need not understand any of this for the assignment.
		       */
		      fileInput.useDelimiter("\\s*[^a-zA-Z]\\s*");

		      while (fileInput.hasNext()) 
			  {
		        String s = fileInput.next();
				
		        if (!s.equals("")) 		
		          words.add(s.toLowerCase());        
		      }

		    } 
			catch (FileNotFoundException e) 
			{
		      System.err.println("File " + file + " cannot be found.");
		    }
			
		    return words;
		  }
	}

