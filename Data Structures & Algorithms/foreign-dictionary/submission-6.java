class Solution 
{
    String topo(List<List<Integer>> graph,int[] indegree,boolean[] present)
    {
        Queue<Integer> q = new LinkedList<>();
        String ans="";
         int totalPresent = 0; 
        for(int i=0;i<indegree.length;i++)
        {
            if(present[i]) totalPresent++;
            if(indegree[i]==0 && present[i]==true)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int temp = q.poll();
            ans=ans+((char)(temp+'a'));
            for(int i=0;i<graph.get(temp).size();i++)
            {
                int node = graph.get(temp).get(i);
                indegree[node]--;
                if(indegree[node]==0)
                {
                    q.offer(node);
                }
            }
        }
         if(ans.length() != totalPresent) return "";
        return ans;
    }
    public String foreignDictionary(String[] words) 
    {
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < 26; i++)
        {
            graph.add(new ArrayList<>());
        }
         for(String w : words)
        {
            for(char c : w.toCharArray())
            {
                present[c - 'a'] = true;
            }
        }
       for(int i=0;i<words.length-1;i++)
       {
            String s1 = words[i];
            String s2 = words[i+1];
            int k=0;
            int l=0;

            while(k < s1.length() && l < s2.length() && s1.charAt(k) == s2.charAt(l))
            {
                k++;
                l++;
            }

            if(s1.length()>s2.length() && s1.startsWith(s2))
            return "";

            if(k < s1.length() && l < s2.length())
            {
                int u = s1.charAt(k) - 'a';
                int v = s2.charAt(l) - 'a';

                present[u] = true;
                present[v] = true;

                if(!graph.get(u).contains(v))
                {
                    graph.get(u).add(v);
                    indegree[v]++;
                }
            }
       }
       return topo(graph,indegree,present);
    }
}
