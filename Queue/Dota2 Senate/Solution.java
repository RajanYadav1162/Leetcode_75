import java.util.*;

/*
 * In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

 

Example 1:

Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
Example 2:

Input: senate = "RDD"
Output: "Dire"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 
 */

//Solution idea
/*
 * This one is tricky.
 1. If observe carefully, we find out that, Dire/Radient whoever comes first, can ban any opposite candiate for current as well as all the upcoming rounds.
 2. And order by which these senators comes also matter, (Queue)
 3. so what we are going to do is, we maintain two queue(to maintain order of votes), whoever comes first(R/D) will get ban/removed from further voting.
 4. we will keep doing it, until either one of it get exhauseted.
 */
class Solution {
  public String predictPartyVictory(String s) {

    Queue<Integer> D = new LinkedList<>(), R = new LinkedList<>();

    // this will help us to track who comes first.
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'D') {
        D.offer(i);
      } else
        R.offer(i);
    }

    while (!D.isEmpty() && !R.isEmpty()) {
      int f = D.poll(), l = R.poll();

      // meaning Dire(D) comes first in voting, so Dire can ban any of the Radient.
      // so we are not going to push Radient since we already remove it, we are only
      // to put Dire, with updated index such that it comes after current round.
      if (f < l) {
        D.offer(f + s.length());

      }
      // similar to above explanation, if 'R' comes first, we need to remove 'D', and
      // add 'R' with updated index
      else {
        R.offer(l + s.length());
      }

    }

    return D.isEmpty() ? "Radiant" : "Dire";

  }
}
