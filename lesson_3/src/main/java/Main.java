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

        CustomLinkedList<Integer> list1 = new CustomLinkedList<>();


        stream.reduce(null, (l1, l2) -> {
            list1.add(l2);
            return null;
        });


    }
}