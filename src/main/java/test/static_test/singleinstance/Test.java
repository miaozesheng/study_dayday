package test.static_test.singleinstance;

public class Test {
    public static final String A = "ab";

    public static void main(String[] args) {
        String s = "ab";
        String a = "a";
        String b = "b";
        String c = a+b;

        System.out.println(A);
        System.out.println(s);
        System.out.println(c);

        System.out.println(A==s);
        System.out.println(A==c);
        System.out.println(A==s.intern());
        System.out.println(A==c.intern());

    }
}
