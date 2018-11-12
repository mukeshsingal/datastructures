package algo.seaching;

public class BinarySearch {

    public boolean binarySearch(int arr[], int number) {
        return binarySearch(arr, 0, arr.length - 1, number);
    }

    //{12, 23, 34, 45, 56, 67};
    public boolean binarySearch(int arr[], int start, int end, int number) {
        int mid = (start + end) / 2;
        if (arr[mid] == number) {
            return true;
        }
        if (mid == start || mid == end) {
            return false;
        }
        if (arr[mid] > number)
            return binarySearch(arr, start, mid, number);
        return binarySearch(arr, mid + 1, end, number);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = {12, 23, 34, 45, 56, 67};
        System.out.println("Search for 12 : " + binarySearch.binarySearch(arr, 12));
        System.out.println("Search for 67 : " + binarySearch.binarySearch(arr, 67));
        System.out.println("Search for 45 : " + binarySearch.binarySearch(arr, 45));
        System.out.println("Search for 54 : " + binarySearch.binarySearch(arr, 54));
    }
}
