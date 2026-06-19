class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    void backtrack(int[] nums,int i,List<Integer> ans)
    {
        if(i==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        backtrack(nums,i+1,ans);
        ans.remove(ans.size()-1);
        backtrack(nums,i+1,ans);
    }
    public List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        backtrack(nums,0,ans);
        return res;
    }
}
