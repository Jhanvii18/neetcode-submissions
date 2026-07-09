class Solution 
{
    public int maxProfit(int[] nums) 
    {
        int currpro =0;
        int maxpro=0;
        int newpro=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<newpro)
            {
                newpro=nums[i];
            }
            else
            {
                currpro = nums[i] - newpro;
                maxpro=Math.max(maxpro,currpro);
            }
        }
        return maxpro;
    }
}
