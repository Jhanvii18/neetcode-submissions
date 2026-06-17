class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        //next smalles left
        left[0]=-1;
        right[n-1]=n;// it has to be n remember
        stack.push(0);
        for(int i=1;i<n;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                left[i]=stack.peek();
            }
            else
            {
                left[i]=-1;
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(n-1);
        for(int i =n-2;i>=0;i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                right[i]=stack.peek();
            }
            else
            {
                right[i]=n;//remeber right is n if no smalles right element 
            }
            stack.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            int width = right[i]-left[i]-1;
            int height = heights[i];
            int area = width*height;
            max= Math.max(area,max);
        }
        return max;
    }
}