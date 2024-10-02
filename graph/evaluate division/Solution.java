
import java.util.*;

/*
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.


Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 */

//solution idea
/*
 * 1. think of equations as graph, if we have value for a/b and b/c, then simply multiplying will give a/c.
 */

record Pair(String v, double w) {
}

class Solution {
  private Map<String, List<Pair>> map = new HashMap<>();

  public double[] calcEquation(List<List<String>> E, double[] V, List<List<String>> Q) {

    build(E, V);

    // System.out.println(map);
    int n = Q.size();
    double[] ans = new double[n];
    for (int i = 0; i < n; i++) {
      String s = Q.get(i).get(0), d = Q.get(i).get(1);
      if (!map.containsKey(s)) {
        ans[i] = -1;
      } else {
        Set<String> set = new HashSet<>();
        ans[i] = dfs(s, d, 1.0, set);
      }
    }

    return ans;
  }

  public double dfs(String s, String d, double cp, Set<String> set) {

    // if we found a match, eg, s == d.
    if (s.equals(d))
      return cp;

    double res = -1.0;
    set.add(s);
    for (var nbh : map.get(s)) {
      String v = nbh.v();
      double w = nbh.w();
      if (set.contains(v))
        continue;
      // trying to find the answer from child(subproblem)
      double child = dfs(v, d, cp * w, set);
      if (child != -1)
        return child;
    }

    return res;
  }

  public void build(List<List<String>> E, double[] V) {

    for (int i = 0; i < V.length; i++) {
      String s = E.get(i).get(0), d = E.get(i).get(1);
      double v = V[i];

      // if we have [a, b] and V[2]. then a/b = 2 and b/a = 1/2.
      map.computeIfAbsent(s, k -> new ArrayList<>()).add(new Pair(d, v));
      map.computeIfAbsent(d, k -> new ArrayList<>()).add(new Pair(s, 1.0 / v));
    }
  }
}

