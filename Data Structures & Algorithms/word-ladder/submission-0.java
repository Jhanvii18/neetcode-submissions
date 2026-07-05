class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashSet<String> set = new HashSet<>(wordList);
        int c=0;
        HashSet<String> visited = new HashSet<>();
        while(!q.isEmpty())
        {
            c++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String temp = q.poll();

                if(temp.equals(endWord))
                return c;

                for(int j=0;j<temp.length();j++)
                {
                    char[] ch = temp.toCharArray();
                    for(char k='a';k<='z';k++)
                    {
                        ch[j]=k;
                        String newstring = new String(ch);
                        if(set.contains(newstring) && !visited.contains(newstring))
                        {
                            q.offer(newstring);
                            visited.add(newstring);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
