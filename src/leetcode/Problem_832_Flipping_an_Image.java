package leetcode;

class Problem_832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] i: A){
            int left = 0;
            int right = i.length-1;
            while(left < right){
                int a = i[left];
                i[left] = i[right] == 0 ? 1 : 0;
                i[right] = a == 0 ? 1 : 0;
                left++;
                right--;
            }
            if(left == right){
                i[left] = i[right] == 0 ? 1 : 0;
            }
        }
        return A;
    }
}
