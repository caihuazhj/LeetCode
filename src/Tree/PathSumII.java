package Tree;
/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 基于深度优先搜索
 */

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSumHelper(root,sum,result,cur);
        return result;

    }

    public void pathSumHelper(TreeNode root ,int sum ,List<List<Integer>> result,List<Integer> cur){
        if (root==null){
            return;
        }
        cur.add(root.val);
        if (root.left==null && root.right==null && root.val==sum){
            result.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);
            return;
        }else {
            pathSumHelper(root.left,sum-root.val,result,cur);
            pathSumHelper(root.right,sum-root.val,result,cur);
        }
        cur.remove(cur.size()-1);

    }
}
