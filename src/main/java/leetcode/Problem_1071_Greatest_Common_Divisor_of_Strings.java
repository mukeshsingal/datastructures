package leetcode;

public class Problem_1071_Greatest_Common_Divisor_of_Strings {

    public String gcdOfStrings(String str1, String str2) {

        return solve(str1,str2);

    }

    String solve(String str1,String str2){

        if(str1.length()<str2.length()) return solve(str2,str1);  //making str1 longer

        if(str2.length()==0) return str1; //

        if(!str1.startsWith(str2)) return "";

        return solve(str1.substring(str2.length()),str2);
    }
}