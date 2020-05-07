/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 	
 *示例:

 *输入: [1,2,3,null,5,null,4]
 *输出: [1, 3, 4]
 *解释:

	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
 */
 //dfs
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res, int level) {
        if (root==null) return;
        if (level==res.size()) {
            res.add(root.val);
        }
        level++;
        dfs(root.right, res, level);
        dfs(root.left, res, level);
    }
}
//bfs
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (node.left!=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
                if (i == (size-1)) res.add(node.val);
            }
        }
        return res;
    }
}