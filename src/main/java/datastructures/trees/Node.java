package datastructures.trees;

class Node<T> {

    private T data;
    private Node leftChild;
    private Node rightChild;

    Node(T data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    T getData() {
        return data;
    }

    Node getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    Node getRightChild() {
        return rightChild;
    }

    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    void setData(T data) {
        this.data = data;
    }
}
