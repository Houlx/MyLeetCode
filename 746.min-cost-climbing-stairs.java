/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * algorithms
 * Easy (50.08%)
 * Likes:    2215
 * Dislikes: 489
 * Total Accepted:    172.3K
 * Total Submissions: 341.8K
 * Testcase Example:  '[0,0,0,0]'
 *
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the
 * top.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
 * cost[3].
 * 
 * 
 * 
 * Note:
 * 
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0 || cost.length == 1)
            return 0;
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] totalCost = new int[cost.length];
        totalCost[0] = cost[0];
        totalCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            totalCost[i] = Math.min(totalCost[i - 1] + cost[i], totalCost[i - 2] + cost[i]);
        }
        return Math.min(totalCost[cost.length - 1], totalCost[cost.length - 2]);
    }
}
// @lc code=end
