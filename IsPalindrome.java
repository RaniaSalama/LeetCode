/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode currentNode = head;
        while(currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        currentNode = head;
        int n = stack.size();
        while(stack.size() > n/2) {
            if(currentNode.val != stack.pop().val) {
                return false;
            }
            currentNode = currentNode.next;
        }
        return true;
    }
}
