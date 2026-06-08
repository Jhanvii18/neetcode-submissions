class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            int current = nums[i];
            if(!set.contains(current-1))
            {
                while(set.contains(current))
                {
                    count++;
                    current++;
                }
            }
            if(count>max)
            {
                max=count;
            }
        }
        return max;
    }
}
