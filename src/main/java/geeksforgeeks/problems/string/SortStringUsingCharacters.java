package geeksforgeeks.problems.string;

public class SortStringUsingCharacters {
    public static void main(String[] args) {
        int[] characterCount = new int[26];

        String str = "geeksforgeeks";

        for (int i = 0; i < str.length(); i++) {
            characterCount[str.charAt(i) - 'a']++;
        }

        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < characterCount.length; i++) {
            sf.append(new String(new char[characterCount[i]]).replace('\0', (char) (i + 'a')));
        }
        System.out.println("Actual: " + sf);
        System.out.println("Expected " + "eeeefggkkorss");

    }
}
