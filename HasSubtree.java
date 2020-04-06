/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

public TreeNode(int val) {
    this.val = val;
    }
}
**/
//注意子树与子结构的区别
public class Solution {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
             
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
            //返回结果
        return result;
    }
 
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果根节点对不上，则去查找node1的子结构中是否包含node2
		//如果题目要求判断Tree2是否为Tree1的子树，这里直接return false;
        if (node1.val != node2.val) {  
                return doesTree1HaveTree2(node1.left,node2)
					   || doesTree1HaveTree2(node1.right,node2);
        }
         
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) 
               && doesTree1HaveTree2(node1.right,node2.right);
    }