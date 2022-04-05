package datastructures.queues;

public class LinkedListQueueApp {

    public static void main(String[] args) {
        LinkedListQueueApp linkedListQueueApp = new LinkedListQueueApp();

        linkedListQueueApp.runIntegerArrayQueue();
        System.out.println("\n**********************************************\n");
    }

    private void runIntegerArrayQueue() {
        ADTQueue<Integer> adtQueue = new LinkedListQueue<>();

        System.out.println("Is Queue Empty -> " + adtQueue.isEmpty());

        System.out.println("Inserting Element 1 to 16");
        adtQueue.enqueue(1);
        adtQueue.enqueue(2);
        adtQueue.enqueue(3);
        adtQueue.enqueue(4);
        adtQueue.enqueue(5);
        adtQueue.enqueue(6);
        adtQueue.enqueue(7);
        adtQueue.enqueue(8);
        adtQueue.enqueue(9);
        adtQueue.enqueue(10);
        adtQueue.enqueue(11);
        adtQueue.enqueue(12);
        adtQueue.enqueue(13);
        adtQueue.enqueue(14);
        adtQueue.enqueue(15);
        adtQueue.enqueue(16);

        adtQueue.display();
        System.out.println("\nFront Element In The Queue = " + adtQueue.front());

        System.out.println("Removing Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();
        System.out.println("\nFront Element In The Queue = " + adtQueue.front());

        System.out.println("Is Queue Empty -> " + adtQueue.isEmpty());

        System.out.println("Removing Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();

        System.out.println("\nInserting Element = 22");
        adtQueue.enqueue(22);

        System.out.println("Inserting Element = 23");
        adtQueue.enqueue(23);

        adtQueue.display();

        System.out.println("\nRemoving Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();
    }
}
