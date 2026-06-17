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
    public ListNode reverseList(ListNode head) 
    {
        ListNode currentnode = head;
        ListNode nextnode = head;
        ListNode prevnode =null;
        while(nextnode!=null)
        {
            nextnode=nextnode.next;
            currentnode.next=prevnode;
            prevnode=currentnode;
            currentnode=nextnode;
        }
        head=prevnode;
        return head;
    }
}
