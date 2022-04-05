package datastructures.queues;

public interface ADTQueue<T> {

    // add element in queue
    void enqueue(T element) throws IllegalStateException;

    // delete the element from queue
    T dequeue() throws IllegalStateException;

    // return element from front of the queue
    T front() throws IllegalStateException;

    // check whether queue is empty or not
    boolean isEmpty();

    // display elements in the queue
    void display();
}
