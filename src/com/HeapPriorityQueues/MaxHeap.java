package com.HeapPriorityQueues;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int getParent(int pos) {
        return pos / 2;
    }

    private int getLeftChild(int pos) {
        return (2 * pos);
    }
    private int getRightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[getLeftChild(pos)] || Heap[pos] < Heap[getRightChild(pos)]) {

            if (Heap[getLeftChild(pos)] > Heap[getRightChild(pos)]) {
                swap(pos, getLeftChild(pos));
                maxHeapify(getLeftChild(pos));
            } else {
                swap(pos, getRightChild(pos));
                maxHeapify(getRightChild(pos));
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;

        int current = size;
        while (Heap[current] > Heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                    Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractMax() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] arg) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
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
        System.out.println("The max val is " + maxHeap.extractMax());
    }
}
