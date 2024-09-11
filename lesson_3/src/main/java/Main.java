import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add(1);
        Integer number = customLinkedList.get(0);
        customLinkedList.remove(0);
        customLinkedList.contains(1);
        customLinkedList.addAll(List.of(1, 2, 3, 4, 5));


        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);





        CustomLinkedList<Integer> resalt = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(
                        new CustomLinkedList<>(),
                        (list, value) -> {
                            list.add(value);
                            return list;
                        },
                        (v1, v2) -> {
                            v1.addAll(new ArrayList<>((Collection) v2));
                            return v1;
                        }
                );


        for (int i = 0; i < resalt.getSize(); i++) {
            System.out.println(resalt.get(i));
        }



    }
}