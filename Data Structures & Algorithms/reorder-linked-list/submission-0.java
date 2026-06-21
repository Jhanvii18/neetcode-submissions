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
    public void reorderList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;//remember

        //reversing
        ListNode curr=mid;
        ListNode nextn=mid;
        ListNode prev=null;
        while(nextn!=null)
        {
            nextn=nextn.next;
            curr.next=prev;
            prev=curr;
            curr=nextn;
        }

        //joining
        ListNode p2 = prev;
        ListNode p1 = head;

        while(p1!=null && p2!=null)
        {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next=p2;
            p2.next=t1;

            p1=t1;
            p2=t2;
        }
    }
}
