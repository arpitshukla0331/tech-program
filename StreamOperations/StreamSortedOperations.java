package StreamOperations;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamSortedOperations {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Guava");
        fruits.add("Banana");
        fruits.add("Lichi");

        //Sort employee by salary in ascending order:
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000));
        employeeList.add(new Employee(122, "Kaushal Jani", 25, "Male", "Sales And Marketing", 2015, 13500));
        employeeList.add(new Employee(133, "Harshil Nagar", 29, "Male", "Infrastructure", 2012, 18000));
        employeeList.add(new Employee(144, "Raj Darbar", 28, "Male", "Product Development", 2014, 32500));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700));
        employeeList.add(new Employee(166, "Sid Barot", 43, "Male", "Security And Transport", 2016, 10500));
        employeeList.add(new Employee(177, "Pruthvi Soni", 35, "Male", "Account And Finance", 2010, 27000));
        employeeList.add(new Employee(188, "Parth Dabgar", 31, "Male", "Product Development", 2015, 34500));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500));
        employeeList.add(new Employee(200, "Ashish Patel", 38, "Male", "Security And Transport", 2015, 11000));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 1570));
        employeeList.add(new Employee(222, "Aaalap Patel", 25, "Male", "Product Development", 2016, 28200));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300));
        employeeList.add(new Employee(244, "Divyesh Solanki", 24, "Male", "Sales And Marketing", 2017, 10700));
        employeeList.add(new Employee(255, "Jay Solanki", 23, "Male", "Infrastructure", 2018, 12700));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900));
        employeeList.add(new Employee(277, "Kishan Panchal", 31, "Male", "Product Development", 2012, 35700));


        System.out.println("-------------------------------");

        //Sorted the Fruits with ASCENDING ORDER using NATURAL SORTED order:
        List<String> sortedList = fruits.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList);

        //sorted stream using LAMBDA expression in ASCENDING ORDER:
        List<String> result = fruits.stream()
                .sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(result);

        //DEFAULT SORTED in ASCENDING ORDER:
        List<String> result1 = fruits.stream().sorted().collect(Collectors.toList());
        System.out.println("default sorted-->" + result1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //Sorted stream using LAMBDA expression in DESCENDING ORDER :
        List<String> result3 = fruits.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("fruits result 3 --> " + result3);

        //DESCENDING ORDER using LAMBDA expression:
        List<String> result4 = fruits.stream()
                .sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println("fruits result 4 --> " + result4);
        System.out.println("----------------------------------");


        //using LAMBDA expression to FIND SALARY in ASCENDING ORDER:
        List<Employee> employeeSortedList = employeeList.stream()
                .sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
        System.out.println("ascending list using lambda --> " + employeeSortedList);

        //we use Comparator instead of above lambda expression we're using METHOD reference in ASCENDING:
        List<Employee> employeeSortedList2 = employeeList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList());
        System.out.println("ascending list using Comparator method reference --> " + employeeSortedList2);

        System.out.println("-------------------------------");

        //using lambda expression to FIND SALARY in DESCENDING ORDER:
        List<Employee> employeeSortedList1 = employeeList.stream()
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
        System.out.println("descending list  -->" + employeeSortedList1);

        //we use Comparator instead of above lambda expression we're using method reference in DESCENDING:
        List<Employee> employeeSortedList3 = employeeList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("descending using reversed() --> " + employeeSortedList3);

        //SORTED the LIST by NAME in ASCENDING ORDER:
        List<Employee> employeeSortedList4 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(employeeSortedList4);

        //using lambda expression SORTED NAMES:
        employeeList.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());

        //SORTED the LIST by NAME in DESCENDING ORDER:
        List<Employee> employeeSortedList5 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.println(employeeSortedList5);
        System.out.println("----********-------");

        //FIND the MAXIMUM SALARY in employee list :
        Optional<Employee> employeeSorted6 = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeSorted6);

        //find the MINIMUM SALARY in employee list :
        Optional<Employee> employeeSorted7 = employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeSorted7);

        //***find the SECOND MAXIMUM SALARY in employee list :
        Optional<Employee> employeeSorted8 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed()).skip(1).findFirst();
        System.out.println("Second highest salary :" + employeeSorted8);



    }


}

