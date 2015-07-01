package moravian.edu;


import java.io.*;
import java.util.*;
	
	public class generateWords  {

	    ArrayList<String> dictionary;
	        int randInt;
	        char randChar;
	        
	        /**
	         * Create a dictionary from the specified file.  
	         * The format of the file is as follows: each non-blank line in the file is a word.
	         * @param filename - the file to be read.
	         * @return 
	         * @throws FileNotFoundException - if the file does not exist.
	         * @throws IOException 
	         */
	   public generateWords(String filename) throws FileNotFoundException, IOException {
	            
	            dictionary = new ArrayList<String>();
	            Scanner fileIn = null;
	            randChar = randomChar();
	            randInt = randomInt();
	            
	            try {
	                fileIn = new Scanner(new FileReader(filename));
	                while (fileIn.hasNext()) {
	                    dictionary.add(fileIn.nextLine());
	                }
	            } catch (FileNotFoundException e) {
	                System.err.println("Error: File not found.");
	            }
	        }
  
	    public char randomChar() {
	    	Random r = new Random();
	    	char c = (char)(r.nextInt(26) + 'a');
	    	return c;
	    }
	    
	    public int randomInt(){
	    	Random r = new Random();
	    	int num = r.nextInt(7-3)+3;
	    	return num;
	    }

	    
	// public boolean search(String str, int randInt, char randChar) {
	    public boolean search(String str) {
		boolean b = false;
		if (str.compareTo("") == 0) {
			b = false;
		} else if (str.length() == randInt && str.charAt(0) == randChar) {
			int i = 0;
			while (i == dictionary.size()) {
				int index = Math.abs(Collections.binarySearch(dictionary, str));
				String tmp = dictionary.get(index);
				if (tmp.compareToIgnoreCase(str) == 0) {
					b = true;
				} 
				i++;
			}
		}
		return b;
	}
	
	public char getLetter() {
		return randChar;
	}
	public int getWordLength() {
		return randInt;
	}
	
	public String word() {
		return dictionary.get(34);
	}
	public int ssize() {
		return dictionary.size();
	}
	
	}
	 
	    