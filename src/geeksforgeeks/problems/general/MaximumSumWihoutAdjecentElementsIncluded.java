package geeksforgeeks.problems.general;

public class MaximumSumWihoutAdjecentElementsIncluded {
    //Time Complexity: O(n). Space Complexity: O(n).
    public static void main(String[] args) {
        int[] array = {1, -5, 12, 7, -20, 19};

        int[] M = new int[array.length + 1];
        M[0] = array[0];
        M[1] = array[1];

        for (int i = 2; i < array.length; i++) {
            M[i] = M[i - 2] + array[i] > M[i - 1] ? M[i - 2] + array[i] : array[i];
        }
        for(int i: M)
            System.out.print (i + " ");
        System.out.println(M[array.length-1]);
    }
}
