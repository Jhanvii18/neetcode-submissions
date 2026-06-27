class Solution 
{
    void dfs(int start,boolean[] visited,int[][] adj)
    {
        int m=adj.length;
        visited[start]=true;
        for(int i=0;i<m;i++)
        {
            if(adj[start][i]==1 && !visited[i])
            {
                dfs(i,visited,adj);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) 
    {
        if(edges.length != n-1)
        return false;
        
        boolean[] visited = new boolean[n];
        int m = edges.length;
        int[][] adj = new int[n][n];
        for(int i=0;i<m;i++)
        {
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from][to]=1;
            adj[to][from]=1;
        }
        
        dfs(0,visited,adj);
    
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            return false;
        }
        return true;
    }
}
