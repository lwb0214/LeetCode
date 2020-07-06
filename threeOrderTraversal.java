/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution {
	 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        var cur=root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                res.add(cur.val);	//Add before going to children
                cur = cur.left;
            } else {
                var node = stack.pop();
                cur = node.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                var node = stack.pop();
                res.add(node.val);	//Add after all left children
                cur = node.right;
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        var cur = root;

        while (cur!=null || !stack.isEmpty()) {
            if (cur!=null) {
                stack.push(cur);
                res.addFirst(cur.val);  //Reverse the process of preorder
                cur = cur.right;          //Reverse the process of preorder
            } else {
                var node = stack.pop();
                cur = node.left;          //Reverse the process of preorder
            }
        }
        
        return res;
    }
}