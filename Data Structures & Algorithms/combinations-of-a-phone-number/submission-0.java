class Solution 
{
    List<String> res = new ArrayList<>();
    void backtrack(Map<Character,String> map,int index,String digits,StringBuilder sb)
    {
        if(index==digits.length())
        {
            res.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(index));

        for(int j=0;j<str.length();j++)
        {
            sb.append(str.charAt(j));
            backtrack(map,index+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0)
        return res;

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        StringBuilder sb = new StringBuilder();
        backtrack(map,0,digits,sb);

        return res;
    }
}
