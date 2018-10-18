package geeksforgeeks.ds;


public class MyBST{

    private static BSTNode root;

    class BSTNode {
        BSTNode left;
        BSTNode right;
        int key;

        public BSTNode(int key) {
            left = right = null;
            this.key = key;
        }

        public void insert(int key){
            if(key < this.key){
                if(left != null) left.insert(key);
                else left = new BSTNode(key);
            }
            else{
                if(right != null) right.insert(key);
                else right = new BSTNode(key);
            }
        }

        public BSTNode search(int key){
            if( this.key == key){
                return this;
            }
            if(key < this.key){
                if(left != null)
                    return left.search(key);
                else{
                    return null;
                }
            }
            else{
                if(right != null)
                    return right.search(key);
                else
                    return null;
            }
        }
    }

    public BSTNode deleteNode(BSTNode node, int key) {
        {
            /* Base Case: If the tree is empty */
            if (node == null)  return node;

            /* Otherwise, recur down the tree */
            if (key < node.key)
                node.left = deleteNode(node.left, key);
            else if (key > node.key)
                node.right = deleteNode(node.right, key);
            else
            {
                if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;

                node.key = getSuccessor(node.right);

                node.right = deleteNode(node.right, node.key);
            }

            return node;
        }
    }

    int getSuccessor(BSTNode root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public MyBST() {
        root = null;
    }

    public void delete(int key){
        root = deleteNode(root, key);
    }
    void insert(int key) {
        if(root == null) {
            root = new BSTNode(key);
        }
        else{
            root.insert(key);
        }
    }

    static boolean searchUsingIteration(int key) {
        BSTNode node = root;
        while (node != null) {
            if (node.key < key)
                node = node.right;
            else if ((int)node.key > key)
                node = node.left;
            else
                return true;
        }
        return false;
    }

    BSTNode search(int key) {
        if(root == null || root.key == key) {
            return root;
        }
        else{
            BSTNode resultNode = root.search(key);
            if(resultNode == null){
                System.out.println("Element not found");
            }
            else{
                System.out.println("Element found with key " + resultNode.key);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        MyBST tree = new MyBST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.delete(80);
        tree.search(80);


        String x = "" +
                "              50\n" +
                "           /     \\\n" +
                "          30      70\n" +
                "         /  \\    /  \\\n" +
                "       20   40  60   80";

        System.out.println(x);
        //tree.search(30);
    }
}
