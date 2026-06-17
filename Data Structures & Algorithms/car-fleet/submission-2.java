class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n = position.length;
        Integer[] idx = new Integer[n];//check it out
        for(int i=0;i<n;i++)
        {
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->position[b]-position[a]);
        int fleets=0;
        double prev=0.0;
        for(int i : idx)
        {
            double time = (double)(target-position[i])/speed[i];//if no double ans wont vome
            if(time>prev)
            {
                fleets++;
                prev=time;
            }
        }
        return fleets;
    }
}
