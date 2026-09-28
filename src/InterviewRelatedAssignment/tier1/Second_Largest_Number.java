package InterviewRelatedAssignment.tier1;

import java.util.*;

public class Second_Largest_Number {
    public static void main(String[] args) {


        //Using Streams:
        List<Integer> numbers = Arrays.asList(10, 40, 20, 30, 50);

        Integer secondHighest = numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondHighest);

        TreeSet<Integer> set = new TreeSet<>(numbers);

        set.pollLast(); // remove highest

        System.out.println("Second highest: " + set.last());

    }
}
