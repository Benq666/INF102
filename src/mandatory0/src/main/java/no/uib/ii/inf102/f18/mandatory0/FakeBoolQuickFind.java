package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

public class FakeBoolQuickFind {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(), m = io.getInt();
        MyQuickFindUF uf = new MyQuickFindUF(n);

        for (int i = 0; i < m; i++)
            uf.union(io.getInt(), io.getInt());

        for (int i = 0; i < n; i++)
            sb.append(uf.find(i)).append(" ");

        io.print(sb);
        io.close();
    }
}

// 6 3
// 3 1
// 4 5
// 0 5

// 0 1 2 1 0 0