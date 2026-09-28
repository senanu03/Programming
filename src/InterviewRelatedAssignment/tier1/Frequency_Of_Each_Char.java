package InterviewRelatedAssignment.tier1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency_Of_Each_Char {
    public static Map<Character, Long>
    characterFrequency(String s) {

        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()));
    }

    public static void main(String[] args) {

        String s = "programming";

        Map<Character, Long> frequency = characterFrequency(s);

        System.out.println(frequency);
    }
}
