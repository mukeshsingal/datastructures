package leetcode;

class Problem_985_Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for(int i: A) {
            if((i & 1) == 0) {
                sum += i;
            }
        }

        int arr[] = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            if((A[queries[i][1]] & 1) == 0 && (queries[i][0] & 1) == 0) {
                A[queries[i][1]] += queries[i][0];
                sum += queries[i][0];
            }
            else if((A[queries[i][1]] & 1) != 0 && (queries[i][0] & 1) != 0) {
                A[queries[i][1]] += queries[i][0];
                sum += A[queries[i][1]];
            }
            else if((A[queries[i][1]] & 1) == 0 && (queries[i][0] & 1) != 0) {
                sum -= A[queries[i][1]];
                A[queries[i][1]] += queries[i][0];
            }
            else {
                A[queries[i][1]] += queries[i][0];
            }
            arr[i] = sum;
        }
        return arr;

    }
}