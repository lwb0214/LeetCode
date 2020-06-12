import java.util.Scanner;

//01背包：不放或放
public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
        while (in.hasNextLine()) {
            int n,V;
            n = in.nextInt();
            V = in.nextInt();
			
            int[] v = new int[n + 1];
            int[] w = new int[n + 1];
			//初始化：f[0][0~V]=0
            int[] f = new int[V + 1];
			//统一，0不赋值
            for (int i = 1; i <= n; i++) {
                v[i] = in.nextInt();
                w[i] = in.nextInt();
            }
			
            //f[i][j] = Math.max(f[i-1][j], f[i-1][j-v[i]]+w[i]);
			//f[i][j]表示放入i个物品，占据空间为j时的最大价值
			//等价于 f[j] = Math.max(f[j], f[j-v[i]]+w[i]);
			//因为等号右边的f[j]实际上保存的是第i-1次（本次为第i次）循环的值
			//要注意内循环应倒序
            for (int i=1; i <= n; i++) {
                for (int j = V; j >= v[i]; j--) {
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
                }
            }
            System.out.println(f[V]);
        }
		
        in.close();
	}
	
}
