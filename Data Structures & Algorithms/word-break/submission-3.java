class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        Set<String> set = new HashSet<>(wordDict);
        int max=0;
        for(String st : wordDict)
        {
            max=Math.max(max,st.length());
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;

        for(int i=1;i<=s.length();i++)
        {
            for(int j = i-1;j>=Math.max(0,i-max);j--)//because we have to go back to check
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
