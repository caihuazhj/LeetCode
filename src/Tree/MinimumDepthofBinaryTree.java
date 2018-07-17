package Tree;

public class MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {

        if (root==null){ return 0;}
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        int m = Math.min(l,r);
        return 1 + (m > 0 ? m : Math.max(l, r));
    }
}
