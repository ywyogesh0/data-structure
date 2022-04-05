package datastructures.queues;

public class ArrayQueue<T> implements ADTQueue<T> {
    private int capacity = 16;
    private int front = -1;
    private int rear = -1;
    private Object[] A;

    public ArrayQueue() {
        A = new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (rear == capacity - 1) {
            capacity = capacity * 2;

            Object[] oldArray = A;
            A = new Object[capacity];

            if (rear + 1 - front >= 0)
                System.arraycopy(oldArray, front, A, front, rear + 1 - front);
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear += 1;
        }

        A[rear] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty ...");

        int tmp = front;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front += 1;
        }

        return (T) A[tmp];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T front() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty ...");

        return (T) A[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    @Override
    public void display() {
        if (!isEmpty()) {
            for (int i = front; i <= rear; i++)
                System.out.print(A[i] + " ");
        }
    }
}
