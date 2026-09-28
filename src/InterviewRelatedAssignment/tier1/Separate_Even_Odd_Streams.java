package InterviewRelatedAssignment.tier1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Separate_Even_Odd_Streams {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> result = num.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even: " + result.get(true));
        System.out.println("Odd: " + result.get(false));
    }
}
