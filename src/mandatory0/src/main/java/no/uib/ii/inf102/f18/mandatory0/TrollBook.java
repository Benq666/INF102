package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

/**
 * Troll Book
 * https://uib.kattis.com/problems/uib.trollbook
 *
 * A team of archaeologists have just done an amazing discovery underneath the ancient Arkadiko Bridge. They found
 * the pages of the oldest book ever discovered! They immediately concluded it was a troll book since there was only
 * one word on each page (which, frankly, made the discovery even more thrilling). Now, they are working to figure out
 * what the book actually says.
 * Since the pages of the book are all spread out, it is not immediately clear in what order they should be read;
 * fortunately, however, each page is marked with a page number. You have been recruited to put the pages in order so
 * the archaeologists can read what the book says.
 *
 * Input
 * The first line contains a single integer n, the number of pages. Then follows n lines, one for each page;
 * the i’th such line consists of a single word wi, the word on the page, and an integer pi, the page number.
 *
 * Constraints
 * 1≤n≤100000
 * 1≤|wi|≤8
 * 1≤pi≤n
 *
 * Output
 * Output a single line with the entire contents of the book in the proper order.
 *
 *
 * @author Andrey Belinskiy
 *
 */
public class TrollBook {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        SortableLinkedList<String> ll = new SortableLinkedList<String>();

        int n = io.getInt();

        for (int i = 0; i < n; i++)
            ll.add(io.getWord(), io.getInt());

        ll.sort();

        for (String elem : ll)
            io.print(elem + " ");

        io.close();
    }
}

/*
Sample Input 1:
6
my 5
horrible 2
bike 6
A 1
man 3
ate 4

Sample Output 1:
A horrible man ate my bike
 */