//remember to check for duplicatess everytime
// we basically fix and number and pivot thw wholw sum around it
class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i =0;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])//see condition
            continue;

            int left=i+1;
            int right =nums.length-1;

            while(left<right)
            {

                int sum = nums[i]+nums[left]+nums[right];

                if(sum==0)
                {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left+1<n && nums[left]==nums[left+1])
                    left++;

                    while(right-1>0 && nums[right]==nums[right-1])
                    right--;

                    left++;
                    right--;
                }

                else if(sum>0)
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }
        return res;
    }
}
