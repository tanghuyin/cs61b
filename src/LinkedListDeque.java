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
    private TNode sentinelFront;
    private TNode sentinelBack;
    public LinkedListDeque() {
        this.size = 0;
        this.sentinelFront = new TNode(null, null, null);
        this.sentinelBack = new TNode(null, null, null);
        sentinelBack.prev = sentinelFront;
        sentinelFront.next = sentinelBack;
    }

    public void addFirst(T item) {
        TNode n = new TNode(item, sentinelFront, sentinelFront.next);
        sentinelFront.next.prev = n;
        sentinelFront.next = n;
        size++;
    }

    public void addLast(T item) {
        TNode n = new TNode(item, sentinelBack.prev, sentinelBack);
        sentinelBack.prev.next = n;
        sentinelBack.prev = n;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode curr = sentinelFront.next;
        String prefix = "";
        while (curr != sentinelBack) {
            System.out.print(prefix + curr.item);
            curr = curr.next;
            prefix = "->";
        }
        System.out.println();
    }

    public T removeFirst() {
        T value = sentinelFront.next.item;
        sentinelFront.next = sentinelFront.next.next;
        sentinelFront.next.prev = sentinelFront;
        size--;
        return value;
    }

    public T removeLast() {
        return null;
    }

    public T get(int index) {
        return null;
    }
}
