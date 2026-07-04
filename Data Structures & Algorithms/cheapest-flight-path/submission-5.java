//in dikstras we dont maintain visited array instead visited array
//and we check for k+1 because excluding destianion
class Solution 
{
    class triplet
    {
        int node;
        int dist;
        int stops;
        triplet(int node,int dist,int stops)
        {
            this.node=node;
            this.dist=dist;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        int[][] adj = new int[n][n];
        for(int i=0;i<adj.length;i++)
        {
            Arrays.fill(adj[i],-1);
        }
        for(int i=0;i<flights.length;i++)
        {
            int from = flights[i][0];
            int to = flights[i][1];
            int wt = flights[i][2];
            adj[from][to]=wt;
        }
        PriorityQueue<triplet> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new triplet(src,0,0));
        // CHANGE

        int[][] distance = new int[n][k+2];

        // CHANGE

        for(int i=0;i<n;i++)

            Arrays.fill(distance[i],Integer.MAX_VALUE);

        // CHANGE

        distance[src][0]=0;
        while(!pq.isEmpty())
        {
            triplet top = pq.poll();
            int node = top.node;
            int dist = top.dist;
            int stops = top.stops;

            if(node == dst)
            return dist;

            if(stops == k+1)
            continue;
            
            for(int i=0;i<n;i++)
            {
                if(adj[node][i] == -1)
                    continue;

                int newCost = dist + adj[node][i];

                if(newCost < distance[i][stops+1])
                {
                    distance[i][stops+1] = newCost;
                    pq.offer(new triplet(i,newCost,stops+1));
                }
            }
        }
        return -1;
    }
}