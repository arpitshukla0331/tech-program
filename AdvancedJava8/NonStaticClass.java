package AdvancedJava8;

public class NonStaticClass {
    public void m3() {
        System.out.println("Nonstatic");
    }

    public static void m4() {
        NonStaticClass nonStaticClass = new NonStaticClass();
        nonStaticClass.m3();
    }

    public static void main(String[] args) {
        m4();
        System.out.println("hell");
    }

}
