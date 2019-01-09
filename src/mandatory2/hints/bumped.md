### Hint: bumped

In the [bumped](https://uib.kattis.com/problems/bumped) problem,
the input consists of a graph with two types of edges: undirected
"road" edges, and directed "flight" edges. The road edges have
non-negative weights, and all flight edges have zero weight.

The task is to find the shortest path from vertex `s` to
vertex `t`, which immidiately suggests using Dijkstra's algorithm.
We already know that an undirected edge is exactly the same as two
directed edges with the same weight pointing in different directions
between the same two vertices, so it might be a tempting idea to
simply throw all the edges together on the same graph.

However, this does not take into account the restriction that we may
only use a single flight edge in our path.

To model that we can only use a single flight edge, we could instead
do this: Create *two* "copies" of the road network within the same graph
object; then add the flight edges such that they all go from the first
copy (the "before the flight" -network) to the second copy (the "after the flight" -network).

Remember to also handle the case when it is best not to fly at all.

PS: Use the `long` type to hold distances in your dijkstra, `int` might overflow
(or, if you are using `double`, be careful with rounding when printing the answer).
