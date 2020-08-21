package leetcode;

class Problem_961_N_Repeated_Element_in_Siz_2N_Array {

    public int repeatedNTimes(int[] A) {
     int[] arr = new int[10000];   
        for(int i: A) {
            if(arr[i] == -1) {
                return i;
            }
            arr[i] = -1;
        }
        return -1;
    }
}