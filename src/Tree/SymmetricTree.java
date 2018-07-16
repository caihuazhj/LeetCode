package Tree;

import java.util.logging.Level;

/**
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 递归 迭代
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Approach 1: Recursive
     * Their two roots have the same value.
     * The right subtree of each tree is a mirror reflection of
     * the left subtree of the other tree.
     * (left.left == right.right)&&(left.right==right.left)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1,TreeNode t2){

        if (t1 ==null || t2 ==null){
            return false;
        }
        if (t1 ==null && t2 ==null){
            return true;
        }
        return (t1.val==t2.val)
                && isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
    }
}
