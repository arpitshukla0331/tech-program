package StreamOperations;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamAPIAllOperation {
    private static List<Employee> getEmployee() {
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
        return employeeList;

    }
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        //Who has MOST WORKING EXPERIENCE in Organization?
        Employee seniorMostEmployee = getEmployee().stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
        System.out.println("most working employee :" + seniorMostEmployee);

        //Q: How MANY MALE AND FEMALE employees are there in the organization?
        Map<String, Long> collect = getEmployee().stream()
                .collect(groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);

        //using lambda expression:
        Map<String, Long> countByGender = getEmployee().stream().map(e -> e.getGender())
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Group by gender count : " + countByGender);
        //----------------------------------------------------------------

        //Q:Print the NAME of ALL DEPARTMENTS in the organization?
        List<String> collect1 = getEmployee().stream()
                .map(e -> e.getDepartment()).distinct().collect(Collectors.toList());
        System.out.println("department names :" + collect1);

        System.out.println("--------------------------------------------------");

        //Find the Nth HIGHEST SALARY in employeeList :
        Optional<Integer> first = getEmployee().stream().map(e -> e.getSalary())
                .sorted(Comparator.reverseOrder()).skip(2).findFirst();
        System.out.println("Nth highest salary :" + first);


        //Highest Salary
        Map<String, Optional<Employee>> map = getEmployee().stream().collect(groupingBy(x -> x.getDepartment(),
                Collectors.maxBy(Comparator.comparingLong(y -> y.getSalary()))));
        map.entrySet().forEach(System.out::println);

        //Find TOP 5 records of employeeList?
        getEmployee().stream()
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .limit(5).collect(Collectors.toList()).forEach(System.out::println);

        //Youngest male
        int male = getEmployee().stream().filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .min(Comparator.comparing(Employee::getAge)).get().getAge();
        System.out.println("Youngest male and female :" + male);

        System.out.println("*************************************************");

        //TOTAL SALARIES in DEPARTMENT
        int sum = getEmployee().stream().mapToInt(i -> i.getSalary()).sum();
        System.out.println("sum of salaries in department :" + sum);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //COUNT NUMBER of EMPLOYEE in EACH DEPARTMENT:
        Map<String, Long> countEmployee = getEmployee().stream()
                .collect(groupingBy(x -> x.getDepartment(), Collectors.counting()));
        System.out.println("Count employee :" + countEmployee);

        //AVERAGE SALARY in EACH DEPARTMENT --> (same we can find other average field like age)
        Map<String, Double> averageSalary = getEmployee().stream()
                .collect(groupingBy(x -> x.getDepartment(), Collectors.averagingDouble(y -> y.getSalary())));
        System.out.println("Average salary department wise :" + averageSalary);

        //Get the details of the youngest male employee in product department
        Optional<Employee> youngMale = getEmployee().stream()
                .filter(x -> x.getGender().equalsIgnoreCase("Male")
                        && x.getDepartment().equals("Product Development"))
                .min(Comparator.comparing(Employee::getAge));
        System.out.println("details of the youngest male employee in product department :" + youngMale);

        //FIND Max Salary in Each Department
        Map<String, Employee> ByDepartmentHighestSalary = getEmployee().stream()
                .collect(groupingBy(x -> x.getDepartment(),
                 Collectors.collectingAndThen
                (Collectors.maxBy(Comparator.comparingInt(x -> x.getSalary())), Optional::get)));

        //Find total salaries in department

    }


}
