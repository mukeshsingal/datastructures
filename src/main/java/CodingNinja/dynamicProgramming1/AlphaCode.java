package CodingNinja.DynamicProgramming1;

public class AlphaCode {

    public static void main(String[] args) {
        AlphaCode code = new AlphaCode();

        int[] num = {1, 2, 3 , 4};
        int size = 4;
        System.out.println(code.numCodes(num, size-1));

        int[] arr = new int[size];

        System.out.println(code.numCodesWithMemo(num, size-1, arr));
        System.out.println(code.numCodesIter(num, size));

    }

    public int numCodes(int[] num, int size) {
        if (size == 1) {
            return 1;
        }
        if (size == 0) {
            return 1; // Empty String
        }
        int output = numCodes(num, size - 1);
        if (num[size - 2] * 10 + num[size - 1] <= 26) {
            output += numCodes(num, size - 2);
        }
        return output;
    }
    public int numCodesWithMemo(int[] num, int size, int[] arr) {
        if (size == 1) {
            return 1;
        }
        if (size == 0) {
            return 1; // Empty String
        }
        if(arr[size] > 0) {
            return arr[size];
        }
        int output = numCodesWithMemo(num, size - 1, arr);
        if (num[size - 2] * 10 + num[size - 1] <= 26) {
            output += numCodesWithMemo(num, size - 2, arr);
        }
        arr[size] = output;
        return output;
    }
    public int numCodesIter(int[] num, int size) {
        int[] arr = new int[size+1];
        
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < size; i++) {
            arr[i] = arr[i-1];
            if(num[i-2] * 10 + num[i-1] <= 26) {
                arr[i] += arr[i-2];
            }
        }
        return arr[size-1];
    }
}
