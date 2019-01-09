package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public interface IQueue<E> extends Iterable<E> {

    /**
     * Checks if the queue is empty.
     * @return true if empty, false otherwise
     */
    boolean empty();

    /**
     * Remove and return the first element of the queue.
     * @return first element
     */
    E dequeue();

    /**
     * Return the first element of the queue without removing it.
     * @return first element
     */
    E peek();

    /**
     * Add an element to the queue.
     * @param item an element to add
     */
    void enqueue(E item);
}
