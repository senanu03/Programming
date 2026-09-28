package InterviewRelatedAssignment.tier1;

import java.util.Arrays;
import java.util.List;

public class FindDuplicateElements {
    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);

        num.stream()
                .filter(n -> num.indexOf(n) != num.lastIndexOf(n))
                .distinct()
                .forEach(System.out::println);
    }
}
