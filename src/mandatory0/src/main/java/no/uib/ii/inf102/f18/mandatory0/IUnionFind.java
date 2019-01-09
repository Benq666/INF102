package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

public interface IUnionFind {
    /**
     * Add a connection between item p and item q
     *
     * @param p the item
     * @param q the item
     */
    void union(int p, int q);


    /**
     * Find the "component identifier" of item p
     *
     * @param p the item
     * @return component identifier of item p
     */
    int find(int p);


    /**
     * Returns true if items p and q are connected either directly or indirectly
     * through some path.
     *
     * @param p an item
     * @param q an item
     * @return true if items p and q are connected, false otherwise
     */
    boolean connected(int p, int q);
}
