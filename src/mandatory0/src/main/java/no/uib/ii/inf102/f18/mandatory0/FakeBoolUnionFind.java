package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

public class FakeBoolUnionFind {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(), m = io.getInt();
        MyQuickUnionUF uf = new MyQuickUnionUF(n);

        for (int i = 0; i < m; i++) {
            if (io.getWord().equals("DAEMON"))
                uf.union(io.getInt(), io.getInt());
            else {
                io.println(uf.find(io.getInt()));
                io.flush();
            }
        }

        io.close();
    }
}

// 5 7
// LEGAL 1
// DAEMON 0 1
// LEGAL 1
// DAEMON 1 2
// DAEMON 4 3
// LEGAL 2
// LEGAL 3

// 1
// 0
// 0
// 3
