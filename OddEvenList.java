/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class OddEvenList {
    public void groupNodes(ListNode nodeOdd, ListNode nodeEven) {
        ListNode evenHead = nodeEven;
        ListNode prevNode = nodeOdd;
        while(nodeOdd != null && nodeOdd.next != null) {
            nodeOdd.next = nodeOdd.next.next;
            if(nodeEven != null && nodeEven.next != null)
                nodeEven.next = nodeEven.next.next;
            prevNode = nodeOdd;
            nodeOdd = nodeOdd.next;
            nodeEven = nodeEven.next;
        }
        if (nodeEven != null && nodeEven.next != null) {
            nodeEven.next = nodeEven.next.next;
        }
        if(nodeOdd != null) {
            nodeOdd.next = evenHead;
        } else {
            prevNode.next = evenHead;
        }
    }
    
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head;
        if(head == null)
            return null;
        ListNode evenHead = head.next;
        groupNodes(oddHead, evenHead);
        return oddHead;
    }
}
