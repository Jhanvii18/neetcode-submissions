class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<tokens.length;i++)
        {
            String c = tokens[i];
            if(!c.equals("+") && !c.equals("*") && !c.equals("-") && !c.equals("/"))
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                if(c.equals("+"))
                {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                }
                else if(c.equals("-"))
                {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
                else if(c.equals("*"))
                {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b);
                }
                else if(c.equals("/"))
                {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            }
        }
        return stack.peek();
    }
}
