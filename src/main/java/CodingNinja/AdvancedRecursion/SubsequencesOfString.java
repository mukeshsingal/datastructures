package CodingNinja.AdvancedRecursion;

public class SubsequencesOfString {

    public static void main(String[] args) {
        subsequencesOfString("abcd");
    }

    static void subsequencesOfString(String s) {
        subsequencesOfString(new StringBuilder(), 0, s.toCharArray());

    }

    static void subsequencesOfString(StringBuilder s, int index, char[] chars) {
        if(index >= chars.length) {
            System.out.println(s);
            return;
        }
        subsequencesOfString(s, index+1, chars);
        subsequencesOfString(s.append(chars[index]), index+1, chars);
        s.deleteCharAt(s.length()-1);
    }
}
