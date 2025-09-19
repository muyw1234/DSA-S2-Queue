public class QueueImpl<E> implements Queue<E> {
    private E[] data;
    private int p; // número d'elements actuals a la cua

    @SuppressWarnings("unchecked")
    public QueueImpl(int len) {
        if (len <= 0) throw new IllegalArgumentException("La capacitat ha de ser > 0");
        this.data = (E[]) new Object[len];
        this.p = 0;
    }

    @Override
    public void push(E e) throws FullQueueException {
        if (isFull()) {
            throw new FullQueueException();
        }
        data[p++] = e;
    }

    @Override
    public E pop() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        E first = data[0];
        // desplaçar tots els elements cap a l'esquerra
        for (int i = 1; i < p; i++) {
            data[i - 1] = data[i];
        }
        data[--p] = null; // neteja i decrementa la mida
        return first;
    }

    private boolean isFull() {
        return p == data.length;
    }

    private boolean isEmpty() {
        return p == 0;
    }

    @Override
    public int size() {
        return p;
    }
}
