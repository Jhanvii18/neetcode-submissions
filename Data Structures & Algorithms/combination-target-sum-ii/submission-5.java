class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    void backtrack(int[] candidates,int target,int i,List<Integer> ans)
    {
        if(target==0)
        {
            List<Integer> temp = new ArrayList<>(ans);
            if(!set.contains(temp))
            {
                set.add(temp);
                res.add(new ArrayList<>(temp));
                return;
            }
            else
            {
                return;
            }
        }
        if(i==candidates.length || target<0)
        {
            return;
        }
        ans.add(candidates[i]);
        backtrack(candidates,target-candidates[i],i+1,ans);//no repeat i.e next

        int next = i+1;
        while(next<candidates.length && candidates[i]==candidates[next])
        {
            next++;
        }

        ans.remove(ans.size()-1);
        backtrack(candidates,target,next,ans);//ignore
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,ans);
        return res;
    }
}
