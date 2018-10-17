package geeksforgeeks.problems.Tree.Youtube;

public class Problem38_Print_Postorder_traversal_from_given_Inorder_and_Preorder_traversals {

    public static void main(String[] args) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};

        System.out.println("POST ORDER");
        //printPostOrder(in, pre, in.length);
    }

    // A utility function to search x in arr[] of size n
    public static int search(int arr[], int x, int n) {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

    // Prints postorder traversal from given inorder and preorder traversals
    public static void printPostOrder(int in[], int pre[], int n, int inStart) {
        int root = search(in, pre[0], n);

        //print if left tree exist
        //if(root !=0)
         //printPostOrder(in, pre.clone(), root);
    }


}


