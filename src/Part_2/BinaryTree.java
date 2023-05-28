package Part_2;

import java.util.Iterator;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;

    public BinaryTree() {root = null;}

    public BinaryTree(T rootData) {root = new Node<>(rootData);}

    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right)
    {
        root = new Node<>(rootData);
        if (left != null)
        {
            root.left = left.root;
        }
        if (right != null)
        {
            root.right = right.root;
        }
    }

    public void print()
    {
        if (root != null)
            root.printNodes();
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {return new InorderIterator();}

    // Recursive traversals with Visitor pattern
    public void inorderTraverse(Visitor<T> visitor) {inorderTraverseRecursive(root, visitor);}

    private void inorderTraverseRecursive(Node<T> node, Visitor<T> visitor)
    {
        if (node != null)
        {
            inorderTraverseRecursive(node.left, visitor);
            visitor.visit(node.data);
            inorderTraverseRecursive(node.right, visitor);
        }
    }

    public void postorderTraverse(Visitor<T> visitor) {postorderTraverseRecursive(root, visitor);}

    private void postorderTraverseRecursive(Node<T> node, Visitor<T> visitor)
    {
        if (node != null)
        {
            postorderTraverseRecursive(node.left, visitor);
            postorderTraverseRecursive(node.right, visitor);
            visitor.visit(node.data);
        }
    }

    public void preorderTraverse(Visitor<T> visitor)
    {
        preorderTraverseRecursive(root, visitor);
    }

    private void preorderTraverseRecursive(Node<T> node, Visitor<T> visitor)
    {
        if (node != null)
        {
            visitor.visit(node.data);
            preorderTraverseRecursive(node.left, visitor);
            preorderTraverseRecursive(node.right, visitor);
        }
    }

    private static class Node<T>
    {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void printNodes()
        {
            if (left != null)
                left.printNodes();
            System.out.print(data + " ");

            if (right != null)
                right.printNodes();
        }
    }

    public interface Visitor<T> { void visit(T data);}

    // 2.5 Inorder Iterator
    private class InorderIterator implements Iterator<T>
    {
        private Node<T> current;
        private Stack<Node<T>> stack;

        public InorderIterator()
        {
            current = root;
            stack = new Stack<>();
            populateStack(current);
        }

        private void populateStack(Node<T> node)
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {return !stack.isEmpty();}

        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            Node<T> node = stack.pop();
            populateStack(node.right);
            return node.data;
        }
    }

    // GetSize method 2.6
    public int getSize() {
        return getSizeOfNode(root);
    }

    private int getSizeOfNode(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getSizeOfNode(node.left);
        int rightSize = getSizeOfNode(node.right);
        return 1 + leftSize + rightSize;
    }
}