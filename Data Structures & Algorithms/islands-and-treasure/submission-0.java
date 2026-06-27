class Solution 
{
    void dfs(int row,int col,int[][] grid,int[][] days,int index)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(row+1<m && grid[row+1][col]==2147483647 && index+1<days[row+1][col])
        {
            days[row+1][col]=index+1;
            dfs(row+1,col,grid,days,index+1);
        }
        if(row-1>=0 && grid[row-1][col]==2147483647 && index+1<days[row-1][col])
        {
            days[row-1][col]=index+1;
            dfs(row-1,col,grid,days,index+1);
        }
        if(col+1<n && grid[row][col+1]==2147483647 && index+1<days[row][col+1])
        {
            days[row][col+1]=index+1;
            dfs(row,col+1,grid,days,index+1);
        }
        if(col-1>=0 && grid[row][col-1]==2147483647 && index+1<days[row][col-1])
        {
            days[row][col-1]=index+1;
            dfs(row,col-1,grid,days,index+1);
        }
    }
    public void islandsAndTreasure(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] days = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(days[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 0)
                {
                    days[i][j]=0;
                    dfs(i,j,grid,days,0);
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == Integer.MAX_VALUE && days[i][j] != Integer.MAX_VALUE)
                {
                    grid[i][j] = days[i][j];
                }
            }
        }
    }
}
