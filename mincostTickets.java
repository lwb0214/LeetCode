/**
* 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，
* 你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

* 火车票有三种不同的销售方式：

* 一张为期一天的通行证售价为 costs[0] 美元；
* 一张为期七天的通行证售价为 costs[1] 美元；
* 一张为期三十天的通行证售价为 costs[2] 美元。
* 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
* 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

* 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
*/

class Solution {
     public int mincostTickets(int[] days, int[] costs) {
        int dLen = days[days.length - 1] + 1, day_idx = 0;
        int[] dp = new int[dLen]; // dp[0] = 0;
        final int _1DAY = 1, _7DAY = 7, _30DAY = 30;
        
        for (int i = 1; i < dLen; i++) {
            if (i == days[day_idx]) {
                dp[i] = min(
                    dp[Math.max(0, i - _1DAY)] + costs[0],
                    dp[Math.max(0, i - _7DAY)] + costs[1],
                    dp[Math.max(0, i - _30DAY)] + costs[2]
                );
                day_idx++;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dLen - 1];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}