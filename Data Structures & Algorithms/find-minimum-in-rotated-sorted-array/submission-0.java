// in binary serach we return usually low;
class Solution 
{
    public int findMin(int[] nums) 
    {
        int low=0;
        int high = nums.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(nums[mid]>nums[high])//then unsorted lies in the rhs
            {
                low=mid+1;
            }
            else
            {
                high=mid;
            }
        }
        return nums[low];
    }
}
