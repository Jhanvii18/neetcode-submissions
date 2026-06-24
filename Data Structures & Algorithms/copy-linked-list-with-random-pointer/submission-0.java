/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution 
{
    public Node copyRandomList(Node head) 
    {
        if(head == null)
        {

            return null;
        }

        Node curr = head;
        while(curr!=null)
        {
            Node newnode = new Node(curr.val);
            newnode.next=curr.next;
            curr.next=newnode;
            curr=newnode.next;
        }

        curr = head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;
            }
            curr= curr.next.next;
        }

        Node newhead = head.next;
        Node ret = head.next;
        while(head!=null)
        {
            head.next=newhead.next;
            head= head.next;
            if(newhead.next!=null)
            {
                newhead.next=head.next;
                newhead=newhead.next;
            }
        }

        return ret;
    }
}
