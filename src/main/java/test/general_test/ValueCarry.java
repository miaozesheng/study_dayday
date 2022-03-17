package test.general_test;

public class ValueCarry {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("miaozesheng");
        person.setAge(13);
        testValueCarry(person);
        System.out.println(person);
        System.out.println(person.toString());

        int a = 10;
        testObjectValue(a);
        System.out.println(a);

        double x = 2.0;
        System.out.println(x);
    }

    public static void testValueCarry(Person person){
        person.setName("liu");
        person.setAge(14);
    }

    public static void testObjectValue(int a){
        a = 12;
    }
}
