/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution 
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null ||k==1)
        return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevgroupend = dummy;
        while(true)
        {
            ListNode kth = prevgroupend;
            for(int i=0;i<k && kth!=null;i++)
            {
                kth=kth.next;
            }
            if(kth==null) break;
            ListNode groupstart = prevgroupend.next;
            ListNode nextgroupstart = kth.next;

            //reversing
            ListNode curr= groupstart;
            ListNode prev = nextgroupstart;
            /*Because we are not reversing the whole linked list.
            We are reversing only one group, and after reversing that group, 
            its last node should still connect to the rest of the list.*/
            while(curr!=nextgroupstart)
            {
                ListNode temp = curr.next;
                curr.next= prev;
                prev=curr;
                curr=temp;
            }

            prevgroupend.next=kth;
            prevgroupend=groupstart;
        }
        return dummy.next;
    }
}
