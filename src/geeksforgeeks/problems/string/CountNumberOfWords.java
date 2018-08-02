package geeksforgeeks.problems.string;

public class CountNumberOfWords {
    public static void main(String[] args) {
        String string = "How    are  you";

        countNumberOfWords(string);
    }

    public static void countNumberOfWords(String string) {
        int word = 0;
        boolean wordFound = false;

        char[] c = string.toCharArray();

        for (int i = 1; i < c.length; i++) {
            if (c[i] == ' ' && wordFound == true) {
                wordFound = false;
            } else {
                if (c[i] != ' ' && wordFound == false) {
                    wordFound = true;
                    word++;
                }
            }
        }
        System.out.println(word);
    }
}
