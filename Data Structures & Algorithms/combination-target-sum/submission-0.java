class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    void backtrack(int[] nums,int target,int i,List<Integer> ans)
    {
        if(target<0 || i==nums.length)
        {
            return;
        }
        if(target==0)
        {
            if(!set.contains(ans))
            {
                res.add(new ArrayList<>(ans));
                set.add(ans);
                return;
            }
            else
            return;
        }
        ans.add(nums[i]);
        backtrack(nums,target-nums[i],i,ans);//repeat
        backtrack(nums,target-nums[i],i+1,ans);//take next
        ans.remove(ans.size()-1);
        backtrack(nums,target,i+1,ans);//when just ignored
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<Integer> ans = new ArrayList<>();
        backtrack(nums,target,0,ans);
        return res;
    }
}
