class Solution 
{
    int dist (int x,int y)
    {
        return x*x+y*y;
    }
    public int[][] kClosest(int[][] points, int k) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->dist(a[0],a[1])-dist(b[0],b[1]));
        for(int[] point:points)
        {
            pq.add(point);
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++)
        {
            res[i]=pq.poll();
        }
        return res;
    }
}
