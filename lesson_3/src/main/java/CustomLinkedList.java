

import java.util.List;


public class CustomLinkedList<E> implements CustomLinkedListImpl<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;


    public CustomLinkedList() {
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return first.element;
        }
        if (index == size - 1) {
            return last.element;
        }

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }


    /**
     * Removes the element at the specified position in this list.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }


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
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
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


}
