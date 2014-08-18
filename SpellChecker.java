package assignment8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SpellChecker
	{
		public static void main(String[] args) 
		{	
			File dictionary = null;
			File document = null;
			String option = "";
			
			//Check to see if number of argument enter is valid
			if(args.length < 2 || args.length > 3)
			{
				System.out.println("\nIncorrect number of arguments!\n");
				return;
			}
			//Initialize our dictionary to a file
			dictionary = new File(args[0]);
		
			//Check to see if this dictionary file is a normal file
			if(!dictionary.isFile())
			{
				System.out.println("\nUnable to use the dictionary file!\n");
				return;
			}
			
			//Do the same for document file
			document = new File(args[1]);
			
			if(!document.isFile())
			{
				System.out.println("\nUnable to use the document file!\n");
				return;
			}
			
			// If a third parameter was passed for the options, check its validity 
			if (args.length == 3) 
	   			if(args[2].equalsIgnoreCase("-p") || args[2].equalsIgnoreCase("-f"))
	   				option = args[2];
	   			else 
	   			{
	   				System.out.println("\nInvalid printing or filing option argument!\n");
	   				return;
	   			}
			
			// Passing the dictionary file, document file, and the option
			run_spell_check(dictionary, document, option);		
		}

		private static void run_spell_check(File dic, File doc, String option)  
		{
			// Creating a new SpellCheckerUtil object with the dictionary file
			SpellCheckUtil mySC = new SpellCheckUtil(dic);
			
			// Creating a list of misspelled words after checking spellcheking the document
			List<String> misspelledWords = mySC.spellCheck(doc);
		   
			if (misspelledWords.size() == 0) 
				System.out.println("\nThere are no misspelled words in file " + doc + ".\n");
			else 
			{
				System.out.println("\nThere are " + misspelledWords.size() + " misspelled words in file " + doc + ".");
		      
				if(option.equals("-p"))
				{
					//For every string inside misspelled words, print it out.
					for(String s: misspelledWords)
						System.out.println(s);
				}
				else if(option.equals("-f"))				
					try
					{
						FileWriter writer = new FileWriter("misspelled.txt");
						
						//Put every misspelled word on a new line in the misspelled.txt file 
						for(String s: misspelledWords)
							writer.write(s + "\r\n");
						//Make sure to close the "writer" file you just populated.
						writer.close();
						
						System.out.println("Please see misspelled.txt for a list of the words.");	
					} 
					catch (IOException e) 
					{
						System.out.println("Unable to create a file for the misspelled words!");
						return;
					}
			
				System.out.println("\nHave a nice day!\n");		
			}		
		}
	}
