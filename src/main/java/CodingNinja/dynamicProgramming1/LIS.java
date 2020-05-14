package CodingNinja.dynamicProgramming1;

public class LIS {
    public static void main(String[] args) {
        int[] arr= {4, 3, 9,7, 6,8,20};

        LIS l = new LIS();

        System.out.println(l.lis(arr));
    }

    public int lis(int[] num) {
        int[] output = new int[num.length];
        output[0] = 1;
        for(int i = 1; i < num.length; i++) {
            output[i] = 1;
            for(int j = i -1; j >= 0; j--) {
                if(num[i] > num[j]) {
                    if(output[j] + 1 > output[i]) {
                        output[i] = output[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for(int i : output) {
            max= Math.max(max, i);
        }
        return max;
    }
}