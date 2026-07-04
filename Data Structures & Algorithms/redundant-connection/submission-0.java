class Solution 
{
    int[] parent;
    int[] rank;
    int find(int x)
    {
        if(parent[x]==x)
        return x;

        return find(parent[x]);
    }
    int[] union(int a,int b)
    {
        int parA = find(a);
        int parB = find(b);

        if(parA==parB)
        return new int[]{a,b};

        if(rank[parA]>rank[parB])
        {
            parent[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]==rank[parB])
        {
             parent[parB]=parA;
            rank[parA]++;
        }
        else
        {
            parent[parA]=parB;
            rank[parB]++;
        }

        return new int[]{-1,-1};
    }
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        int ans[] = new int[2];
        for(int[] edge:edges)
        {
            int a = edge[0];
            int b = edge[1];
            ans = union(a,b);
            if(ans[0]!=-1 && ans[1]!=-1)
            {
                return ans;
            }
        }
        return ans;
    }
}
