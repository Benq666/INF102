package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

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

// 6
// my 5
// horrible 2
// bike 6
// A 1
// man 3
// ate 4

// A horrible man ate my bike
