class Solution 
{
    List<String> res = new ArrayList<>();
    void backtrack(int open,int close, String s,int n)
    {
        if(open==n && close==n)
        {
            res.add(s);
            return;
        }
        if(open<n)
        {
            backtrack(open+1,close,s+"(",n);
        }
        if(close<open)
        {
            backtrack(open,close+1,s+")",n);
        }
    }
    public List<String> generateParenthesis(int n) 
    {
        backtrack(0,0,"",n);
        return res;
    }
}
