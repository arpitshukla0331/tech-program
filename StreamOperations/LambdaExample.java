package StreamOperations;

public class LambdaExample {

    public static int method() {
        try {
            System.out.println("Try Block with return type");
            return 10;
        } finally {
            System.out.println("Finally Block always execute");
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(method());
    }
}
