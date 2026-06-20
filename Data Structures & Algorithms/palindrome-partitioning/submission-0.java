class Solution 
{
    List<List<String>> res = new ArrayList<>();
    void backtrack(String s,List<String> ans,int i)
    {
        if(i==s.length())
        {
            res.add(new ArrayList<>(ans));
            return;
        }

        for( int j=i;j<s.length();j++)
        {
            String part = s.substring(i,j+1);
            boolean val = ispalin(part);
            if(val)
            {
                ans.add(part);
                backtrack(s,ans,j+1);
                ans.remove(ans.size()-1);
            }
        }

    }
    boolean ispalin(String s)
    {
        int front =0;
        int end =s.length()-1;
        while(front<=end)
        {
            if(s.charAt(front)!=s.charAt(end))
            return false;

            front++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) 
    {
        List<String> ans = new ArrayList<>();
        backtrack(s,ans,0);
        return res;
    }
}
