package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class PrintEven {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(55);
        arr1.add(2);
        arr1.add(40);
        arr1.add(411);
        arr1.add(92);
        arr1.add(411);

        List<String> arr2 = Arrays.asList("Apple", "Guava", "Grapes", "Litchi", "Papaya");


        System.out.println("Even numbers: ");
        arr1.stream()
                .filter(n->n%2==0)
                .forEach(System.out::println);

        System.out.println("Odd numbers: ");
        arr1.stream()
                .filter(n->n%2!=0)
                .forEach(System.out::println);

        System.out.println("Numbers > 50: ");
        arr1.stream()
                .filter(n->n>50)
                .forEach(System.out::println);

//        System.out.println("Uppercase: ");
//        List<String> li = arr2.stream()
//                .map(n->n.toUpperCase(Locale.ROOT))
//                .collect(Collectors.toList());
//        System.out.println(li);

        System.out.println("Uppercase: ");
        List<String> li = arr2.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(li);

        System.out.println("Find String starting with A: ");
        arr2.stream()
                .filter(n->n.toUpperCase().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("Find String ending with a: ");
        List<String> li2 = arr2.stream()
                .filter(n->n.toLowerCase().endsWith("a"))
                .toList();
        System.out.println(li2);

        System.out.println("Find strings having length > 5 ");
        List<String> li3 = arr2.stream()
                .filter(n -> n.length()>5)
                .toList();
        System.out.println(li3);

        System.out.println("Remove duplicate elements");
        List<Integer> li4 = arr1.stream()
                .distinct()
                .toList();
        System.out.println(li4);

        System.out.println("Sort numbers in ascending order");
        List<Integer> li5 = arr1.stream()
                .sorted()
                .toList();
        System.out.println(li5);

        System.out.println("Sort numbers in descending order");
        List<Integer> li6 = arr1.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(li6);

        System.out.println("Find first element ");
//        int num1 = arr1.stream()
//                .limit(1)
//                .toList()
//                .get(0);
//        System.out.println(num1);

//        int num1 = arr1.stream()
//                .limit(1)
//                .findFirst()
//                .orElse(0);
//        System.out.println(num1);

        int num1 = arr1.stream()
                .findFirst()
                .orElse(0);
        System.out.println(num1);


        System.out.println("13. Find last element. ");
        int num2 = arr1.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0);
        System.out.println(num2);

        // 13. Find last element arr1.stream().reduce((first, second) -> second).ifPresent(System.out::println);
    }
}
