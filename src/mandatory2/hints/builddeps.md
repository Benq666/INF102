### Hint: builddeps

In the problem [builddeps](https://uib.kattis.com/problems/builddeps)
the input is a list of build dependencies for different code libraries; if 
a library `x` depends on a library `y` (written as `x: y`), then, if a change
was made in `y`, the library `x` must be recompiled after `y` was compiled in
order to reflect the change. Furthermore, any program depinding on `x` must
also be recompiled, and so forth.

We can model the dependencies as a directed graph where there is an edge from
package `y` to package `x` if `x` depends on `y`; in this graph, everything 
reachable by a search from the changed file will need to be recompiled, but
the order is not arbitrary: we need to linearize the directed acyclic graph
(see week41-02 in the [slides from lecture](https://mitt.uib.no/courses/12780/files/folder/lecturenotes)).

You also need to handle that vertices are not by default numbers, but rather represented as strings. You
need to make some translation scheme, for instace via a symbol table (e.g. a HashMap).
The book discuss in detail how to do this in section 4.1 Symbol Graphs (page 548).
