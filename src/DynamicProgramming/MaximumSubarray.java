package DynamicProgramming;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int cur = 0;
        int res= Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++){
            //从第一个元素开始，加上后边元素是否比之前大，如果不大，重新开始构建子串
            cur = Math.max(nums[i],cur+nums[i]);
            res = Math.max(cur,res);
        }

        return res;

    }

    /**
     *
     * @param A
     * @return
     */
    public int maxSubArray1(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            //核心思想 前一个子串是否大于0
//            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            dp[i] = Math.max(dp[i - 1]+A[i],A[i]);
            max = Math.max(max, dp[i]);
        }

        return max;

    }
}
