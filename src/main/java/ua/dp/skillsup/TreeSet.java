package ua.dp.skillsup;

import java.util.Objects;

public class TreeSet {

    private Node root;
    private int size;
    private boolean isElement;
    private static StringBuilder result = new StringBuilder();


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
        if (value == current.getValue()) {
            current.setValue(value);
            return;
        }

        if (value.hashCode() < current.getValue().hashCode()) {
            addLeft(current, value);
        } else if (value.hashCode() > current.getValue().hashCode()) {
            addRight(current, value);
        }

    }

    private void addLeft(Node current, Object value) {
        if (Objects.nonNull(current.getLeft())) {
            add(current.getLeft(), value);
        } else {
            current.setLeft(new Node(value));
            size++;
        }
    }

    private void addRight(Node current, Object value) {
        if (Objects.nonNull(current.getRight())) {
            add(current.getRight(), value);
        } else {
            current.setRight(new Node(value));
            size++;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        if (isEmpty()) {
            return false;
        }

        isElement = false;

        find(root, value);

        return isElement;
    }

    private void find(Node current, Object value) {
        if (value.equals(current.getValue())) {
            isElement = true;
            return;
        }

        if (value.hashCode() < current.getValue().hashCode()) {
            if (Objects.nonNull(current.getLeft())) {
                find(current.getLeft(), value);
            }
        } else if (value.hashCode() > current.getValue().hashCode()) {
            if (Objects.nonNull(current.getRight())) {
                find(current.getRight(), value);
            }
        }

    }

    public String show() {
        result.setLength(0);
        display(root);
        return result.toString();
    }

    private static void display(Node node) {
        if (Objects.nonNull(node)) {
            display(node.left);
            result.append(node.getValue().toString());
            display(node.right);
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

        public void setValue(Object value) {
            this.value = value;
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
