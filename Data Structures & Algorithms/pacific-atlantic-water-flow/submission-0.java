//The only difference between Pacific and Atlantic is where DFS starts, not the directions it can move.
class Solution
{
    void dfs(int row,int col,boolean[][] visited,int[][] heights)
    {
        int m = heights.length;
        int n = heights[0].length;
        visited[row][col]=true;
        if(row-1>=0 && heights[row-1][col]>=heights[row][col] && !visited[row-1][col])
        {
            dfs(row-1,col,visited,heights);
        }
        if(col-1>=0 && heights[row][col-1]>=heights[row][col] && !visited[row][col-1])
        {
            dfs(row,col-1,visited,heights);
        }
        if(row+1<m && heights[row+1][col]>=heights[row][col] && !visited[row+1][col])
        {
            dfs(row+1,col,visited,heights);
        }
        if(col+1<n && heights[row][col+1]>=heights[row][col] && !visited[row][col+1])
        {
            dfs(row,col+1,visited,heights);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        boolean[][] v_a = new boolean[m][n];
        boolean[][] v_p = new boolean[m][n];
        // Atlantic
        for(int i=0;i<m;i++)
        {
            if(!v_a[i][n-1])
                dfs(i,n-1,v_a,heights);
        }

        for(int i=0;i<n;i++)
        {
            if(!v_a[m-1][i])
                dfs(m-1,i,v_a,heights);
        }

        // Pacific
        for(int i=0;i<n;i++)
        {
            if(!v_p[0][i])
                dfs(0,i,v_p,heights);
        }

        for(int i=0;i<m;i++)
        {
            if(!v_p[i][0])
                dfs(i,0,v_p,heights);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(v_a[i][j] && v_p[i][j])
                {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}
