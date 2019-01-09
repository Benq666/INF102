### Hint: grid

In the [grid](https://uib.kattis.com/problems/grid) problem,
the input is a grid where you can move vertically or horizontally
in the grid with steps of a given size, and we are asked to find
the fewest number of steps required to move from the top-left
corner to the bottom-right corner.

We can model the problem as a graph where each `(row, col)` -coordinate
represents a vertex, and there is a directed edge from a vertex `u`
to another vertex `v` if one can move from the location represented
by `u` to the location represented by `v` in one step.

There are multiple ways of approaching this model; one approach is
to explicitly construct the directed unweighted graph (e.g. an object of type `AdjListDigraph` from the [lecture notes](https://github.com/torsteins/inf102f18-lectures/blob/master/src/week41/AdjListDigraph.java)). We can for instance use the convention that location `(row, col)` represents vertex
`i = row * columns + col` (in which case, we can easily map backwards
as well: `row = i / columns` and `col = i % columns`).

To add edges to the graph, we know that a location `(row, col)`
containg the number `x` in the grid at that postion will have at most
four out-neighbours (i.e. positions we can go to - we can calculate them easily
if we work with 2-dimensinal points, then we convert to vertex numbers afterwards).
Iterate over every location `(row, col)`, and add those
four edges (except, of course, edges that point to a location off the grid).

Now that the graph is constructed, what remains is to initiate a breath-first search
(BFS) at vertex `0` (representing location `(0, 0)`), and then ask what is the
distances to vertex `rows * columns - 1` (representing location `(rows-1, columns-1)`).
