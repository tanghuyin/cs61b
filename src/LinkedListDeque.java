public class LinkedListDeque<T> {
    // static nested classes
    public class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T item, TNode p, TNode n) {
            this.item = item;
            this.prev = p;
            this.next = n;
        }
    }
    // caching
    private int size;
    private TNode sentinel;

    public LinkedListDeque() {
        this.size = 0;
        this.sentinel = new TNode((T) new Object(), null, null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        TNode n = new TNode(item, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;
    }

    public void addLast(T item) {
        TNode n = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode curr = sentinel.next;
        String prefix = "";
        while (curr != sentinel) {
            System.out.print(prefix + curr.item);
            curr = curr.next;
            prefix = "->";
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null; // special check
        }
        T value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return value;
    }

    public T get(int index) {
        if (size < index) {
            return null;
        }
        TNode n = sentinel.next;
        while (index > 0) {
            n = n.next;
            index--;
        }
        return n.item;
    }

    public T getRecursive(int index) {
        if (size < index) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(TNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursive(node.next, i-1);
    }
}
