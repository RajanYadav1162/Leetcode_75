/*
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 * 
 * 
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * 
 */

//optimised solution
/*
 * 1. if we look carefully, we can solve this in constant space.
   2. [1->2->3->4->5], if this is the list, odd will start from 1, and even start from 2.
   3. from odd we go to even.next for next odd, and vice-versa.
   4. at last connect both of them
 */

class Solution {
  public ListNode oddEvenList(ListNode head) {

    if (head == null || head.next == null)
      return head;

    // we need this markerhead for joining both the parts after all the reference
    // re-arrangement.
    ListNode evenHeadMarker = head.next, odd = head, even = head.next;

    while (even != null && even.next != null) {
      // even.next willpoint to next odd.
      odd.next = even.next;
      odd = odd.next;
      // odd.next will point to next even.
      even.next = odd.next;
      even = even.next;
    }

    // connect both of em.
    odd.next = evenHeadMarker;
    return head;
  }
}

// with O(n) extra space, basically creating node on the fly based on odd/even.
class Solution1 {
  public ListNode oddEvenList(ListNode head) {
    ListNode oh = new ListNode(0), eh = new ListNode(0);
    ListNode ot = oh, et = eh;
    int flag = 0;

    ListNode current = head;

    while (current != null) {
      if (flag == 0) {
        ot.next = new ListNode(current.val);
        ot = ot.next;
        flag = 1;

      } else {
        et.next = new ListNode(current.val);
        et = et.next;
        flag = 0;
      }
      current = current.next;
    }

    ot.next = eh.next;
    return oh.next;
  }
}
