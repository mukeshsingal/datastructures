package CodingNinja.AdvancedRecursion;

public class Keypad {

    static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        keypad(234);
    }

    static void keypad(int number) {
        keypad(number, "");
    }

    static void keypad(int number, String s) {
        if(number <= 0) {
            System.out.println(s);
        }
        int d = number % 10;

        number = number /10;

        for(char c : arr[d].toCharArray()) {
            keypad(number, c + s );
        }
    }

    


    
}