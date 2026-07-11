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
        int[] in = new int[128];
        int left=0;
        for(int right =0;right<s.length();right++)
        {
            in[schar[right]]++;

            while(contains(in,find) && left<s.length())
            {
                if(min>right-left+1)
                {
                    ret =s.substring(left,right+1);
                    min=right-left+1;
                }
                in[schar[left]]--;
                left++;
            }

        }
        return ret;
    }
}
