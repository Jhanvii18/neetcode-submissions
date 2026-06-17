class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        res[n-1]=0;
        for(int i = n-2;i>=0;i--)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                res[i]=stack.peek()-i;
            }
            else
            {
                res[i]=0;
            }
            stack.push(i);
        }
        return res;
    }
}
