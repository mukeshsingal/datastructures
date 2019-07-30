package leetcode;

public class Problem_1089_Duplicate_Zeros {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int lastIndex = 0;
        for(int i = 0; i < len; i++) {

            lastIndex += arr[i] == 0 ? 2 : 1;

            if(lastIndex < len) {
                continue;
            }
            else if(lastIndex == len) {
                lastIndex = i;
                break;
            }
            else if(lastIndex > len) {
                arr[len - 1] = 0;
                len--;
                lastIndex = i-1;
                break;
            }
        }

        while(lastIndex >= 0) {
            if(arr[lastIndex] == 0) {
                arr[len - 1] = 0;
                len --;
                arr[len - 1] = 0;
            }
            else {
                arr[len - 1] = arr[lastIndex];
            }
            lastIndex--;
            len--;
        }
    }
}
