package StreamAssignment;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency_Of_Each_Character {
    public static void main(String[] args) {

        //1. Character Frequency Counter
        String s1 = "baabcda";
        Map<Character, Long> mp = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                       Function.identity(), Collectors.counting()
                ));

        System.out.println(mp);

        String s="baabcda";
        Map<Object, Long> map=s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(ch ->ch,Collectors.counting()));
        System.out.println(map);

        //2. Find First Non-Repeating Character
        char op = s1.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        ch->ch,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))

                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('0');
        System.out.println(op);


        //3. Partition Even and Odd Numbers
        List<Integer> l= Arrays.asList(1,2,3,4,5,6,7,8,9);

        Map<Boolean,List<Integer>> m=l.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(m);


        //4. Find the Second Highest Number

        int[] arr= {12,35,1,10,34,35};
        int a = l.stream()
                .distinct()

                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        // Optional<Integer> a = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(a);

        //5. Flatten and Flatten-Unique Strings
        //Input: ["hello world", "world of java", "hello java streams"]
        //Expected Output: ["hello", "java", "of", "streams", "world"]

        List<String> sen = Arrays.asList("hello world", "world of java", "hello java streams");

        List<String> result = sen.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
