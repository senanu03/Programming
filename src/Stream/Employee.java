package Stream;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double salary;

    public Employee(int id, String name, int age, String gender, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Anu", 25, "Female", "Engineering", 75000),
                new Employee(102,"Alice", 28, "Female", "HR", 65000),
                new Employee(103,"Bob", 35, "Male", "Engineering", 85000),
                new Employee(104,"Charlie", 42, "Male", "Engineering", 95000),
                new Employee(105,"Diana", 31, "Female", "HR", 72000),
                new Employee(106,"Eve", 25, "Female", "Engineering", 68000),
                new Employee(107,"Frank", 45, "Male", "Sales", 110000),
                new Employee(108,"Grace", 29, "Female", "Sales", 75000)
        );

        


        // 4. Average Salary of Engineering Department

        double averageSalary = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Engineering"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println(averageSalary);


        // 5. Count Employees Older than 30

        long count = employees.stream()
                .filter(employee -> employee.getAge()>30)
                .count();
        System.out.println(count);


        // 6. Employee with Highest salary

        Employee highestSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println(highestSalary);


       // 7. group Employees dy department
        Map<String, List<Employee>> group = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        group.forEach((depart, emplist) -> {

                    System.out.println("\ndepartment"  + depart);

                    emplist.forEach(System.out::println);
                });

        // 8. Count male and female

        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);


       // 9. Top 3 Highest Paid Employee

        employees.stream()
                .sorted(Comparator.comparing(Employee:: getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);






    }

}
