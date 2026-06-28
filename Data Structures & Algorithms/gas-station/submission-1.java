//we have to check if the loop is even possible or not
// if total cost is greater than total gas then return -1
// if we are able to reach the end with a positive value then the soln exits 
// if value negative then reset the value to 0
class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int tot_g=0;
        int tot_c=0;
        for(int i=0;i<gas.length;i++)
        {
            tot_g=tot_g+gas[i];
            tot_c=tot_c+cost[i];
        }
        if(tot_c>tot_g)
        return -1;

        int currgas=0;
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
            currgas+=gas[i]-cost[i];// remember currgas+
            if(currgas<0)
            {
                start=i+1;
                currgas=0;
            }
        }
        return start;
    }
}
