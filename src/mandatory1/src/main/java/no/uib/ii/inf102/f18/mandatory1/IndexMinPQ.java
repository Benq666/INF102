package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

//import java.util.Iterator;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings("unchecked")
public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
    private int size;
    private int[] pq, qp;
    private Key[] keys;

    public IndexMinPQ(int maxSize) {
        if (maxSize < 0)
            throw new IllegalArgumentException("Size must be >= 0");

        size = 0;
        keys = (Key[]) new Comparable[maxSize + 1];
        pq = new int[maxSize + 1];
        qp = new int[maxSize + 1];

        for (int i = 0; i <= maxSize; i++)
            qp[i] = -1;
    }

    @Override
    public void add(int index, Key key) {
        if (contains(index))
            throw new IllegalArgumentException(
                    "The index " + index + " is already associated with the key " + keys[index]);
        size++;
        qp[index] = size;
        pq[size] = index;
        keys[index] = key;
        swim(size);
    }

    @Override
    public void changeKey(int index, Key key) {
        checkIndex(index);
        keys[index] = key;
        swim(qp[index]);
        sink(qp[index]);
    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        int origIndex = qp[index];
        swap(origIndex, size--);
        swim(origIndex);
        sink(origIndex);

        keys[index] = null;
        qp[index] = -1;
    }

    @Override
    public Key getKey(int index) {
        checkIndex(index);
        return keys[index];
    }

    @Override
    public int poll() {
        int min = pq[1];
        swap(1, size--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        return min;
    }

    @Override
    public Key peekKey() {
        return keys[pq[1]];
    }

    @Override
    public int peek() {
        return pq[1];
    }

    @Override
    public boolean contains(int index) {
        return qp[index] != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void checkIndex(int index) {
        if (!contains(index) && keys[index] != null)
            throw new IllegalArgumentException(
                    "There is no such index (" + index + ") in the PQ");
    }

    /*@Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Key next() {
                return null;
            }
        };
    }*/
}
