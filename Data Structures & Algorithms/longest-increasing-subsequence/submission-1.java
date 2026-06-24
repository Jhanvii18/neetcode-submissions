class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(i==j)
                {
                    break;
                }
                else if(nums[j]<nums[i])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                else
                {
                    continue;
                }
            }
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
}
