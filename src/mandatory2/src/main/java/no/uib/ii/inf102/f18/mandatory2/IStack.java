package mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2;

public abstract class IStack<E> implements IBag<E> {

    /**
     * Checks if the stack is empty.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Return the top element of the stack without removing it.
     * Will throw exception if no top element exists.
     * @return top element
     */
    abstract public E peek();

    /**
     * Return and remove the top element of the stack.
     * Will throw exception if no top element exists.
     * @return top element
     */
    abstract public E pop();

    /**
     * Add an element to the stack.
     * @param item an element to add
     */
    abstract public void push(E item);

    @Override
    public void add(E element) {
        this.push(element);
    }
}
