### Hint: wheresmyinternet

In [wheresmyinternet](https://uib.kattis.com/problems/wheresmyinternet),
the input is a graph on vertices named `1 2 3 ... n`, and the objective
is to list all vertices that are not reachable from vertex `1`.

The first obstacle is that the vertices are 1-indexed, rather than the 
0-indexing we normally use. One approach is to subtract `1` from
every vertex as we read it in, and add `1` every time we print it out. An
alternative approach is to create a graph with `n+1` vertices, and simply
ignore vertex `0` of the graph.

Either way, the problem is solved by BFS or DFS; start a search at vertex 1.
Then iterate over all the vertices, and print any that was not connected;
if there were none, print "Connected".
