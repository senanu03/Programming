package StreamAssignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Assignment2 {
    public static void main(String[] args) {
        //1. Filter Even Numbers and Calculate Sum
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int n1 = l1.stream()
                .filter(n->n%2==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(n1);


        //2 transform every element to uppercase using streams and collect the result into a new list
        List<String> l2 = Arrays.asList("java", "python", "stream", "lambda");
        List<String> l3 = l2.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(l3);

        //3 count how many strings start with the letter ⁠'A'⁠ (case-insensitive).
        List<String> l4 = Arrays.asList("Apple", "Banana", "avocado", "Cherry", "Apricot");
        long n2 = l4.stream()
                .filter(n->n.toUpperCase().startsWith("A"))   //or filter(s -> s.startsWith("A") || s.startsWith("a"))
                .count();
        System.out.println(n2);

        //4. Find the Maximum Number in a List
        List<Integer> l5 = Arrays.asList(15, 42, 8, 99, 23, 54);
        Optional<Integer> l6 = l5.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst();
        System.out.println(l6);

//        int max = l5.stream()
//                .max(Comparator.naturalOrder())
//                .orElse(0);
//
//        System.out.println(max);

        //5. remove all duplicates and return the unique elements sorted in ascending order
        List<Integer> l7 = Arrays.asList(5, 2, 8, 2, 5, 1, 9, 1);
        List<Integer> l8 = l7.stream()
                .distinct()
                .sorted().toList();
        System.out.println(l8);

        List<Integer> l9 = l7.stream().distinct().sorted()
                .collect(Collectors.toList());
        System.out.println(l9);


    }
}
