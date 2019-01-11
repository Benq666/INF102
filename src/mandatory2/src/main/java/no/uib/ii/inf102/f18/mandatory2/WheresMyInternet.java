package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Where's My Internet??
 * https://uib.kattis.com/problems/wheresmyinternet
 *
 * A new town is being built far out in the country, and currently there are N houses. People have already started
 * moving in. However, some of the houses aren’t connected to the internet yet, and naturally residents are outraged.
 * The houses are numbered 1 to N. House number 1 has already been connected to the internet via a long network cable
 * to a neighboring town. The plan is to provide internet to other houses by connecting pairs of houses with separate
 * network cables. A house is connected to the internet if it has a network cable to another house that’s already
 * connected to the internet.
 * Given a list of which pairs of houses are already connected by a network cable, determine which houses are not yet
 * connected to the internet.
 *
 * Input
 * The first line of input contains two integers 1≤N,M≤200000, where N is the number of houses and M is the number of
 * network cables already deployed. Then follow M lines, each containing a pair of house numbers 1≤a,b≤N meaning that
 * house number a and house number b are already connected by a network cable. Each house pair is listed at most once
 * in the input.
 *
 * Output
 * If all the houses are already connected to the internet, output one line containing the string Connected. Otherwise,
 * output a list of house numbers in increasing order, one per line, representing the houses that are not yet connected
 * to the internet.
 *
 *
 * Solved by Andrey Belinskiy
 *
 */
public class WheresMyInternet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), m = io.getInt();
        boolean allConnected = true;
        IGraph graph = new MyAdjListGraph(n + 1);
        for (int i = 0; i < m; i++)
            graph.addEdge(io.getInt(), io.getInt());

        DepthFirstPaths search = new DepthFirstPaths(graph, 1);
        boolean[] visited = search.getVisited();

        for (int i = 2; i <= n; i++)
            if (!visited[i]) {
                io.print(i + "\n");
                allConnected = false;
            }

        if (allConnected) io.print("Connected\n");
        io.close();
    }
}
/*
Sample Input 1:
6 4
1 2
2 3
3 4
5 6

Sample Output 1:
5
6

Sample Input 2:
2 1
2 1

Sample Output 2:
Connected

Sample Input 3:
4 3
2 3
4 2
3 4

Sample Output 3:
2
3
4
*/
