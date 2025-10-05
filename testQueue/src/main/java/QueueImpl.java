public class QueueImpl<E> implements Queue<E> {
    private E[] data;
    private int p;

    public QueueImpl(int len) {
        // TO-DO
        this.data = (E[])new Object[len];
        this.p = 0;
    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        if (isFull())
        {
            throw new FullQueueException();
        }
        this.data[this.p++]=e;
    }


    public E pop() throws EmptyQueueException {
        // TO-DO
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        E a = this.data[0];//primera posicion del vector
        this.shift();
        return a;
    }

    private void shift() {
        for (int i = 0; i < p - 1; i++)
        {
            data[i] = data[i + 1];
        }
        data[p - 1] = null;
        p--;
    }

    private boolean isFull() {
        // TO-DO
        if  (this.p < this.data.length)
        {
            return false;
        }
        return true;
    }

    private boolean isEmpty() {
        // TO-DO
        if (this.p>0)
        {
            return false;
        }
        return true;
    }

    public int size() {
        //TO-DO
        return this.p;
    }
}
