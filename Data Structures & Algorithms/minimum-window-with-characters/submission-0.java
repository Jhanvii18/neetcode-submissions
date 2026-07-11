class Solution 
{
    boolean contains(int[] in,int[] find)
    {
        for(int i=0;i<128;i++)
        {
            if(find[i]>in[i])
            {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) 
    {
        if(t.length()>s.length())
        return "";

        int min = Integer.MAX_VALUE;
        String ret = "";

        int[] find = new int[128];
        for(char ch:t.toCharArray())
        {
            find[ch]++;
        }
        char[] schar = s.toCharArray();
        for(int right =0;right<s.length();right++)
        {
            int[] in = new int[128];

            int idx=right;
            int count =0;

            while(!contains(in,find) && idx<s.length())
            {
                in[schar[idx]]++;
                idx++;
            }

            if(contains(in,find))
            {
                if(min>s.substring(right,idx).length())
                {
                    ret =s.substring(right,idx);
                    min=s.substring(right,idx).length();
                }
            }
        }
        return ret;
    }
}
