class Solution 
{
    Boolean[][] dp;

    boolean backtrack(int index, int count, String s)
    {
        if(count < 0)
        {
            return false;
        }

        if(index == s.length())
        {
            return count == 0;
        }

        if(dp[index][count] != null)
        {
            return dp[index][count];
        }

        char ch = s.charAt(index);

        if(ch == '(')
        {
            return dp[index][count] = backtrack(index + 1, count + 1, s);
        }

        if(ch == ')')
        {
            return dp[index][count] = backtrack(index + 1, count - 1, s);
        }

        return dp[index][count] =
                backtrack(index + 1, count, s) ||
                backtrack(index + 1, count + 1, s) ||
                backtrack(index + 1, count - 1, s);
    }

    public boolean checkValidString(String s) 
    {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        return backtrack(0, 0, s);
    }
}
/*class Solution 
{
    boolean backtrack(int index,int count, String s)
    {
        if(count<0)
        {
            return false;
        }
        if(s.length()==index)
        {
            if(count==0)
            return true;
            else
            return false;
        }
        if(s.charAt(index)==')')
        {
            return backtrack(index+1,count-1,s);
        }
        if(s.charAt(index)=='(')
        {
            return backtrack(index+1,count+1,s);
        }
        return backtrack(index+1, count, s)
        || backtrack(index+1, count+1, s)
        || backtrack(index+1, count-1, s);
    }
    public boolean checkValidString(String s) 
    {
        return backtrack(0,0,s);
    }
}*/
