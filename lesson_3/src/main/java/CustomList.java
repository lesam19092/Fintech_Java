package main.java;

import java.util.List;

public interface CustomList<E> {

    boolean add(E e);

    boolean addAll(List<? extends E> c);

    boolean contains(Object o);

    E get(int index);

    E remove(int index);

    CustomIterator<E> getIterator();

}
