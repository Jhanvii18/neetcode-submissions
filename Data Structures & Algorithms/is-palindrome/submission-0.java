class Solution 
{
    public boolean isPalindrome(String s) 
    {
        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!Character.isLetterOrDigit(l))
            {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(r))
            {
                right--;
                continue;
            }

            l=Character.toLowerCase(l);
            r=Character.toLowerCase(r);
            if(l!=r)
            {
                return false;
            }
            else
            {
                left++;
                right--;
            }
        }
        return true;
    }
}
