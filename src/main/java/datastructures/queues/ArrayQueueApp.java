package datastructures.queues;

public class ArrayQueueApp {

    public static void main(String[] args) {
        ArrayQueueApp arrayQueueApp = new ArrayQueueApp();

        arrayQueueApp.runIntegerArrayQueue();
        System.out.println("\n**********************************************\n");
        arrayQueueApp.runStringArrayQueue();
    }

    private void runIntegerArrayQueue() {
        ADTQueue<Integer> adtQueue = new ArrayQueue<>();

        System.out.println("Inserting Element = 4");
        adtQueue.enqueue(4);

        System.out.println("Inserting Element = 1");
        adtQueue.enqueue(1);

        System.out.println("Inserting Element = 3");
        adtQueue.enqueue(3);

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

        System.out.println("\nInserting Element = 2");
        adtQueue.enqueue(2);

        adtQueue.display();

        System.out.println("\nRemoving Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();

        System.out.println("\nRemoving Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();

        System.out.println("Is Queue Empty -> " + adtQueue.isEmpty());
    }

    private void runStringArrayQueue() {
        ADTQueue<String> adtQueue = new ArrayQueue<>();

        System.out.println("Inserting Element = Yogesh");
        adtQueue.enqueue("Yogesh");

        System.out.println("Inserting Element = Walia");
        adtQueue.enqueue("Walia");

        System.out.println("Inserting Element = Nanu");
        adtQueue.enqueue("Nanu");

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

        System.out.println("\nInserting Element = Rahul");
        adtQueue.enqueue("Rahul");

        adtQueue.display();

        System.out.println("\nRemoving Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();

        System.out.println("\nRemoving Front Element ...");
        adtQueue.dequeue();

        adtQueue.display();

        System.out.println("Is Queue Empty -> " + adtQueue.isEmpty());
    }
}
