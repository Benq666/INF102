package mandatory1.src.main.java.no.uib.ii.inf102.f18.mandatory1;

/**
 * @author Andrey Belinskiy
 */
@SuppressWarnings("unchecked")
public class MyDynamicArrayStack<E> implements IStack<E> {
    private E[] data;
    private int size;

    public MyDynamicArrayStack() {
        data = (E[]) new Object[2];
        size = 0;
    }

    @Override
    public E pop() {
        E item = data[--size];
        data[size] = null;
        if (size < data.length / 4)
            resize(data.length / 2);
        return item;
    }

    @Override
    public void push(E item) {
        if (size == data.length)
            resize(data.length * 2);
        data[size++] = item;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    private void resize(int newSize) {
        E[] newdata = (E[]) new Object[newSize];
        System.arraycopy(this.data, 0, newdata, 0, size);

        data = newdata;
    }
}
