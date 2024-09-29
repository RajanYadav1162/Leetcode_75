
import java.util.*;

/*
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

 

Example 1:

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]
 */

/*
 *1. we just need to maintain a queue that contains time that can be reachable, t + 3000.
 */

class RecentCounter {

  Deque<Integer> deque = new LinkedList<>();

  public RecentCounter() {

  }

  public int ping(int t) {
    // since input always come in sorted order, if something going out of bound, we
    // can simply remove from start of queue.
    // eg. [1, 300, 3001] this is good from 1---> we can reach to 30001.
    // but if [1, 300, 3001, 30002]--> now we can't reach 30002 from 1, so we need
    // to remove the 1.
    while (deque.size() > 0 && deque.peekFirst() + 3000 < t) {
      deque.pollFirst();
    }

    deque.offerLast(t);

    return deque.size();
  }
}
