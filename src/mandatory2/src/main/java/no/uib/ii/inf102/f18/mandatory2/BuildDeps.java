package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

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
--------
6
gmp:
solution: set map queue
base:
set: base gmp
map: base gmp
queue: base
gmp

gmp
map
set
solution
--------
 */
