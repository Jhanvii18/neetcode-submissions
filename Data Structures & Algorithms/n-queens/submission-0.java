//intitution Rows are fixed.
//Columns are choices.
//Place one queen per row.
//Check only upwards.

class Solution 
{
    List<List<String>> res = new ArrayList<>();
    boolean isSafe(int row,int col,char[][] board,int n)
    {
        //column-wise check
        for(int i =0;i<row;i++)
        {
            if(board[i][col]=='Q')
            return false;
        }

        //right diagonal
        int right = row-1;
        int left = col-1;
        while(right>=0 && left>=0)
        {
            if(board[right][left]=='Q')
            return false;

            right--;
            left--;
        }

        //left
        right=row-1;
        left=col+1;
        while(right>=0 && left<n)
        {
            if(board[right][left]=='Q')
            return false;

            right--;
            left++;
        }
        return true;
    }
    void NQueens(int n,int row,char[][] board)
    {
        if(row==n)
        {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                temp.add(new String(board[i]));
            }
            res.add(temp);
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,board,n))
            {
                board[row][col]='Q';
                NQueens(n,row+1,board);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) 
    {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        NQueens(n,0,board);
        return res;
    }
}
