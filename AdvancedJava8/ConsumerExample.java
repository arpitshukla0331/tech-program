package AdvancedJava8;

import java.util.function.Consumer;

public class ConsumerExample {

}
class Employee {
    String name;

    Employee(String name) {
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Gyan");
        Consumer<Employee> consumer = x-> x.setName("Arpit");
        consumer.accept(e);
        System.out.println("Update name :" + e.getName());
    }
}
