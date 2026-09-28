//package StreamAssignment;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class Assigment3new {
//    public static void main(String[] args) {
//
//        //1
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        List<Integer> result = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .map(n -> n * 2)
//                .collect(Collectors.toList());
//
//        System.out.println(result); // [4, 8, 12]
//
//        //2
//        List<String> names = Arrays.asList("john", "alice", "bob");
//
//        List<String> result = names.stream()
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());
//
//        System.out.println(result);  // [ALICE, BOB, JOHN]
//
//
//
//        //3
//        List<Integer> numbers = Arrays.asList(10, 5, 30, 20, 15);
//
//        int max = numbers.stream()
//                .reduce(Integer.MIN_VALUE, Integer::max);
//
//        int min = numbers.stream()
//                .reduce(Integer.MAX_VALUE, Integer::min);
//
//        System.out.println("Max: " + max); // 30
//        System.out.println("Min: " + min); // 5
//
//
//        //4
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//
//        String result = names.stream()
//                .collect(Collectors.joining(", ", "[", "]"));
//
//        System.out.println(result);// [Alice, Bob, Charlie]
//
//        /// Level 2: Intermediate Operations
//
//        //1
//        List<List<Integer>> nested = Arrays.asList(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(3, 4, 5),
//                Arrays.asList(5, 6, 7)
//        );
//
//        List<Integer> result = nested.stream()
//                .flatMap(List::stream)
//                .distinct()
//                .collect(Collectors.toList());
//
//        System.out.println(result);// [1, 2, 3, 4, 5, 6, 7]
//
//
//        //2
//        String input = "hello";
//
//        Map<Character, Long> frequency = input.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        LinkedHashMap::new,
//                        Collectors.counting()
//                ));
//
//        System.out.println(frequency);// {h=1, e=1, l=2, o=1}
//
//        //3
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        Map<Boolean, List<Integer>> result = numbers.stream()
//                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
//
//        System.out.println(result.get(true));  // [2, 4, 6]
//        System.out.println(result.get(false)); // [1, 3, 5]
//
//
//        //4
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 3);
//
//        Set<Integer> duplicates = numbers.stream()
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());
//
//        System.out.println(duplicates);// [2, 3]
//
//
//        //alternate
//        Set<Integer> seen = new HashSet<>();
//
//        Set<Integer> duplicates = numbers.stream()
//                .filter(n -> !seen.add(n))
//                .collect(Collectors.toSet());
//
//        /// Level 3: Domain Objects & Aggregations
//
//        List<Employee> employees = Arrays.asList(
//                new Employee("Alice", "IT", 80000),
//                new Employee("Bob", "HR", 60000),
//                new Employee("Charlie", "IT", 90000),
//                new Employee("David", "HR", 70000),
//                new Employee("Eva", "Finance", 75000)
//        );
//
//        //1
//        Map<String, List<Employee>> result = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//
//        //2
//        Map<String, Double> averageSalary = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.averagingDouble(Employee::getSalary)
//                ));
//
//        //3
//        Map<String, Optional<Employee>> highestPaid = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.maxBy(
//                                Comparator.comparingDouble(Employee::getSalary)
//                        )
//                ));
//
//        //alternate
//        Map<String, Employee> highestPaid = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(
//                                        Comparator.comparingDouble(Employee::getSalary)
//                                ),
//                                Optional::get
//                        )
//                ));
//
//
//
//
//        ///Level 4: Advanced Stream Patterns
//
//        //1
//        Character result = input.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        LinkedHashMap::new,
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .orElse(null);
//
//        System.out.println(result); // w
//
//        //2
//        Optional<Employee> secondHighest = employees.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
//                .skip(1)
//                .findFirst();
//
//        secondHighest.ifPresent(System.out::println);
//
//        //3
//        Map<String, String> result = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.mapping(
//                                Employee::getName,
//                                Collectors.joining(", ")
//                        )
//                ));
//
//
//        //4
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int target = 7;
//
//        List<List<Integer>> pairs = IntStream.range(0, numbers.size())
//                .boxed()
//                .flatMap(i -> IntStream.range(i + 1, numbers.size())
//                        .filter(j -> numbers.get(i) + numbers.get(j) == target)
//                        .mapToObj(j -> Arrays.asList(numbers.get(i), numbers.get(j))))
//                .collect(Collectors.toList());
//
//        System.out.println(pairs);// [[1, 6], [2, 5], [3, 4]]
//
//
//
//
//
//
//    }
//}
