/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
	
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if(s.val == t.val) {
            //以根节点为起点判断是否包含t
            result = helper(s, t);
        }
        //如果找不到，那么就再用s的左儿子当作起点，去判断是否包含t
        //注意这里不能直接用helper而要递归判断，因为这棵子树可能“藏”得比较深
        if (!result && s.left != null) {
            result = isSubtree(s.left, t);
        }
        //如果还找不到，那么就再用s的右儿子当作起点，去判断是否包含t
        //同上
        if (!result && s.right != null) {
            result = isSubtree(s.right, t);
        }

        return result;
    }
    public boolean helper(TreeNode s, TreeNode t) {
        //两棵树都遍历完咯~~
        if (t == null && s == null) {
            return true;
        }
        //只遍历完其中一棵囧~~
        if (t == null || s == null) {
            return false;
        }

        if (s.val != t.val) {  
            return false;
        }
         
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}