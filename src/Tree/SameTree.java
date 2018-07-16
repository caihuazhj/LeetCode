package Tree;

public class SameTree {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    //递归遍历左右字数
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q==null){
            return true;
        }
        if(p ==null ||q==null){
            return false;
        }
        if (p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }
}
