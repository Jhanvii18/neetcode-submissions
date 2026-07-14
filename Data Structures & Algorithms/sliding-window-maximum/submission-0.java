class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int c=0;
        int left=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int right=0;right<nums.length;right++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[right])
            {
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right-left+1==k)
            {
                res[c++]=nums[dq.peekFirst()];
                left++;
            }
            if(dq.peekFirst()<left)
            {
                dq.pollFirst();
            }
        }
        return res;
    }
}
