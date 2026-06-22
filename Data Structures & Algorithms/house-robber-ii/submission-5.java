class Solution 
{
    int max(int[] cost)
    {
        if(cost.length==0)
        return 0;

        if(cost.length==1)
        return cost[0];

        int n = cost.length;
        int[] dp = new int[n];
        dp[0]=cost[0];
        dp[1]=Math.max(cost[0],cost[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+cost[i]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) 
    {
        if(nums.length==0)
        return 0;

        if(nums.length==1)
        return nums[0];
        
        //case 1:
        int[] a1 = new int[nums.length-1];
        int[] a2 = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)
        {
            a1[i]=nums[i];
        }
        int k=0;
        for(int i=1;i<nums.length;i++)
        {
            a2[k++]=nums[i];
        }
        int dp1 = max(a1);
        int dp2 = max(a2);
        return Math.max(dp1,dp2);
    }
}
