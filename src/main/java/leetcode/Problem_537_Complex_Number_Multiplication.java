package leetcode;

public class Problem_537_Complex_Number_Multiplication {
    
    public String complexNumberMultiply(String a, String b) {

        int i = a.indexOf("+");
        int j = a.indexOf("i");
        int k = b.indexOf("+");
        int l = b.indexOf("i");

        int a1=Integer.parseInt(a.substring(0,i));
        int b1=Integer.parseInt(a.substring(i+1,j));
        int a2=Integer.parseInt(b.substring(0,k));
        int b2=Integer.parseInt(b.substring(k+1,l));

        int aa=a1*a2-(b1*b2);
        int ab=a1*b2+a2*b1;

        String result=String.valueOf(aa)+"+"+String.valueOf(ab)+"i";
        return result;
    }
}