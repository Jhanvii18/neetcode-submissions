// we use smalller array cause easier to apply bonary serach
class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int[] smaller = nums1.length>nums2.length? nums2 : nums1;
        int[] larger = nums1.length>nums2.length? nums1:nums2;

        int low = 0;
        int high = smaller.length;//cause jcuts are immaginary
        int total = nums1.length+nums2.length;

        while(low<=high)
        {
            int cut1 = (low+high)/2;
            int cut2 = (total+1)/2-cut1;

            int l1 = cut1==0? Integer.MIN_VALUE : smaller[cut1-1];

            int r1 = cut1==smaller.length? Integer.MAX_VALUE:smaller[cut1];

            int l2 = cut2==0? Integer.MIN_VALUE:larger[cut2-1];

            int r2 = cut2==larger.length? Integer.MAX_VALUE: larger[cut2];

            if(l1<=r2 && l2<=r1)//less than equal
            {
                if(total%2!=0)
                {
                    return Math.max(l1,l2);
                }
                else
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2)
            {
                high=cut1-1;
            }
            else
            {
                low=cut1+1;
            }
        }
        return -1;
    }
}
