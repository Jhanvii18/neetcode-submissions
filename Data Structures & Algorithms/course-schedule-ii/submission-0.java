class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i =0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<prerequisites.length;i++)
        {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            adj.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        int k=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans[k++]=node;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int neigh = adj.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.offer(neigh);
                }
            }
        }
        if(k != numCourses)
        {
            return new int[0];
        }
        return ans;
    }
}
