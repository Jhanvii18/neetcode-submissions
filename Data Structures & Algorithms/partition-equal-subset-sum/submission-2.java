class Solution 
{
    boolean backtrack(int i,int target,int[] nums)
    {
        if(target==0)
        {
            return true;
        }
        if(target<0 || i==nums.length)
        {
            return false;
        }
        return backtrack(i+1,target-nums[i],nums) || backtrack(i+1,target,nums);
    }
    public boolean canPartition(int[] nums) 
    {
        int n = nums.length;

        int tsum=0;
        for(int i=0;i<n;i++)
        {
            tsum = tsum + nums[i];
        }

        if(tsum%2!=0)
        return false;

        
        int first = tsum/2;
        boolean ans =backtrack(0,first,nums);

        return ans;
    }
}
