package main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        customLinkedList.add(4);
        customLinkedList.add(5);


        CustomIterator<Integer> iterator = customLinkedList.getIterator();

        iterator.next();
        iterator.next();

        iterator.forEachRemaining(System.out::println);

       /* while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
    }
}