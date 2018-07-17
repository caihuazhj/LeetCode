package Tree;

import org.omg.CORBA.IRObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root==null){
            return res;
        }
        res.add(root.val);
        if (root.left!=null){
            preorderTraversal(root.left);
        }
        if (root.right!=null){
            preorderTraversal(root.right);
        }
        return res;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null ||!stack.isEmpty()){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            stack.pop();
            root = root.right;
        }
        return res;
    }
}
