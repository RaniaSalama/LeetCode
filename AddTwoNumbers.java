/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode add(ListNode l1, ListNode l2) {
        if(l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val);
        } else {
            ListNode node = add(l1.next, l2.next);
            int carry = node.val / 10;
            node.val = node.val % 10;
            ListNode currNode = new ListNode(l1.val + l2.val + carry);
            currNode.next = node;
            return currNode;
        }
    }
    
    public int getSize(ListNode node) {
        int size = 0;
        while(node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
    
    public ListNode append(ListNode l, int size1, int size2) {
        while(size1 > size2) {
            ListNode node = new ListNode(0);
            node.next = l;
            l = node;
            size2++;
        }
        return l;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        l1 = append(l1, size2, size1);
        l2 = append(l2, size1, size2);
    
        ListNode head = add(l1, l2);
        int carry = head.val / 10;
        head.val = head.val % 10;
        if(carry != 0) {
            ListNode extraHead = new ListNode(carry);
            extraHead.next = head;
            head = extraHead;
        }
        return head;
    }
}
//(7 -> 2 -> 4 -> 3) + (0 -> 5 -> 6 -> 4), carry = 1, 
// l1 = 7, l2 = 0 --> case 2, carry = 0, currNode(7) -> currNode(8) -> currNode(0) -> node(7)
// l1 = 2, l2 = 5 --> case 2, carry = 1, currNode(8) -> currNode(0) -> node(7)
// l1 = 4, l2 = 6 --> case 2, return currNode(10) -> node (7)
// l1 = 3, l2 = 4 --> case 1, return node (7)
// 
