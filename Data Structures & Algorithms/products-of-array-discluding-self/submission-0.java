class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int n= nums.length;
        right[n-1]=1;
        left[0]=1;
        for(int i =1;i<nums.length;i++)
        {
            left[i]=nums[i-1]*left[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i]=nums[i+1]*right[i+1];
        }
        int[] out = new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            out[i]=right[i]*left[i];
        }
        return out;
    }
}  
