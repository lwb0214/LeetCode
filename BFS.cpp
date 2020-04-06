/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
//二叉树的层序遍历（BFS）
//使用队列实现“重放”
class Solution {
public:
    vector<int> PrintFromTopToBottom(TreeNode* root) {
        auto cur =root; //指向根节点
        vector<int> res(0); //返回数组
        if(!cur)	return res;    //如果是空树，直接返回
        queue<TreeNode*> q;    //队列：先进先出
        q.push(root);    //根节点入队
        
        while(!q.empty())    //如果队伍非空
        {
            cur=q.front();    //取出队头
            res.push_back(cur->val);    //把队头的值赋给数组
            q.pop();    //队头出队
            if(cur->left)	q.push(cur->left);    //左孩子入队
            if(cur->right)	q.push(cur->right);    //右孩子入队
        }
        return res;
    }
};

// Java版本二叉树的层序遍历
/* 
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return res;
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            res.add(cur.val);
            if(cur.left!=null) 
				q.offer(cur.left);
            if(cur.right!=null) 
				q.offer(cur.right);
        }
        
        return res;
    }
}
*/