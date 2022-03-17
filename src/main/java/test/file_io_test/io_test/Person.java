package test.file_io_test.io_test;

import java.beans.Transient;
import java.io.Serializable;

/**
 * description
 *
 * @author miaozesheng 2022/03/16 23:05
 */
public class Person implements Serializable {

    private String name ;

    private Integer age;

    private Boolean sex;

    private transient String test;//使用transient修饰的成员变量不参与序列化

    private static final long serialVersionUid = 1;
    //申明序列化的版本号,序列化的版本号反序列化的版本号一定要一致 如果新增字段,那么这里版本号应该加一
    // 下次使用的时候,反序列化会失败,必须先序列化,再反序列化才能正常访问数据

    public Person(String name, Integer age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
