package fr.istic.vv;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    Comparator<Integer> comparator = new intComparator();
    BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);

    @Test
    public void pushTest() {
        BinaryHeap<Integer> h = new BinaryHeap<>(comparator);
        int N = 1000;
        for (int i = 1; i <= N; i++) {
            h.push(i);
        }
    }

    @Test
    public void popTest() {
        assertThrows(NoSuchElementException.class, () ->heap.pop());
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.pop());
        assertEquals(5, heap.pop());

        int N = 1000;
        for (int i = N; i >= 0; i--) {
            heap.push(i);
        }

        for(int i = 0; i <= N; i++) {
            assertEquals(i, heap.pop());
        }
        assertThrows(NoSuchElementException.class, () ->heap.pop());
    }

    @Test
    public void peekTest() {
        assertThrows(NoSuchElementException.class, () ->heap.peek());
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.peek());
        assertEquals(3, heap.peek());

    }

    @Test
    public void sizeTest() {
        BinaryHeap<Integer> h = new BinaryHeap<>(comparator);
        int N = 1000;
        assertTrue(h.empty());
        for (int i = 1; i <= N; i++) {
            h.push(i);
            assertEquals(i, h.count());
        }

        for(int i = N; i >= 1; i--) {
            h.pop();
            assertEquals(i-1, h.count());
        }
        assertTrue(h.empty());
    }

}

class intComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}