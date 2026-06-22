class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int right = 1;
        int left = 1;
        int n = nums.length;

        if(nums.length<=1)
        return nums[n-1];

        int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(left==0)
            left=1;

            if(nums[n-i-1]==0)
            right=1;

            right=right*nums[n-i-1];

            left=left*nums[i];

            max=Math.max(max,Math.max(left,right));
        }
        return max;
    }
}
