class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    void backtrack(int[] nums,List<Integer> ans,boolean[] used)
    {
        if(ans.size()==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
            continue;

            else//not used
            {
                ans.add(nums[i]);
                used[i]=true;
            }

            backtrack(nums,ans,used);

            ans.remove(ans.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        boolean[] used = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        backtrack(nums,ans,used);
        return res;
    }
}
