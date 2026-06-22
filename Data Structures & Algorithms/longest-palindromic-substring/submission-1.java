class Solution 
{
    public String longestPalindrome(String s) 
    {
        if(s.length()<=1)
        return s;

        int maxlen = 0;
        String sub="";
        int start=0;
        int end=0;
        String curr="";
        for(int i=1;i<s.length();i++)
        {
            start =i;
            end =i;
            while(end<s.length() &&  start>=0 && s.charAt(start)==s.charAt(end))
            {
                start--;
                end++;
            }
            sub = s.substring(start+1,end);
            if(sub.length()>maxlen)
            {
                maxlen=sub.length();
                curr=sub;
            }

            start = i-1;
            end=i;
            while(end<s.length() && start>=0 && s.charAt(start)==s.charAt(end))
            {
                start--;
                end++;
            }
            sub = s.substring(start+1,end);
            if(sub.length()>maxlen)
            {
                maxlen=sub.length();
                curr=sub;
            }
        }
        return curr;
    }
}
