package datastructures.trees;

import datastructures.queues.ADTQueue;

import java.util.Map;

import static datastructures.trees.BSTApp.IS_BINARY_TREE_SORTED;
import static datastructures.trees.BSTApp.MIN_VALUE;

class BinarySearchTree<T> {

    private boolean isRoot = true;

    Node insertion(Node root, T data) {
        if (root == null) {
            return getNewNode(data);
        }

        Object rootData = root.getData();
        if (data instanceof Integer) {
            if (Integer.parseInt(data.toString()) <= Integer.parseInt(rootData.toString()))
                root.setLeftChild(insertion(root.getLeftChild(), data));
            else {
                root.setRightChild(insertion(root.getRightChild(), data));
            }
        }

        return root;
    }

    void checkForBST(Node root, Map<String, Object> btSortedMap) {
        inOrderTraversal(root, btSortedMap);
    }

    boolean isNodeExist(Node root, T data) {
        if (root == null)
            return false;

        if (data instanceof Integer) {
            Object rootData = root.getData();

            if (Integer.parseInt(data.toString()) == Integer.parseInt(rootData.toString()))
                return true;
            else if (Integer.parseInt(data.toString()) < Integer.parseInt(rootData.toString()))
                return isNodeExist(root.getLeftChild(), data);
            else return isNodeExist(root.getRightChild(), data);
        }

        return false;
    }

    void levelOrderTraversal(Node root, ADTQueue<Node> queue) {
        if (root == null)
            return;

        System.out.print(root.getData() + " ");

        queue.enqueue(root.getLeftChild());
        queue.enqueue(root.getRightChild());

        while (!queue.isEmpty()) {
            levelOrderTraversal(queue.dequeue(), queue);
        }
    }

    void inOrderTraversal(Node root, Map<String, Object> btSortedMap) {
        if (root == null)
            return;

        inOrderTraversal(root.getLeftChild(), btSortedMap);

        // isBTSorted
        isBTSorted(root, btSortedMap);

        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightChild(), btSortedMap);
    }

    void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.getData() + " ");

        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());

        System.out.print(root.getData() + " ");
    }

    Node minElement(Node root) {
        if (root == null)
            return null;

        Node minNode = minElement(root.getLeftChild());
        if (minNode == null) {
            minNode = root;
        }

        return minNode;
    }

    Node maxElement(Node root) {
        if (root == null)
            return null;

        Node maxNode = maxElement(root.getRightChild());
        if (maxNode == null) {
            maxNode = root;
        }

        return maxNode;
    }

    Node inOrderSuccessor(Node primaryRoot, Node root, T data) {
        if (root == null)
            return null;

        if (data instanceof Integer) {
            if (Integer.parseInt(data.toString()) == Integer.parseInt(root.getData().toString())) {

                if (root.getRightChild() == null)
                    // case 1 : right child doesn't exist
                    return rightChildNotExist(null, primaryRoot, data);

                else
                    // case 2 : right child does exist
                    return rightChildExist(root.getRightChild());

            } else if (Integer.parseInt(data.toString()) < Integer.parseInt(root.getData().toString())) {
                return inOrderSuccessor(primaryRoot, root.getLeftChild(), data);
            } else {
                return inOrderSuccessor(primaryRoot, root.getRightChild(), data);
            }
        }

        return null;
    }

    int findHeight(Node root) {
        if (root == null)
            return -1;

        int leftChildHeight = findHeight(root.getLeftChild());
        int rightChildHeight = findHeight(root.getRightChild());

        // (leftChildHeight >= rightChildHeight ? leftChildHeight : rightChildHeight) + 1;
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    Node deletion(Node root, T data) {
        if (root == null)
            return null;

        Object rootData = root.getData();

        if (data instanceof Integer) {
            if (Integer.parseInt(data.toString()) == Integer.parseInt(rootData.toString())) {
                if (isRoot) {
                    deleteNode(root, null, null);
                    return null;
                } else
                    return root;
            } else if (Integer.parseInt(data.toString()) < Integer.parseInt(rootData.toString())) {
                isRoot = false;
                Node nodeToBeDeleted = deletion(root.getLeftChild(), data);
                if (nodeToBeDeleted != null)
                    deleteNode(nodeToBeDeleted, root, true);
            } else {
                isRoot = false;
                Node nodeToBeDeleted = deletion(root.getRightChild(), data);
                if (nodeToBeDeleted != null)
                    deleteNode(nodeToBeDeleted, root, false);
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void deleteNode(Node nodeToBeDeleted, Node parentNode, Boolean isLeftChild) {

        // case 1 : nodeToBeDeleted is a leaf-node
        if (nodeToBeDeleted.getLeftChild() == null && nodeToBeDeleted.getRightChild() == null) {
            if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        }

        // case 2 : nodeToBeDeleted has only one child

        // left-child
        else if (nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() == null) {
            if (isLeftChild) {
                parentNode.setLeftChild(nodeToBeDeleted.getLeftChild());
            } else {
                parentNode.setRightChild(nodeToBeDeleted.getLeftChild());
            }
        }

        // right-child
        else if (nodeToBeDeleted.getLeftChild() == null && nodeToBeDeleted.getRightChild() != null) {
            if (isLeftChild) {
                parentNode.setLeftChild(nodeToBeDeleted.getRightChild());
            } else {
                parentNode.setRightChild(nodeToBeDeleted.getRightChild());
            }
        }

        // case 3 : nodeToBeDeleted has both child

        // (a) find minimum node in right-subtree and swap the data
        // (b) delete minimum node

        else {
            Node minimumNode = minElement(nodeToBeDeleted.getRightChild());
            Object data = minimumNode.getData();

            if (data instanceof Integer) {
                isRoot = false;
                new BinarySearchTree<Integer>()
                        .deletion(nodeToBeDeleted, Integer.parseInt(data.toString()));
            }

            nodeToBeDeleted.setData(data);
        }
    }

    private Node rightChildNotExist(Node successorNode, Node root, T data) {
        if (data instanceof Integer) {
            if (Integer.parseInt(data.toString()) == Integer.parseInt(root.getData().toString())) {
                return successorNode;
            } else if (Integer.parseInt(data.toString()) < Integer.parseInt(root.getData().toString())) {
                return rightChildNotExist(root, root.getLeftChild(), data);
            } else {
                return rightChildNotExist(successorNode, root.getRightChild(), data);
            }
        }

        return successorNode;
    }

    private Node rightChildExist(Node root) {
        if (root == null)
            return null;

        return getSuccessorNode(rightChildExist(root.getLeftChild()), root);
    }

    private Node getSuccessorNode(Node childNode, Node root) {
        return childNode == null ? root : childNode;
    }

    private void isBTSorted(Node root, Map<String, Object> btSortedMap) {
        Boolean isBinarySearchTreeSorted = (Boolean) btSortedMap.get(IS_BINARY_TREE_SORTED);
        Integer minValue = (Integer) btSortedMap.get(MIN_VALUE);

        Object rootData = root.getData();

        if (rootData instanceof Integer) {
            int rootDataInteger = Integer.parseInt(rootData.toString());
            if (isBinarySearchTreeSorted) {
                isBinarySearchTreeSorted = rootDataInteger >= minValue;
                minValue = rootDataInteger;
            }
        }

        btSortedMap.put(IS_BINARY_TREE_SORTED, isBinarySearchTreeSorted);
        btSortedMap.put(MIN_VALUE, minValue);
    }

    private Node getNewNode(T data) {
        return new Node<>(data, null, null);
    }
}
