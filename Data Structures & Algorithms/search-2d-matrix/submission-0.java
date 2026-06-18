class Solution 
{
    int findrow(int[][] matrix, int target)
    {
        int low=0;
        int high=matrix.length-1;
        int n = matrix[0].length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n])
            {
                return mid;
            }
            else if(matrix[mid][0]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
    int findcol(int rowidx,int[][] matrix, int target)
    {
        int low = 0;
        int high = matrix[0].length;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(matrix[rowidx][mid]==target)
            return mid;

            else if(matrix[rowidx][mid]>target)
            high=mid-1;

            else
            low=mid+1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int store1 = findrow(matrix,target);

        if(store1 == -1)
        return false;

        int store2 = findcol(store1,matrix,target);

        if(store2==-1)
        return false;

        return true;
    }
}
