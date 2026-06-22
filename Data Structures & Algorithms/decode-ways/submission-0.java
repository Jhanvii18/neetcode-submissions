//number of ways to decode empty string is 1 that is  ""
//we use n+1 as dp size
// based on the number of dependency of the last to strings we initialize 
//the first 2 parameters
//formula: ways to decode at ways[n-1] when the single didgit is valid
// + the ways to decode ways[n-2] when 2 digits are valid
class Solution 
{
    public int numDecodings(String s) 
    {
        if(s.length()<=2)
        {
            if(s.charAt(0)==0)
            {
            return 0;
            }
        }
        int[] dp = new int[s.length()+1];//+1 because we need at 0 casue at 0 its =1
        dp[0]=1;
        if(s.charAt(0)!='0')
        {
            dp[1]=1;
        }
        else
        {
            dp[1]=0;
        }
        for(int i =2;i<=s.length();i++)
        {
            int s1 = Integer.parseInt(s.substring(i-1,i));
            int s2 = Integer.parseInt(s.substring(i-2,i));
            if(s1!=0)
            {
                dp[i]=dp[i]+dp[i-1];
            }
            if(s2>=10 && s2<=26)
            {
                dp[i]=dp[i]+dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
