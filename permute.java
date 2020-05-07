import java.util.List;
import java.util.ArrayList;

class Solution {
    private int[] nums;
    private int len;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len <= 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(res, path, used, 0); 
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> path,
                    boolean[] used, int depth) {
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;
                dfs(res, newPath, newUsed, depth+1);
            }
        }
    }
}