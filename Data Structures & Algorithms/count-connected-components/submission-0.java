class Solution 
{
    Queue<Integer> q = new LinkedList<>();
    void bfs(int start,boolean[] visited,int[][] adj)
    {
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty())
        {
            int temp = q.poll();
            for(int i=0;i<adj.length;i++)
            {
                if(adj[temp][i]==1 && !visited[i])
                {
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges)
    {
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
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                bfs(i,visited,adj);
                count++;
            }
        }
        return count;
    }
}
