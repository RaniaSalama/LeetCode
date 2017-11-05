/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode currentNode = headA;
        while(currentNode != null) {
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        currentNode = headB;
        while(currentNode != null) {
            if(set.contains(currentNode))
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}
