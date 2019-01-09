package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * A directed graph where vertices are represented by
 * integers that represent strings via hashing
 */
public class SymbolDirGraph {
    private ChainHashTable<String, Integer> hashTable;
    private String[] keys;
    private MyAdjListDirGraph graph;

    public SymbolDirGraph(String[] input, String delimiter) {
        hashTable = new ChainHashTable<String, Integer>();

        // first pass
        for (String line : input) {
            String[] words = line.split(delimiter);
            for (String word : words)
                if (!hashTable.containsKey(word))
                    hashTable.put(word, hashTable.size());
        }

        // inverted index
        keys = new String[hashTable.size()];
        for (String name : hashTable.keys())
            keys[hashTable.get(name)] = name;

        // second pass
        graph = new MyAdjListDirGraph(hashTable.size());
        for (String line : input) {
            String[] words = line.split(delimiter);
            int s = hashTable.get(words[0]);
            for (int i = 1; i < words.length; i++) {
                int t = hashTable.get(words[i]);
                graph.addEdge(s, t);
            }
        }
    }

    /**
     * Returns the integer associated with the vertex.
     * @param s the name of a vertex
     * @return the integer associated with the vertex
     */
    public int indexOf(String s) {
        return hashTable.get(s);
    }

    /**
     * Returns the name of the vertex associated with the integer.
     * @param u the integer corresponding to a vertex
     * @return the name of the vertex associated with the integer
     */
    public String nameOf(int u) {
        validateVertex(u);
        return keys[u];
    }

    /**
     * Returns the digraph associated with the symbol graph.
     * @return the digraph associated with the symbol digraph
     */
    public MyAdjListDirGraph digraph() {
        return graph;
    }

    private void validateVertex(int u) {
        if (u < 0 || u >= graph.n())
            throw new IllegalArgumentException("vertex " + u + " is out of bounds!");
    }
}
