package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem_500_Keyboard_Row {

    public String[] findWords(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("s", 1);
        map.put("d", 1);
        map.put("f", 1);
        map.put("g", 1);
        map.put("h", 1);
        map.put("j", 1);
        map.put("k", 1);
        map.put("l", 1);

        map.put("q", 0);
        map.put("w", 0);
        map.put("e", 0);
        map.put("r", 0);
        map.put("t", 0);
        map.put("y", 0);
        map.put("u", 0);
        map.put("i", 0);
        map.put("o", 0);
        map.put("p", 0);

        map.put("z", 2);
        map.put("x", 2);
        map.put("c", 2);
        map.put("v", 2);
        map.put("b", 2);
        map.put("n", 2);
        map.put("m", 2);

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            String str = words[i].toLowerCase();

            boolean found = true;
            int num = 1;
            for(int j = 0; j < str.length(); j++) {
                if(j == 0) {
                    num = map.get(str.charAt(0) + "");
                }
                else {
                    if(map.get(str.charAt(j) + "") != num) {
                        found = false;
                        break;
                    }
                }
            }
            if(found)
                list.add(words[i]);
        }
        return list.toArray(new String[0]);
    }
}