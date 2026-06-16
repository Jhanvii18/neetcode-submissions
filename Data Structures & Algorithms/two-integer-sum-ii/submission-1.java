class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int n = numbers.length;
        int left = 0;
        int right =n-1;
        while(left<right)
        {
            int l = numbers[left];
            int r = numbers[right];
            if(l+r==target)
            {
                return new int[]{left+1,right+1};
            }
            else if(l+r>target)
            {
                right--;
            }
            else 
            {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
