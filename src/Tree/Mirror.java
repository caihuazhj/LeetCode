package Tree;

/**
 * 求二叉树的镜像
 * 核心思想：递归，调换左右子树的值
 */

import java.util.ArrayList;
import java.util.List;

public class Mirror {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> mirrorRecursively(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirrorRecursively(root.left);
        }
        if (root.right != null) {
            mirrorRecursively(root.right);
        }
        return res;
    }
}
