// if 0's are connected to the boundary and boundary has no 0 then 100 percent the 0's are 
//bound to be surrounded by x
//set of x connected to the boudary 0 cant be converted
class Solution 
{
    void dfs(int row,int col,boolean[][] visited,char[][] ans,char[][] board)
    {
        int m = board.length;
        int n = board[0].length;
        visited[row][col]=true;
        if(row-1>=0 && board[row-1][col]=='O' && !visited[row-1][col])
        {
            ans[row-1][col]='O';
            dfs(row-1,col,visited,ans,board);
        }
        if(col-1>=0 && board[row][col-1]=='O' && !visited[row][col-1])
        {
            ans[row][col-1]='O';
            dfs(row,col-1,visited,ans,board);
        }
        if(row+1<m && board[row+1][col]=='O' && !visited[row+1][col])
        {
            ans[row+1][col]='O';
            dfs(row+1,col,visited,ans,board);
        }
        if(col+1<n && board[row][col+1]=='O' && !visited[row][col+1])
        {
            ans[row][col+1]='O';
            dfs(row,col+1,visited,ans,board);
        }
    }
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;
        char[][] ans = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(ans[i],'X');
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[m-1][i] && board[m-1][i]=='O')
            {
                ans[m-1][i]='O';
                dfs(m-1,i,visited,ans,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            if(!visited[i][n-1] && board[i][n-1]=='O')
            {
                ans[i][n-1]='O';
                dfs(i,n-1,visited,ans,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            if(!visited[i][0] && board[i][0]=='O')
            {
                ans[i][0]='O';
                dfs(i,0,visited,ans,board);
            }
        }

        for(int i=0;i<n;i++)
        {
            if(!visited[0][i] && board[0][i]=='O')
            {
                ans[0][i]='O';
                dfs(0,i,visited,ans,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=ans[i][j];
            }
        }
    }
}
