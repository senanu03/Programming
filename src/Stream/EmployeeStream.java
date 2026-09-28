//
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class EmployeeStream {
//    public static void main(String[] args) {
//        List<Employee> employees = Arrays.asList(
//                new Employee(101, "Anu", 25, "Female", "Engineering", 75000),
//                new Employee(102,"Alice", 28, "Female", "HR", 65000),
//                new Employee(103,"Bob", 35, "Male", "Engineering", 85000),
//                new Employee(104,"Charlie", 42, "Male", "Engineering", 95000),
//                new Employee(105,"Diana", 31, "Female", "HR", 72000),
//                new Employee(106,"Eve", 25, "Female", "Engineering", 68000),
//                new Employee(107,"Frank", 45, "Male", "Sales", 110000),
//                new Employee(108,"Grace", 29, "Female", "Sales", 75000)
//        );
//
//        /// Part 1: Filtering & Mapping (Basic)
//        //1. Filter High Earners: Find all employees earning more than $70,000 and return their names as a List<String>.
//        List<String> highEarners = employees.stream().filter(emp -> emp.getSalary()>70000).map(Employee :: getName).collect(Collectors.toList());
//        System.out.println("High Earners " + highEarners);
//
//        //2: Department Filter: Find all female employees working in the "HR" department.
//        List<Employee> hrFemales = employees.stream()
//                                            .filter(emp -> "HR"
//                                            .equalsIgnoreCase(emp.getDepartment()))
//                                            .filter(emp -> "Female".equalsIgnoreCase(emp.getGender()))
//                                            .collect(Collectors.toList());
//        System.out.println("Female Employees in HR: " + hrFemales);
//
//        //3. Extract Names: Collect all unique department names present in the organization.
//        List<String> uniqueDepartments = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
//        System.out.println("Unique Departments: " + uniqueDepartments);
//
//        /// Part 2: Aggregation & Statistics (Intermediate)
//        //4. Average Salary: Calculate the average salary of all employees in the "Engineering" department.
//        double avgEngineeringSalary = employees.stream().filter(emp -> "Engineering".equalsIgnoreCase(emp.getDepartment())).mapToDouble(Employee::getSalary).average().orElse(0.0);
//        System.out.printf("Average Engineering Salary: $%.2f%n", avgEngineeringSalary);
//
//        //5. Count Employees: Count how many employees are over 30 years old.
//        long overThirtyCount = employees.stream().filter(emp -> emp.getAge() > 30).count();
//        System.out.println("5. Number of Employees Over 30: " + overThirtyCount);
//
//        //6. Max/Min Search: Find the employee with the highest salary in the entire company.
//        Optional<Employee> highestEarner = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        if (highestEarner.isPresent()) {
//            Employee emp = highestEarner.get();
//            System.out.println("Highest Earner: ID " + emp.getId() + " - " + emp.getName() + " ($" + emp.getSalary() + ")");
//        }
//
//        /// Part 3: Grouping & Sorting (Intermediate/Advanced)788
//        //7. Group by Department: Group all employees by their department (Map<String, List<Employee>>).
//        Map<String, List<Employee>> employeesByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println("Employees Grouped by Department:");
//        employeesByDept.forEach((dept, list) -> {
//            List<String> names = list.stream().map(emp -> emp.getName() + " (ID: " + emp.getId() + ")").collect(Collectors.toList());
//            System.out.println("   " + dept + ": " + names);
//        });
//
//        //8. Gender Count: Count the number of male and female employees (Map<String, Long>).
//        Map<String, Long> countByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println("8. Gender Breakdown: " + countByGender);
//
//        //9. Sorting: Sort all employees by salary in descending order and print the top 3 highest earners.
//        List<Employee> top3Earners = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
//        System.out.println("9. Top 3 Highest Earners:");
//        top3Earners.forEach(emp -> System.out.println("   - ID " + emp.getId() + " | " + emp.getName() + ": $" + emp.getSalary()));
//    }
//}
