package Tree;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth==-1||rightDepth==-1){
            return false;
        }
        return Math.abs(leftDepth-rightDepth)<=1;
    }

    /**
     * 首先获得高度，期间比较左右子树高度差
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {

        if (root ==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if(leftDepth==-1 ||rightDepth==-1){
            return -1;
        }

        if (Math.abs(leftDepth-rightDepth)>1){
            return -1;
        }

        int res = 1+Math.max(leftDepth,rightDepth);
        return res;
    }
}
