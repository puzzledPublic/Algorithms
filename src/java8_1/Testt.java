package java8_1;

public class Testt {
    public static void main(String[] args) {
        System.out.println(test(Testt.class));
        System.out.println(test("Testt"));
    }

    static String test(String name) {
        return "true";
    }

    static String test(Class<?> clazz) {
        return "clazz";
    }
}
