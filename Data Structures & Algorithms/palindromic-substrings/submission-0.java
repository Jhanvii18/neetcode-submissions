class Solution 
{
    int count=0;
    public int countSubstrings(String s) 
    {
        if(s.length()<=1)
        return 1;

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
                count++;
            }

            start = i-1;
            end=i;
            while(end<s.length() && start>=0 && s.charAt(start)==s.charAt(end))
            {
                start--;
                end++;
                count++;
            }
        }
        return count+1;
    }
}
