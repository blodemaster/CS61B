public class LinkedListDeque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    public Node sentinel;
    public int size;

    public LinkedListDeque() {
        sentinel = new Node(sentinel, null, sentinel);
        size = 0;
    }

    public LinkedListDeque(T item) {
        Node newNode = new Node(sentinel, item, sentinel);
        sentinel = new Node(newNode, item, newNode);
        size = 1;
    }

    public void addFirst(T item) {
        Node newNode;
        if (this.isEmpty()) {
            newNode = new Node(sentinel, item, sentinel);
            sentinel.prev = newNode;
        } else {
            Node first = sentinel.next;
            newNode = new Node(sentinel, item, first);
            first.prev = newNode;
        }
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode;
        if (this.isEmpty()) {
            newNode = new Node(sentinel, item, sentinel);
            sentinel.next = newNode;
        } else {
            Node last = sentinel.prev;
            newNode = new Node(last, item, sentinel);
            last.next = newNode;
        }

        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = sentinel.next;
        sentinel.next = oldFirst.next;
        oldFirst.next.prev = sentinel;
        size--;
        T itemToReturn = oldFirst.item;
        oldFirst = null;
        return itemToReturn;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = sentinel.prev;
        sentinel.prev = oldLast.prev;
        oldLast.prev.next = sentinel;
        T itemToReturn = oldLast.item;
        oldLast = null;
        size--;
        return itemToReturn;
    }

    public T get(int index) {
        Node first = sentinel.next;
        if (index > size) {
            return null;
        } else {
            for (int i=0; i < index; i++) {
                first = first.next;
            }
            return first.item;
        }
    }

    public T getHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        if (p == null) {
            return null;
        }
        return getHelper(p.next, index-1);
    }

    public T getRecursive(int index) {
        return getHelper(sentinel.next, index);
    }

}
