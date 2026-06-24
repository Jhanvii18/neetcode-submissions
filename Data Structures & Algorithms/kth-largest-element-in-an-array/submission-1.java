class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        int i=1;
        while(i<k)
        {
            pq.poll();
            i++;
        }
        return pq.poll();
    }
}
