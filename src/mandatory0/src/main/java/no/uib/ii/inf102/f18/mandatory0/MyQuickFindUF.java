package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

/**
 * @author Andrey Belinskiy
 */
public class MyQuickFindUF implements IUnionFind {
    private int[] id;

    public MyQuickFindUF(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int idP = find(p), idQ = find(q);

        if (idP == idQ)
            return;

        if (id[idP] > id[idQ]) {
            for (int i = 0; i < id.length; i++)
                if (id[i] == idP) id[i] = idQ;
        } else
            for (int i = 0; i < id.length; i++)
                if (id[i] == idQ) id[i] = idP;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
