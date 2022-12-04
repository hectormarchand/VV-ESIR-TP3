package fr.istic.vv;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    Comparator<Integer> comparator = new intComparator();
    BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);

    @Test
    public void pushTest() {
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.peek(), heap.toString());
        heap.push(6);
        heap.push(7);
        assertEquals(3, heap.peek(), heap.toString());
        heap.push(4);
        assertEquals(3, heap.peek(), heap.toString());
    }

    @Test
    public void popTest() {
        heap.push(3);
        heap.push(5);
        assertEquals(3, heap.pop());
        assertEquals(5, heap.peek());

    }

}

class intComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}