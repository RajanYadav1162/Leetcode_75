
/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 */

// Solution idea
/*
 * We can solve this by maintaining three pointer, prev, current and nex.(not using next, because its already a field in ListNode class)
 * 1. simply iterate and do the pointer movement.
 * 2. step-1[1-->2-->3-->...], initailly prev(null)--> 1-->2-->3, current=2, nex=3, change (1-->2) to 1-->prev(null)
 * 3. then make prev as current and current as nex and nex as nex.next;
 */

class Solution {
  public ListNode reverseList(ListNode head) {

    if (head == null)
      return head;

    ListNode prev = null, current = head, nex = head.next;

    while (current != null) {
      current.next = prev;
      prev = current;
      current = nex;
      if (nex != null)
        nex = nex.next;
    }

    return prev;
  }
}
