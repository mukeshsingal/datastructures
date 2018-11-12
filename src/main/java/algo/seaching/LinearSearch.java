package algo.seaching;

public class LinearSearch {

    /* Linear Search: Time Complexity O(N) */
    public boolean search(int arr[], int element) {
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int arr[] = {10, 12, 15, 20, 15, 12, -1};
        System.out.println("Search for 20: " + linearSearch.search(arr, 20));
    }
}
