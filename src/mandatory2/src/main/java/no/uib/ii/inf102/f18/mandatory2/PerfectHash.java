package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public class PerfectHash {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), uHash = 0, a = 0, m;
        String[] words = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = io.getWord();

        for (m = n; m <= 500; m++) {
            for (a = 2; a <= 340; a++) {
                boolean[] hashes = new boolean[m];
                for (uHash = 0; uHash < n; uHash++) {
                    int currHash = hash(words[uHash], a, m);
                    if (!hashes[currHash])
                        hashes[currHash] = true;
                    else break;
                }
                if (uHash == n) break;
            }
            if (uHash == n) break;
        }

        io.print(a + " " + m);
        io.close();
    }

    public static int hash(String s, int a, int m) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = (a * hash + s.charAt(i)) % m;
        return hash;
    }
}

/*
    2 Hi ha

    2 3
*/
