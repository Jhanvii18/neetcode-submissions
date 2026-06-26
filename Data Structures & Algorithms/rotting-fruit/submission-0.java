class Solution 
{

    void dfs(int row,int col,int[][] grid,boolean[][] visited,int index,int[][] days)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(row + 1 < m && grid[row + 1][col] == 1 && index + 1 < days[row + 1][col])
        {
            days[row + 1][col] = index + 1;
            dfs(row + 1, col, grid, visited, index + 1, days);
        }

        if(row - 1 >= 0 && grid[row - 1][col] == 1 && index + 1 < days[row - 1][col])
        {
            days[row - 1][col] = index + 1;
            dfs(row - 1, col, grid, visited, index + 1, days);
        }

        if(col + 1 < n && grid[row][col + 1] == 1 && index + 1 < days[row][col + 1])
        {
            days[row][col + 1] = index + 1;
            dfs(row, col + 1, grid, visited, index + 1, days);
        }

        if(col - 1 >= 0 && grid[row][col - 1] == 1 && index + 1 < days[row][col - 1])
        {
            days[row][col - 1] = index + 1;
            dfs(row, col - 1, grid, visited, index + 1, days);
        }
    }
    public int orangesRotting(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int sum =0;
        boolean[][] visited = new boolean[m][n];
        int[][] days = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            Arrays.fill(days[i], Integer.MAX_VALUE);
        }
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    days[i][j]=0;
                    dfs(i,j,grid,visited,0,days);
                }
            }
        }
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               if(grid[i][j] == 1 && days[i][j] == Integer.MAX_VALUE)
                {
                    return -1;
                }
            }
        }
        int max=0;
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(days[i][j] != Integer.MAX_VALUE && (grid[i][j]==1 || grid[i][j]==2))
                {
                    max = Math.max(max, days[i][j]);
                }
            }
        }
        return max;
    }
}
