package Tree;
/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 二叉树中序遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        mid(root,res);
        return res;

    }

    public void mid(TreeNode root,List<Integer> res){
        if (root!=null){
            if (root.left!=null){
                mid(root.left,res);
            }
            res.add(root.val);
            if (root.right!=null){
                mid(root.right,res);
            }
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        //迭代需要用一个栈
        Stack<TreeNode> stack = new Stack<>();

        //定义节点
        TreeNode current = root;
        while (root!=null ||!stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;

        }
        return res;

    }
}
