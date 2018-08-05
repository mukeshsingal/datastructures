package geeksforgeeks.problems.array.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {21, 23, 45, 66, 90};

        int[] keysToBeSearched = {10, 0, -23, 46, 100, 90, 45, 66, 23, 21};
        int[] expectedResult = {-1, -1, -1, -1, -1, 4, 2, 3, 1, 0};


        for (int i = 0; i < keysToBeSearched.length; i++) {
            System.out.println("Expected result: " + expectedResult[i] + ", Actual Result: " + binarySearch(array, 0, 4, keysToBeSearched[i]));
        }

    }


    // Implement recursive binary search {21, 23, 45, 66, 90};
    public static int binarySearch(int[] inputArray, int start, int end, int key) {
        //if key is matched return index
        //if key is matched return index

        if(end-start <= 0 ){
            return -1;
        }

        int mid = (start + end)/2;
        if(inputArray[mid] == key){
            return mid;
        }

        //check if key present left of mid
        if(inputArray[mid] > key){
            return binarySearch(inputArray, start, mid, key);
        }

        return binarySearch(inputArray, mid+1, end, key);
    }
}
