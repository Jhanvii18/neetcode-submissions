//using a flag like soln watch nikhil lohia 
class Solution 
{
    public boolean canJump(int[] nums) 
    {
       int farthest = nums.length-1;
       for(int i= nums.length-2;i>=0;i--)
       {
          if(i+nums[i]>=farthest)
          {
            farthest = i;
          }
       } 
       return farthest==0;
    }
}
