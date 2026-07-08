//since its integer its 32 bits 
class Solution 
{
    public int[] countBits(int n) 
    {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int mask =1;
            int count =0;
            for(int j=0;j<32;j++)
            {
                if((i&mask)!=0)
                {
                    count++;
                }
                mask<<=1;
            }
            res[i]=count;
        }
        return res;
    }
}
