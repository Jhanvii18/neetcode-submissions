class Solution 
{
    public int jump(int[] nums) 
    {
        if (nums.length <= 1) return 0;

        int lastidx = 0;
        int coverage =0;
        int dest = nums.length-1;
        int jump=0;

        for(int i=0;i<nums.length-1;i++)
        {
            coverage=Math.max(coverage,i+nums[i]);

            if(i==lastidx)
            {
                lastidx=coverage;
                jump++;
            }

            if(lastidx>=dest)
            return jump;
        }
        return jump;
    }
}
