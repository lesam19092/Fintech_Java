package main.java;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class CustomLinkedList<E> implements CustomList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public E getFirst() {
        if (first != null) {
            return first.element;
        }
        throw new NoSuchElementException();
    }

    public void setFirst(E e) {
        this.first.element = e;
    }

    public E getLast() {
        if (last != null) {
            return last.element;
        }
        throw new NoSuchElementException();
    }

    public void setLast(E e) {
        this.last.element = e;
    }

    public int getSize() {
        return size;
    }


    /**
     * Appends the specified element to the end of this list.
     */
    @Override
    public boolean add(E e) {
        Node<E> node = new Node<>(e);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
     */
    @Override
    public boolean addAll(List<? extends E> collection) {

        if (collection == null || collection.isEmpty()) {
            return false;
        }
        for (E e : collection) {
            add(e);
        }
        return true;
    }

    /**
     * Returns true if this list contains the specified element.
     */
    @Override
    public boolean contains(Object o) {
        Node<E> current = first;
        while (current != null) {
            if (current.element == null) {
                if (o == null) {
                    return true;
                }
            } else if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Returns the element at the specified position in this list.
     */
    @Override
    public E get(int index) {
        checkIndex(index);

        if (index == size - 1) {
            return last.element;
        }


        Node<E> current = getNode(index);

        return current.element;
    }


    /**
     * Removes the element at the specified position in this list.
     */
    @Override
    public E remove(int index) {
        checkIndex(index);


        Node<E> current = first;
        Node<E> toRemove = null;
        if (index == 0) {
            E elementToRemove = first.element;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            size--;
            return elementToRemove;
        } else {
            current = getNode(index - 1);
            toRemove = current.next;
            current.next = toRemove.next;
            if (toRemove.next != null) {
                toRemove.next.prev = current;
            } else {
                last = current;
            }
        }
        size--;

        return toRemove.element;
    }

    @Override
    public CustomIterator<E> getIterator() {
        return new CustomLinkedListIterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        }
    }

    private Node<E> getNode(int index) {
        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class Node<E> {
        E element;
        Node prev;
        Node next;


        public Node(E element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }
    }

    private class CustomLinkedListIterator implements CustomIterator<E> {

        private Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E element = current.element;
                current = current.next;
                return element;
            }
            throw new IndexOutOfBoundsException("вы вышли за пределы списка");
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            while (hasNext()) {
                action.accept(next());
            }
        }
    }

}
