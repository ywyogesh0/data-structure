package datastructures.queues;

class CircularArrayQueue<T> implements ADTQueue<T> {
    private int capacity = 16;
    private int front = -1;
    private int rear = -1;
    private Object[] A;

    CircularArrayQueue() {
        A = new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if ((rear + 1) % capacity == front)
            throw new IllegalStateException("Queue is full ...");

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
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
            front = (front + 1) % capacity;
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
            if (rear >= front) {
                for (int i = front; i <= rear; i++)
                    System.out.print(A[i] + " ");
            } else {
                for (int i = front; i < capacity; i++)
                    System.out.print(A[i] + " ");

                for (int i = 0; i <= rear; i++)
                    System.out.print(A[i] + " ");
            }
        }
    }
}
