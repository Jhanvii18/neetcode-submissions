//we use mst
// treat every point as a node
class Solution 
{
    class triplet
    {
        int node;
        int parent;
        int dist;
        triplet(int node,int parent,int dist)
        {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<triplet> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new triplet(0,-1,0));
        int sum =0;
        while(!pq.isEmpty())
        {
            triplet top = pq.poll();
            int node = top.node;
            int parent = top.parent;
            int dist = top.dist;
            if(visited[node]) continue;
            visited[node] = true;
            sum = sum + dist;
            //calc dist for all nodes
            for(int i=0;i<n;i++)
            {
                if(i==parent) continue;
                if(visited[i]) continue;
                if(i==node) continue;
                int x1 = points[node][0];
                int y1 = points[node][1];
                int x2 = points[i][0];
                int y2 = points[i][1];
                int mandist = Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.offer(new triplet(i,node,mandist));
            }
        }
        return sum;
    }
}
