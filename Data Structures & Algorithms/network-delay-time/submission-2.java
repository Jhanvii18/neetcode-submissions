class pair
{
    int dist;
    int node;
    pair(int dist,int node)
    {
        this.dist=dist;
        this.node=node;
    }
}
class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new pair(0,k));

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) 
        {
            Arrays.fill(graph[i], -1);
        }
        for(int i =0;i<times.length;i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph[u][v]=w;
        }

        while(!pq.isEmpty())
        {
           pair curr = pq.poll();

            int currDist = curr.dist;
            int node = curr.node;

            if (currDist > dist[node])
            continue;

            for (int i = 1; i <= n; i++)
            {
                if (graph[node][i] != -1)
                {
                    if (currDist + graph[node][i] < dist[i])
                    {
                        dist[i] = currDist + graph[node][i];
                        pq.offer(new pair(dist[i], i));
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
