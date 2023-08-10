package StreamOperations;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SortingBasedOnTwoField {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(24, "Arpit", 28, "Male", "IT", 2019, 50000),
                new Employee(22, "Shyam", 29, "Male", "Admin", 2020, 40000),
                new Employee(25, "Anushka", 24, "Female", "LifeScience", 2021, 20000),
                new Employee(20, "Ravi", 21, "Male", "IT", 2020, 80000),
                new Employee(20, "Shanila", 19, "Female", "HR", 2022, 40000)
        );
        /*List<Employee> filterBasedOnIT = employeeList.stream().filter(x -> x.getDepartment().equals("IT")).collect(Collectors.toList());
        System.out.println(filterBasedOnIT);*/





        Integer integer = employeeList.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder())
                .skip(2).findFirst().get();
        System.out.println("Nth higheest :" + integer);

        //MULTIPLE FILTER using SINGLE stream api:
        List<Employee> multipleFilter = employeeList.stream()
                .filter(x -> x.getGender().equals("Female"))
                .filter(x -> x.getAge() > 19)
                .filter(x -> x.getSalary() > 10000)
                .sorted((o1, o2) -> o1.getDepartment().compareTo(o2.getDepartment())).collect(Collectors.toList());
        System.out.println("Filter result based on :" + multipleFilter);

        //MULTIPLE SORTING in SINGLE stream query:
        List<Employee> sortingBasedOnLengthNameAndId = employeeList.stream().sorted((o1, o2) -> {
                    return o1.getName().length() - o2.getName().length();
                }).sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
                .sorted((o1, o2) -> o1.getId() - o2.getId()).collect(Collectors.toList());
        for (Employee each : sortingBasedOnLengthNameAndId) {
            System.out.println(each);
        }

        //Or we can do with Comparator function also:
        List<Employee> sortedBasedOnNameLengthAndSalary1 = employeeList.stream()
                .sorted(Comparator.comparingInt(o -> o.getName().length()))
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());
        for (Employee each : sortedBasedOnNameLengthAndSalary1) {
            System.out.println(each);
        }

    }
}
