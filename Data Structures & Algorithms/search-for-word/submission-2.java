class Solution 
{
    boolean dfs(int row,int col,char[][] board,boolean[][] visited,String word,int index)//index is 0 at start
    {
        int m = board.length;
        int n = board[0].length;

        if(index==word.length())
        return true;
        
        if(row<0 || col<0 || row>=m || col>=n)
        return false;

        if(visited[row][col])
        return false;

        if(word.charAt(index)!=board[row][col])
        return false;

        visited[row][col]=true;

        boolean ans =
        dfs(row+1,col,board,visited,word,index+1)||
        dfs(row-1,col,board,visited,word,index+1)||
        dfs(row,col+1,board,visited,word,index+1)||
        dfs(row,col-1,board,visited,word,index+1);

        visited[row][col]=false;

        return ans;
    }
    public boolean exist(char[][] board, String word) 
    {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                boolean[][] visited = new boolean[m][n];
                if(board[i][j]==word.charAt(0))
                {
                    boolean val = dfs(i,j,board,visited,word,0);
                    if(val)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
