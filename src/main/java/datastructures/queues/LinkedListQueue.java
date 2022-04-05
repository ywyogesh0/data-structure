package datastructures.queues;

class LinkedListQueue<T> implements ADTQueue<T> {
    private EntryNode<T> front = null;
    private EntryNode<T> rear = null;

    @Override
    public void enqueue(T element) {
        EntryNode<T> entryNode = new EntryNode<>(element, null);

        if (rear == null) {
            front = entryNode;
        } else {
            EntryNode<T> tmpNode = rear;
            tmpNode.setNext(entryNode);
        }

        rear = entryNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty ...");

        EntryNode<T> frontNode = front;
        front = frontNode.getNext();

        if (front == null)
            rear = null;

        T data = frontNode.getData();
        frontNode.setNext(null);

        return data;
    }

    @Override
    public T front() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty ...");

        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public void display() {
        if(!isEmpty()) {
            EntryNode<T> tmpNode = front;
            while(tmpNode != null) {
                System.out.print(tmpNode.getData() + " ");
                tmpNode = tmpNode.getNext();
            }
        }
    }
}
