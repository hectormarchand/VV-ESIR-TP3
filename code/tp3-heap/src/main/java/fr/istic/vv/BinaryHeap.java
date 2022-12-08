package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryHeap<T> {
    private Comparator<T> comparator;
    private List<T> heap;
    private int size;

    public BinaryHeap(Comparator<T> comp) {
        this.comparator = comp;
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    public T pop() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        T min = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.size - 1));
        this.heap.remove(this.size - 1);
        this.size --;
        maxHeapify(0);
        return min;
    }

    public T peek() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        return this.heap.get(0);
    }

    public void push(T element) {
        this.heap.add(element);
        this.size ++;
        this.restoreHeapProperty(this.size - 1);
    }

    public int count() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void restoreHeapProperty(int index) {
        T value = this.heap.get(index);

        while (index > 0 && this.comparator.compare(value, this.heap.get(getParentIndex(index))) < 0) {
            this.heap.set(index, this.heap.get(getParentIndex(index)));
            index = this.getParentIndex(index);
        }

        this.heap.set(index, value);
    }

    private void maxHeapify(int index) {
        // left child
        int leftChildIndex = 2 * index + 1;

        // right child
        int rightChildIndex = 2 * index + 2;

        // min
        int min = index;

        if (leftChildIndex < this.size && this.comparator.compare(this.heap.get(leftChildIndex), this.heap.get(min)) < 0) {
            min = leftChildIndex;
        }

        if (rightChildIndex < this.size && this.comparator.compare(this.heap.get(rightChildIndex), this.heap.get(min)) < 0) {
            min = rightChildIndex;
        }

        // swap and repeat
        if (min != index) {
            T swap = this.heap.get(min);
            this.heap.set(min, this.heap.get(index));
            this.heap.set(index, swap);
            maxHeapify(min);
        }
    }
}
