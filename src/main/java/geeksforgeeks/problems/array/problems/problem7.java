package geeksforgeeks.problems.array.problems;

/**
 * Merge an array of size n into another array of size m+n
 * There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains n elements. Merge these
 * two arrays into the first array of size m+n such that the output is sorted.
 */
public class problem7 {

    public static void merge(int[] arr, int[] N, int m, int n) {
        int nIndex = 0;
        int mIndex = m-1;
        for(int i=0; i<m+n; i++) {
            if(mIndex < m+n && arr[mIndex] <= N[nIndex] || nIndex == n){
                arr[i] = arr[mIndex];
                mIndex++;
            }
            else {
                arr[i] = N[nIndex];
                nIndex++;
            }
        }
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public static void moveToEnd(int[] arr) {
        //mPlusN array there will be m elements atleast
        int index = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != -1) {
                arr[index] = arr[i];
                index--;
            }
        }

    }

    public static void main(String[] args) {
        /* Initialize arrays */
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;

        /*Move the m elements at the end of mPlusN*/
        moveToEnd(mPlusN);


        /*Merge N[] into mPlusN[] */
        merge(mPlusN, N, m, n);


    }
}
