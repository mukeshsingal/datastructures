package leetcode;

public class Problem_67_Add_Binary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();

        int carry = 0;
        int size = ar.length > br.length ? ar.length : br.length;

        int aSize = ar.length -1;
        int bSize = br.length -1;

        while(size > 0) {
            int n1 = aSize >= 0 ? ar[aSize] - '0' : 0;
            int n2 = bSize >= 0 ? br[bSize] - '0' : 0;
            int x = n1 + n2 + carry;
            if(x < 2) {
                sb.append(x);
                carry = 0;
            }
            else if(x == 2) {
                sb.append("0");
                carry = 1;
            }
            else {
                sb.append("1");
                carry = 1;
            }
            aSize--;
            bSize--;
            size--;
        }
        if(carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}