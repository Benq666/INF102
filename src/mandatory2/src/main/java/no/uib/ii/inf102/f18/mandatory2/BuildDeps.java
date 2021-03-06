package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Build Dependencies
 * https://uib.kattis.com/problems/builddeps
 *
 * A Makefile is a file that specifies dependencies between different source code files. When one source code file
 * changes, this file needs to be recompiled, and when one or more dependencies of another file are recompiled, that
 * file needs to be recompiled as well. Given the Makefile and a changed file, output the set of files that need to be
 * recompiled, in an order that satisfies the dependencies (i.e., when a file X and its dependency Y both need to be
 * recompiled, Y should come before X in the list).
 *
 * Input
 * The input consists of:
 * one line with one integer n (1≤n≤100000), the number of Makefile rules;
 * n lines, each with a Makefile rule. Such a rule starts with “f:” where f is a filename, and is then followed by
 * a list of the filenames of the dependencies of f. Each file has at most 5 dependencies.
 * one line with one string c, the filename of the changed file.
 * Filenames are strings consisting of between 1 and 10 lowercase letters. Exactly n different filenames appear in
 * the input file, each appearing exactly once as f in a Makefile rule. The rules are such that no two files depend
 * (directly or indirectly) on each other.
 *
 * Output
 * Output the set of files that need to be recompiled, in an order such that all dependencies are satisfied.
 * If there are multiple valid answers you may output any of them.
 *
 *
 * @author Andrey Belinskiy
 *
 */
public class BuildDeps {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++)
            input[i] = io.getLine().replace(":", "");

        SymbolDirGraph sdg = new SymbolDirGraph(input, " ");

        MyAdjListDirGraph graph = sdg.digraph();
        graph = graph.reverse();

        String changedFile = io.getWord();
        int target = sdg.indexOf(changedFile);
        DepthFirstPaths dfs = new DepthFirstPaths(graph, target);

        for (int u : dfs.getOrder())
            io.print(sdg.nameOf(u) + "\n");

        io.flush();
    }
}

/*
Sample Input 1:
6
gmp:
solution: set map queue
base:
set: base gmp
map: base gmp
queue: base

Sample Output 1:
gmp
gmp
map
set
solution
 */
