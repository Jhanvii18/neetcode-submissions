class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    void backtrack(int[] nums,int i,List<Integer> ans)
    {
        if(i==nums.length)
        {
            List<Integer> temp = new ArrayList<>(ans);
            if(!set.contains(temp))
            {
                res.add(new ArrayList<>(temp));
                set.add(temp);
            }
            return;
        }
        ans.add(nums[i]);
        backtrack(nums,i+1,ans);
        ans.remove(ans.size()-1);
        backtrack(nums,i+1,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,ans);
        return res;
    }
}