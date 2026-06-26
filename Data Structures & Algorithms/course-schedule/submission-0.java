class Solution 
{
    List<Integer> ans = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree,0);
        boolean[] visited = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
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

        while(!q.isEmpty())
        {
            int node = q.poll();
            visited[node]=true;
            ans.add(node);
            for(int i =0;i<adj.get(node).size();i++)
            {
                int neigh = adj.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                {
                    q.offer(neigh);
                }
            }
        }

        if(ans.size()==numCourses)
        return true;

        else
        return false;
    }
}
