package cracking.the.coding;

/**
 * Rotate the letters of a word by k, using only 1 extra byte of storage.
 */
public class RotateLetters {
	
	public static byte[] rotateOne(byte[] word) {
		if (word.length >= 1) {
			int last = word.length - 1;
	
			byte temp = word[last];
			for (int i = last; i > 0; i--) {
				word[i] = word[i-1];
			}
			word[0] = temp;
		}
		
		return word;
	}
	
	public static byte[] rotate(byte[] word, int rotateBy) {
		
		return null;
	}
	

	public static void main(String[] args) {
		
		byte[] bar = {'b', 'a', 'r'};
		printWord(rotateOne(bar));
		
	}
	
	public static void printWord(byte[] word) {
		for (int i = 0; i < word.length; i++)
			System.out.print( (char) word[i]);
	}

}
