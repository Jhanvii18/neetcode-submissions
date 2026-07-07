class Solution 
{
    int count=0;
    void backtrack(int[] nums,int target,int i)
    {
        if(i==nums.length)
        {
            if(target==0)
            {
                count++;
            }
            return;
        }
        backtrack(nums,target+nums[i],i+1);
        backtrack(nums,target-nums[i],i+1);
    }
    public int findTargetSumWays(int[] nums, int target) 
    {
        backtrack(nums,target,0);
        return count;
    }
}
