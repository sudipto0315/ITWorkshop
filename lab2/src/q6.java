import java.util.Scanner;

public class q6 {

    // Method to find the longest word in a sentence
    static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        return longestWord;
    }

    // Method to check if a sentence is a pangram
    static boolean isPangram(String sentence) {
        sentence = sentence.toLowerCase();
        boolean[] alphabets = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alphabets[ch - 'a'] = true;
            }
        }

        for (int i = 0; i < alphabets.length; i++) {
            if (!alphabets[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String longestWord = findLongestWord(sentence);

        System.out.println("The longest word in the sentence is: " + longestWord);
        if (isPangram(sentence)) {
            System.out.println("The sentence is a pangram.");
        } else {
            System.out.println("The sentence is not a pangram.");
        }
    }
}
