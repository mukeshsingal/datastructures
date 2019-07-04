package leetcode;

public class Problem_606_Construc_String_fro_Binary_Tree {

    public String tree2str(TreeNode t) {
        if(t==null) return "";
        StringBuilder res = new StringBuilder();
        tree2str(t, res);
        return res.toString();
    }

    public void tree2str(TreeNode t, StringBuilder res) {
        res.append(t.val);

        if(t.left!=null) {
            res.append('(');
            tree2str(t.left, res);
            res.append(')');
        } else if(t.right!=null) {
            res.append("()");
        }

        if(t.right!=null) {
            res.append('(');
            tree2str(t.right, res);
            res.append(')');
        }
    }
}
