package ua.dp.skillsup;

import java.util.Objects;

public class TreeSet {

    private Node root;
    private int size;

    public void add(Object value) {
        if (Objects.isNull(value)) {
            System.out.println("\nThe value must not be equals null.");
            return;
        }
        if (Objects.isNull(root)) {
            root = new Node(value);
            size++;
            return;
        }
        add(root, value);
    }

    private void add(Node current, Object value) {
        if (value.equals(current.getValue())) {
            return;
        }
        if (value.hashCode() < current.getValue().hashCode()) {
            addLeft(current, value);
            return;
        }
        addRight(current, value);
    }

    private void addLeft(Node current, Object value) {
        if (Objects.nonNull(current.getLeft())) {
            add(current.getLeft(), value);
            return;
        }
        current.setLeft(new Node(value));
        size++;
    }

    private void addRight(Node current, Object value) {
        if (Objects.nonNull(current.getRight())) {
            add(current.getRight(), value);
            return;
        }
        current.setRight(new Node(value));
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        if (isEmpty()) return false;

        return find(root, value);
    }

    private boolean find(Node current, Object value) {
        if (value.equals(current.getValue())) {
            return true;
        }

        Node next = value.hashCode() < current.getValue().hashCode()
                ? current.getLeft()
                : current.getRight();

        return Objects.nonNull(next)
                ? find(next, value)
                : false;
    }

    public String show() {
        StringBuilder result = new StringBuilder();
        populateResult(root, result);
        return result.toString();
    }

    private void populateResult(Node node, StringBuilder result) {
        if (Objects.nonNull(node)) {
            populateResult(node.left, result);
            result.append(node.getValue().toString());
            populateResult(node.right, result);
        }
    }

    class Node {

        private Object value;
        private Node left;
        private Node right;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
