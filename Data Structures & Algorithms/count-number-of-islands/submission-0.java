class Solution 
{
    void dfs(int row, int col,char[][] grid,boolean[][] visited)
    {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col]=true;
        if(row+1<m && !visited[row+1][col] && grid[row+1][col]=='1')
        {
            dfs(row+1,col,grid,visited);
        }
        if(row-1>=0 && !visited[row-1][col]&& grid[row-1][col]=='1')
        {
            dfs(row-1,col,grid,visited);
        }
        if(col+1<n && !visited[row][col+1]&& grid[row][col+1]=='1')
        {
            dfs(row,col+1,grid,visited);
        }
        if(col-1>=0 && !visited[row][col-1]&& grid[row][col-1]=='1')
        {
            dfs(row,col-1,grid,visited);
        }

    }
    public int numIslands(char[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int c=0;
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    dfs(i,j,grid,visited);
                    c++;
                }
            }
        }
        return c;
    }
}
