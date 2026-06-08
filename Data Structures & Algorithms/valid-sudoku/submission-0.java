class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        for(int i =0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
            for(int j =0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!set.contains(board[i][j]))
                    {
                        set.add(board[i][j]);
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        for(int i =0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
            for(int j =0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                    if(!set.contains(board[j][i]))
                    {
                        set.add(board[j][i]);
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        //to check 3*3 types thingy
        for(int r = 0 ;r< 9;r=r+3)
        {
            for(int c=0;c<9;c=c+3)
            {
                Set<Character> set = new HashSet<>();
                for(int boxr =r;boxr<r+3;boxr++)
                {
                    for(int boxc=c;boxc<c+3;boxc++)
                    {
                        if(board[boxr][boxc]!='.')
                        {
                            if(!set.contains(board[boxr][boxc]))
                            {
                                set.add(board[boxr][boxc]);
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
