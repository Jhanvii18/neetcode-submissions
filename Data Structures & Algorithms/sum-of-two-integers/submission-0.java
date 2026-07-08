class Solution 
{
    public int getSum(int a, int b) 
    {
        int sum =0;
        int carry =0;

        if(a==0)
        return b;

        if(b==0)
        return a;

        while(b!=0)
        {
            sum = a ^ b;
            carry = (a&b)<<1;
            a=sum;
            b=carry;
        }

        return sum;
    }
}