package datastructures.trees;

import datastructures.queues.ADTQueue;
import datastructures.queues.ArrayQueue;

import java.util.HashMap;
import java.util.Map;

public class BSTApp {
    static final String IS_BINARY_TREE_SORTED = "isBinaryTreeSorted";
    static final String MIN_VALUE = "minValue";

    public static void main(String[] args) {
        BSTApp bstApp = new BSTApp();
        bstApp.runIntegerBST();
    }

    private void runIntegerBST() {
        Map<String, Object> btSortedMap = new HashMap<>();
        btSortedMap.put(IS_BINARY_TREE_SORTED, true);
        btSortedMap.put(MIN_VALUE, Integer.MIN_VALUE);

        // Integer[] A = new Integer[]{4, 2, 1, 3, 1, 6, 9, 5, 8};

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        // Create Root Node
        Node root = binarySearchTree.insertion(null, 4);

        // Assignment #1 : Insertion -> BST (Without Balancing) [Only Care For -> BST property]
        binarySearchTree.insertion(root, 2);
        binarySearchTree.insertion(root, 1);
        binarySearchTree.insertion(root, 3);
        binarySearchTree.insertion(root, 1);
        binarySearchTree.insertion(root, 6);
        binarySearchTree.insertion(root, 9);
        binarySearchTree.insertion(root, 5);
        binarySearchTree.insertion(root, 8);

        System.out.println("Binary Tree has been created successfully ...");

        // Assignment #2 : Check If BT -> BST
        System.out.println("\nTo check if Binary Tree is Binary Search Tree -> " +
                "In-Order Traversal of Binary Tree must be sorted in ascending order ...");
        System.out.println("\nIn-Order Traversal of Binary Tree ...");

        binarySearchTree.checkForBST(root, btSortedMap);

        System.out.println("\n\nIs Binary Tree Sorted [Ascending] Order -> "
                + btSortedMap.get(IS_BINARY_TREE_SORTED) + "\n");

        // Assignment #3 : Searching -> BST
        System.out.println("Is Node 3 Exists -> " + binarySearchTree.isNodeExist(root, 3));
        System.out.println("Is Node 6 Exists -> " + binarySearchTree.isNodeExist(root, 6));
        System.out.println("Is Node 13 Exists -> " + binarySearchTree.isNodeExist(root, 13));
        System.out.println("Is Node 2 Exists -> " + binarySearchTree.isNodeExist(root, 2));

        // Assignment #4 : Level-Order Traversal (Breadth-First Search) -> BST
        System.out.println("\nLevel Order Traversal (Breadth-First)");

        ADTQueue<Node> adtQueue = new ArrayQueue<>();
        binarySearchTree.levelOrderTraversal(root, adtQueue);

        // Assignment #5 : Pre-Order, In-Order, Post-Order Traversal (Depth-First Search) -> BST
        System.out.println("\n\nPre-Order Traversal");
        binarySearchTree.preOrderTraversal(root);

        System.out.println("\n\nIn-Order Traversal");
        binarySearchTree.inOrderTraversal(root, btSortedMap);

        System.out.println("\n\nPost-Order Traversal");
        binarySearchTree.postOrderTraversal(root);

        // Assignment #6 : Min and Max -> BST
        Node minNode = binarySearchTree.minElement(root);
        if (minNode == null) {
            System.out.println("\n\nMinimum Element does not exist ...");
        } else {
            System.out.println("\n\nMinimum Element = " + minNode.getData());
        }

        Node maxNode = binarySearchTree.maxElement(root);
        if (maxNode == null) {
            System.out.println("Maximum Element does not exist ...");
        } else {
            System.out.println("Maximum Element = " + maxNode.getData());
        }

        // Assignment #7 : Height-> BST
        System.out.println("\nHeight Of BST = " + binarySearchTree.findHeight(root));

        // Assignment #8 : In-Order Successor Node -> BST

        // case 1 : right child doesn't exist
        // data = 1
        Node successorNode1 = binarySearchTree.inOrderSuccessor(root, root, 1);
        if (successorNode1 != null) {
            System.out.println("\nIn-Order Successor of " + 1 + " = " + successorNode1.getData());
        } else {
            System.out.println("\nIn-Order Successor of " + 1 + " DOES NOT EXIST ");
        }

        // data = 5
        Node successorNode2 = binarySearchTree.inOrderSuccessor(root, root, 5);
        if (successorNode2 != null) {
            System.out.println("In-Order Successor of " + 5 + " = " + successorNode2.getData());
        } else {
            System.out.println("In-Order Successor of " + 5 + " DOES NOT EXIST ");
        }

        // data = 9
        Node successorNode3 = binarySearchTree.inOrderSuccessor(root, root, 9);
        if (successorNode3 != null) {
            System.out.println("In-Order Successor of " + 9 + " = " + successorNode3.getData());
        } else {
            System.out.println("In-Order Successor of " + 9 + " DOES NOT EXIST ");
        }

        // case 2 : successor doesn't exist -> data = 7
        Node successorNode4 = binarySearchTree.inOrderSuccessor(root, root, 7);
        if (successorNode4 != null) {
            System.out.println("In-Order Successor of " + 7 + " = " + successorNode4.getData());
        } else {
            System.out.println("In-Order Successor of " + 7 + " DOES NOT EXIST ");
        }

        // case 3 : right child does exist
        // data = 2
        Node successorNode5 = binarySearchTree.inOrderSuccessor(root, root, 2);
        if (successorNode5 != null) {
            System.out.println("In-Order Successor of " + 2 + " = " + successorNode5.getData());
        } else {
            System.out.println("In-Order Successor of " + 2 + " DOES NOT EXIST ");
        }

        // data = 6
        Node successorNode6 = binarySearchTree.inOrderSuccessor(root, root, 6);
        if (successorNode6 != null) {
            System.out.println("In-Order Successor of " + 6 + " = " + successorNode6.getData());
        } else {
            System.out.println("In-Order Successor of " + 6 + " DOES NOT EXIST ");
        }

        // Assignment #9 : Deletion -> BST (Without Balancing) [Only Care For -> BST property]

        // case 0 : nodeToBeDeleted is a root node
        System.out.println("\nDeleting Node -> 4");
        binarySearchTree.deletion(root, 4);

        // case 1 : nodeToBeDeleted is a leaf-node

        // left-child
        System.out.println("Deleting Node -> 8");
        binarySearchTree.deletion(root, 8);

        // right-child
        System.out.println("Deleting Node -> 3");
        binarySearchTree.deletion(root, 3);

        System.out.println("\nInserting Node -> 8");
        binarySearchTree.insertion(root, 8);

        System.out.println("Inserting Node -> 4");
        binarySearchTree.insertion(root, 4);

        // case 2 : nodeToBeDeleted has only one child

        // left-child
        System.out.println("\nDeleting Node -> 2");
        binarySearchTree.deletion(root, 2);

        // right-child
        System.out.println("Deleting Node -> 9");
        binarySearchTree.deletion(root, 9);

        // case 3 : nodeToBeDeleted has both child

        // (a) find minimum node in right-subtree and swap the data
        // (b) delete minimum node

        System.out.println("Deleting Node -> 6");
        binarySearchTree.deletion(root, 6);

        System.out.println("\nIn-Order Traversal ...");
        binarySearchTree.inOrderTraversal(root, btSortedMap);
    }
}
