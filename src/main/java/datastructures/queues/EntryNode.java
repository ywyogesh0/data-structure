package datastructures.queues;

class EntryNode<T> {

    private T data;
    private EntryNode<T> next;

    EntryNode(T data, EntryNode<T> next) {
        this.data = data;
        this.next = next;
    }

    T getData() {
        return data;
    }

    void setNext(EntryNode<T> next) {
        this.next = next;
    }

    EntryNode<T> getNext() {
        return next;
    }
}

