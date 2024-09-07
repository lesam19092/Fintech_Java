import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class CustomLinkedListTest {

    @Test
    public void addWhenListIsEmpty() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        String element = "Hello";

        list.add(element);

        assertEquals(1, list.getSize());
        assertEquals(element, list.getFirst().element);
        assertEquals(element, list.getLast().element);
        assertNull(list.getFirst().prev);
        assertNull(list.getLast().next);
    }

    @Test
    public void addWhenNonEmptyList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();

        list.add("foo");
        String str = "bar";

        list.add(str);

        assertEquals(2, list.getSize());
        assertEquals("foo", list.getFirst().element);
        assertEquals("bar", list.getLast().element);
        assertNull(list.getFirst().prev);
        assertNull(list.getLast().next);

    }

    @Test
    public void getEmptyList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void getValidIndexFirst() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);

        int element = list.get(0);

        assertEquals(10, element);
    }

    @Test
    public void getValidIndexLast() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Hello");
        list.add("World");

        String element = list.get(1);

        assertEquals("World", element);
    }

    @Test
    public void getValidIndexMiddle() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        int element = list.get(1);

        assertEquals(20, element);
    }

    @Test
    public void getNegativeIndex() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Hello");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void getIndexGreaterThanSize() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }


    @Test
    public void testRemove_EmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void removeSingleElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("element");
        String removed = list.remove(0);
        assertEquals("element", removed);
        assertTrue(list.getSize() == 0);
    }

    @Test
    public void removeFirstElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("10");
        list.add("20");
        String removed = list.remove(0);
        assertEquals("10", removed);
        assertEquals(1, list.getSize());
        assertEquals("20", list.get(0));

    }

    @Test
    public void RemoveLastElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("first");
        list.add("second");
        String removed = list.remove(1);
        assertEquals("second", removed);
        assertEquals(1, list.getSize());
        assertEquals("first", list.get(0));
    }

    @Test
    public void removeMiddleElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        String removed = list.remove(1);
        assertEquals("20", removed);
        assertEquals(2, list.getSize());
        assertEquals("10", list.get(0));
        assertEquals("30", list.get(1));
    }

    @Test
    public void removeNegativeIndex() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("element");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    public void removeIndexGreaterThanSize() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void removeMultipleElements() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove(1);
        list.remove(0);
        assertEquals(1, list.getSize());
        assertEquals("three", list.get(0));
    }

    @Test
    public void сontainsEmptyList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        assertFalse(list.contains("Hello"));
        assertFalse(list.contains(null));
    }

    @Test
    public void сontainsExistingElement() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        assertTrue(list.contains(10));
        assertFalse(list.contains(30));
    }

    @Test
    public void сontainsNullElement_InList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add(null);
        assertTrue(list.contains(null));
        assertFalse(list.contains("Hello"));
    }

    @Test
    public void сontainsNullElementNotInList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        assertFalse(list.contains(null));
    }

    @Test
    public void addAllEmptyCollection() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        List<Integer> empty = Collections.emptyList();

        boolean result = list.addAll(empty);

        assertFalse(result);
        assertEquals(0, list.getSize());
    }

    @Test
    public void addAllNonEmptyCollection() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        List<String> toAdd = Arrays.asList("a", "b", "c");

        boolean result = list.addAll(toAdd);

        assertTrue(result);
        assertEquals(3, list.getSize());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    public void testAddAllNullCollection() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();


        list.addAll(null);

        assertEquals(list.getSize(), 0);

    }
}