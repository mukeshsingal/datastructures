package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_1078_Occurrences_After_Bigram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<String>();
        
        for(int i=0;i<words.length-2;i++){
            if(words[i].equals(first) && words[i+1].equals(second))
                list.add(words[i+2]);
        }
        return list.toArray(new String[0]);        
    }
}