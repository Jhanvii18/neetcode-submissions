//maxspeed = max element in piles
//we use ceil operaation in divsion
class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int target = h;
        Arrays.sort(piles);

        int high=piles[piles.length-1];
        int low = 1;

        int ret=-1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int sum =0;

            for(int i =0;i<piles.length;i++)
            {
                sum = (int)(sum + Math.ceil((double)piles[i]/mid));
            }

            if(sum<=target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}
