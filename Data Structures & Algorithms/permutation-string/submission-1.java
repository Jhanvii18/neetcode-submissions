class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int[] bucket = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            bucket[s1.charAt(i)-'a']++;
        }
        int k = s1.length();
        int left=0;
        for(int right =0;right<=s2.length()-k;right++)
        {
            int[] target = new int[26];
            int count=0;
            int idx=right;
            while(count<k)
            {
                target[s2.charAt(idx)-'a']++;
                idx++;
                count++;
            }
            if(Arrays.equals(target,bucket))
            return true;
        }
        return false;
    }
}
