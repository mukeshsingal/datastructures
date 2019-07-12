package leetcode;

public class Problem_925_Long_Pressed_Name {

    public boolean isLongPressedName(String name, String typed) {
        int i = name.length() -1;
        int j = typed.length() -1;
        char lastTypedChar = ' ';
        char [] named = name.toCharArray();
        char [] type = typed.toCharArray();
        while(i > -1 && j > -1) {
            if(type[j] == named[i]) {
                lastTypedChar = type[j];
                i--;
                j--;
                continue;
            }
            else if(type[j] == lastTypedChar) {
                j--;
            }
            else
                return false;
        }
        if(i > -1) return false;
        return true;
    }
}