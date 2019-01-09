package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

/**
 * Interface for a Bag object
 * @param <E> type of the elements in the bag
 */
public interface IBag<E> extends Iterable<E> {

    /**
     * Add the element to the bag
     * @param element to be added
     */
    void add(E element);

    /**
     * The size of the bag
     * @return the number of items in the bag
     */
    int size();

    /**
     * Checks if the IBag is empty
     * @return true if empty, false otherwise
     */
    boolean isEmpty();
}
