package com.Heaps;

class MaxPQ {

    private Integer[] pq;                    // store items at indices 1 to n
    private int n;                           // number of items on priority queue

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(int initCapacity) {
        pq = new Integer[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MaxPQ(Integer[] keys) {
        n = keys.length;
        pq = new Integer[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws Exception if this priority queue is empty
     */
    public Integer max() throws Exception {
        if (isEmpty()) throw new Exception("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Integer[] temp = new Integer[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the new key to add to this priority queue
     */
    public void insert(Integer x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws Exception if this priority queue is empty
     */
    public Integer delMax() throws Exception {
        if (isEmpty()) throw new Exception("Priority queue underflow");
        Integer max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loitering and help with garbage collection
        // if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }

    /**
     * Helper functions to restore the heap invariant.
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) { // k is not leaf
            int j = 2*k;
            if (j < n && less(j, j+1)) j++; // j points to biggest child
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Integer swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..n] a max heap?
    private boolean isMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = n+1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMaxHeapOrdered(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeapOrdered(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= n / 2; i++) {
            System.out.print("PARENT : " + pq[i]
                    + " LEFT CHILD : " + pq[2 * i]
                    + " RIGHT CHILD :" + pq[2 * i + 1]);
            System.out.println();
        }
    }
}
/*
---------------------------------------------------------------------
 */
class Demo {

    public static void main(String[] args) {

        try {
            MaxPQ maxHeap = new MaxPQ(50);
            maxHeap.insert(5);
            maxHeap.insert(3);
            maxHeap.insert(17);
            maxHeap.insert(10);
            maxHeap.insert(84);
            maxHeap.insert(19);
            maxHeap.insert(6);
            maxHeap.insert(22);
            maxHeap.insert(9);
            maxHeap.print();
            System.out.println("The max val is: " + maxHeap.delMax());
            System.out.println("Size: " + maxHeap.size());
            maxHeap.print();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}