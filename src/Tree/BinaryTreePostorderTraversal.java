package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
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
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if (root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode cur;
        TreeNode pre = null;
        while (!stack.isEmpty()){
            cur = stack.peek();
            if (pre ==null || pre.left==cur||pre.right==cur){
                if (cur.left!=null){
                    stack.push(cur.left);
                }else if(cur.right!=null){
                    stack.push(cur.right);
                }
            }else if(cur.left==pre){
                if (cur.right!=null){
                    stack.push(cur.right);
                }
            }else {
                res.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return res;

    }
}
