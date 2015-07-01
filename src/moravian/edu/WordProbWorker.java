package moravian.edu;

import java.io.*;
import java.util.*;

public class WordProbWorker {
	ArrayList<String> dictionary;
	int length;
	char firstletter;
	/**
	 * Create a dictionary from the specified file. The format of the file is as
	 * follows: each non-blank line in the file is a word.
	 * 
	 * @param filename
	 *            - the file to be read.
	 * @return
	 * @throws FileNotFoundException
	 *             - if the file does not exist.
	 * @throws IOException
	 */
	public WordProbWorker() throws FileNotFoundException,
			IOException {
		length = randomInt();
		firstletter = randomChar();
		dictionary = new ArrayList<String>();
		Scanner fileIn = null;
		
		try {
			fileIn = new Scanner(new FileReader("@dictionary/larger_dict.txt"));
			while (fileIn.hasNext()) {
				dictionary.add(fileIn.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
		}
	}

	public boolean checkWord(String str) {
		boolean b = false;
		if (str.length() == length && str.charAt(0) == firstletter) {
			int i = 0;
			while (i != dictionary.size()) {
				int index = Math.abs(Collections.binarySearch(dictionary, str));
				String tmp = dictionary.get(index);
				
				System.out.println("word: " + tmp);
				
				if (tmp.compareToIgnoreCase(str) == 0) {
					b = true;
				}
				i++;
			}
		}
		return b;
	}
	
	public char randomChar() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return c;
	}

	public int randomInt() {
		Random r = new Random();
		int num = r.nextInt(7 - 3) + 3;
		return num;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public char getLetter() {
		return firstletter;
	}
	public int getWordLength() {
		return length;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
