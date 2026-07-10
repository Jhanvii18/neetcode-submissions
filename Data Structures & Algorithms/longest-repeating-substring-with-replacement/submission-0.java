class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int maxlen = 0;
        int left =0;
        int maxfreq =0;
        int[] bucket = new int[26];
        int window =0;
        for(int right=0;right<s.length();right++)
        {
            bucket[s.charAt(right)-'A']++;
            maxfreq = Math.max(maxfreq,bucket[s.charAt(right)-'A']);
            while((right-left+1)-maxfreq>k)
            {
                bucket[s.charAt(left)-'A']--;
                left++;
            }
            window = right-left+1;
            maxlen = Math.max(maxlen,window);
        }
        return maxlen;
    }
}
