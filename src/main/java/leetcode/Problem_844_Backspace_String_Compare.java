package leetcode;

public class Problem_844_Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        int aSize = a.length - 1;
        int bSize = b.length - 1;


        while(aSize >= 0 || bSize >= 0) {
            int backspace = 0;
            while(aSize >= 0) {
                if(a[aSize] == '#') {
                    backspace++;
                    aSize--;
                }
                else if(backspace > 0) {
                    aSize--;
                    backspace--;
                    continue;
                }
                else {
                    break;
                }
            }


            backspace = 0;
            while(bSize >= 0) {
                if(b[bSize] == '#') {
                    backspace++;
                    bSize--;
                    continue;
                }
                if(backspace > 0) {
                    bSize--;
                    backspace--;
                    continue;
                }
                else {
                    break;
                }
            }

            char aC = aSize >= 0 ? a[aSize] : ' ';
            char bC = bSize >= 0 ? b[bSize] : ' ';

            //System.out.println(aC + " " + bC);

            if(aC != bC) return false;
            aSize--;
            bSize--;
        }
        return true;
    }
}
