package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem_804_Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        List<String> secret = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");

        Set<String> set = new HashSet<String>();
        for(String str: words){
            char[] chars = str.toCharArray();
            String s = "";
            for(char c: chars){
                s = s + secret.get(c-'a');
            }
            set.add(s);
        }
        return set.size();

    }
}
