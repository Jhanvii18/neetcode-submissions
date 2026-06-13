int count =0;
int dfs(int i,int j,int[][] grid,boolean[][] visited)
{
    int m = grid.length;
    int n = grid[0].length;
    int row = i;
    int col = j;
    count++;
    visited[row][col]=true;
    if(row-1>=0 && !visited[row-1][col] && grid[row-1][col]==1)
    {
        dfs(row-1,col,grid,visited);
    }
    if(row+1<m && !visited[row+1][col] && grid[row+1][col]==1)
    {
        dfs(row+1,col,grid,visited);
    }
    if(col-1>=0 && !visited[row][col-1] && grid[row][col-1]==1)
    {
        dfs(row,col-1,grid,visited);
    }
    if(col+1<n && !visited[row][col+1] && grid[row][col+1]==1)
    {
        dfs(row,col+1,grid,visited);
    }
    return count;
}
class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int max=0;
        boolean[][] visited = new boolean[m][n];
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1&& !visited[i][j])
                {
                    count=0;
                    int no = dfs(i,j,grid,visited);
                    max=Math.max(max,no);
                }
            }
        }
        return max;
    }
}
