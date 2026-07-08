class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int x1=0;
        int x2=0;
        for(int i=0;i<=nums.length;i++)
        {
            x1=x1^i;
        }
        for(int i=0;i<nums.length;i++)
        {
            x1=x1^nums[i];
        }
        return x1^x2;
    }
}
