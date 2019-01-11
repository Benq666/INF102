package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Bumped!
 * https://uib.kattis.com/problems/bumped
 *
 * Peter returned from the recently held ACM ICPC World Finals only to find that his return flight was overbooked and
 * he was bumped from the flight! Well, at least he wasn’t beat up by the airline and he’s received a voucher for one
 * free flight between any two destinations he wishes.
 * He is already planning next year’s trip. He plans to travel by car where necessary, but he may be using his free
 * flight ticket for one leg of the trip. He asked for your help in his planning.
 * He can provide you a network of cities connected by roads, the amount it costs to buy gas for traveling between
 * pairs of cities, and a list of available flights between some of those cities. Help Peter by finding the minimum
 * amount of money he needs to spend to get from his hometown to next year’s destination!
 *
 * Input
 * The input consists of a single test case. The first line lists five space-separated integers n, m, f, s, and t,
 * denoting the number of cities n (0<n≤50000), the number of roads m (0≤m≤150000), the number of flights f (0≤f≤1000),
 * the number s (0≤s<n) of the city in which Peter’s trip starts, and the number t (0≤t<n) of the city Peter is trying
 * to travel to. (Cities are numbered from 0 to n−1.)
 * The first line is followed by m lines, each describing one road. A road description contains three space-separated
 * integers i, j, and c (0≤i,j<n,i≠j and 0<c≤50000), indicating there is a road connecting cities i and j that costs c
 * cents to travel. Roads can be used in either direction for the same cost. All road descriptions are unique.
 * Each of the following f lines contains a description of an available flight, which consists of two space-separated
 * integers u and v (0≤u,v<n, u≠v) denoting that a flight from city u to city v is available (though not from v to u
 * unless listed elsewhere). All flight descriptions are unique.
 *
 * Output
 * Output the minimum number of cents Peter needs to spend to get from his home town to the competition, using at most
 * one flight. You may assume that there is a route on which Peter can reach his destination.
 *
 *
 * @author Andrey Belinskiy
 * (almost solved, currently passes only 22 out of 25 test cases)
 *
 */
public class Bumped {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(), m = io.getInt(), f = io.getInt();
        int s = io.getInt(), t = io.getInt();
        MyAdjListEdgeWD graph = new MyAdjListEdgeWD(n);

        for (int i = 0; i < m; i++) {
            int from = io.getInt(), to = io.getInt();
            double weight = io.getDouble();

            graph.addEdge(new DirectedEdge(from, to, weight));
            graph.addEdge(new DirectedEdge(to, from, weight));
        }

        graph.switchToRoadsFlights();

        for (int i = 0; i < f; i++)
            graph.addEdgeFlight(new DirectedEdge(io.getInt(), io.getInt(), 0.0, true));

        DijkstraShortestPaths paths = new DijkstraShortestPaths(graph, s);

        io.print((long) paths.distTo(t) + "\n");
        io.flush();
    }
}

/*
Sample Input 1:
8 11 1 0 5
0 1 10
0 2 10
1 2 10
2 6 40
6 7 10
5 6 10
3 5 15
3 6 40
3 4 20
1 4 20
1 3 20
4 7

Sample Output 1:
45

Sample Input 2:
8 11 1 0 5
0 1 10
0 2 10
1 2 10
2 6 40
6 7 10
5 6 10
3 5 15
3 6 40
3 4 20
1 4 20
1 3 30
4 7

Sample Output 2:
50
 */
