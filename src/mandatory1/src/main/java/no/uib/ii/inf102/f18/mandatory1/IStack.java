package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

public interface IStack<E> {

    /**
     * Checks if the stack is empty.
     * @return true if empty, false otherwise
     */
    boolean empty();

    /**
     * Return the top element of the stack without removing it.
     * Will throw exception if no top element exists.
     * @return top element
     */
    E peek();

    /**
     * Return and remove the top element of the stack.
     * Will throw exception if no top element exists.
     * @return top element
     */
    E pop();

    /**
     * Add an element to the stack.
     * @param item an element to add
     */
    void push(E item);
}
