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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode head=null;
        ListNode temp =null;
        int carry=0;
        int digit=0;
        while(l1!=null && l2!=null)
        {
            int sum = l1.val+l2.val+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode node = new ListNode(digit);
            if(head==null)
            {
                head=node;
                temp=node;
            }
            else
            {
                temp.next=node;
                temp=temp.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int sum = l1.val+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode node = new ListNode(digit);
            if(head==null)
            {
                head=node;
                temp=node;
            }
            else
            {
                temp.next=node;
                temp=temp.next;
            }
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum = l2.val+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode node = new ListNode(digit);
            if(head==null)
            {
                head=node;
                temp=node;
            }
            else
            {
                temp.next=node;
                temp=temp.next;
            }
            l2=l2.next;
        }
        if(carry>0)
        {
            ListNode rem = new ListNode(carry);
            temp.next=rem;
        }
        return head;
    }
}
