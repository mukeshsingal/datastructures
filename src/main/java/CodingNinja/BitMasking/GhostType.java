import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuffer abc = new StringBuffer("1234");
        permute(abc, 0, abc.length() - 1);
    }

    public static void permute(StringBuffer string, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (leftIndex == rightIndex) {
                //System.out.println(string);
                //if special
                boolean found = false;
                for(int j=0; j < rightIndex; j++) {
                    for (int k = j +1; k < rightIndex; k++) {
                        int val1 = Character.getNumericValue(string.charAt(j));
                        int val2 = Character.getNumericValue(string.charAt(k));

                        if((val1 & val2) == val1 && j < k) {
                            System.out.println("" + val1 + " " + val2);
                            System.out.println(string.toString());
                            found = true;
                            break;
                        }
                    }
                    if(found) {
                        break;
                    }
                }

            } else {
                swap(string, leftIndex, i);
                permute(string, leftIndex + 1, rightIndex);
                swap(string, leftIndex, i);
            }
        }
    }

    public static void swap(StringBuffer string, int index1, int index2) {
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }
}