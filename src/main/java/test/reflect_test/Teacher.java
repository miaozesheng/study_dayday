package test.reflect_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/21 23:41
 */
public class Teacher {
    private String name;

    private int age;

    private boolean flag;

    public Teacher() {
    }

    public Teacher(String name, int age, boolean flag) {
        this.name = name;
        this.age = age;
        this.flag = flag;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
