package leetcode;

class Problem_709_To_Lower_Case  {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            if(chars[i] >='A' && chars[i] <= 'Z'){
                chars[i] =(char) (chars[i]-'A'+'a');
            }
        }
        return new String(chars);
    }
}
