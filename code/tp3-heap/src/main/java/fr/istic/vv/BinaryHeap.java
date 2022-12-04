package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private ArrayList<T> heap;
    private int size;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        heap = new ArrayList<>();
        size = 0;
        this.comparator = comparator;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.remove(--size);
    }

    public T peek() {
        return heap.get(size - 1);
    }

    public void push(T element) {
        heap.add(element);
        size++;
        for (int i = 0; i < size - 1; i++) {
            T elementToCompare = heap.get(size - 2 - i);
            if (comparator.compare(element, elementToCompare) > 0) {
                swap(element, elementToCompare, size - 2 - i);
            }
        }
    }

    private void swap(T element, T elementToCompare, int position) {
        heap.set(position + 1, elementToCompare);
        heap.set(position, element);
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += heap.get(i) + " ";
        }
        s += " ]";
        return s;
    }

}