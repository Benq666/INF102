package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

public class MyQuickUnionUF implements IUnionFind {
    private int[] id;

    public MyQuickUnionUF(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int idP = find(p), idQ = find(q);

        if (idP == idQ)
            return;

        if (id[idP] < id[idQ])
            id[idQ] = idP;
        else
            id[idP] = id[idQ];
    }

    public int find(int p) {
        if (id[p] == p)
            return p;

        id[p] = find(id[p]);
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
