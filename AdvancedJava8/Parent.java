package AdvancedJava8;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Parent {
    void m1();
}

interface Child extends Parent {
    void m2();
}

interface SubChild extends Child {
    void m3();
}

@FunctionalInterface
interface GrandChild extends Parent {
    void m1();
}

class Test implements Parent, Child, SubChild, GrandChild {

    @Override
    public void m1() {
        System.out.println("Parent call");
    }

    @Override
    public void m2() {
        System.out.println("Child call");
    }

    @Override
    public void m3() {
        System.out.println("sub-child call");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.m1();
        t.m2();
        t.m3();

        List<Integer> number = Arrays.asList(2,3,4,5);
        int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans + i);
        System.out.println(even);
    }
}
