package test.reflect_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/21 22:10
 */
public class Student {

    private static String ss1;

    protected static String ss2;

    public static String ss3;;

    private static final String sfs2 = "8888";

    public static final String sfs = "6666";

    public String s1;

    protected String s2;

    private String s3;

    public void testS1(){
        System.out.println("========s1=======");
    }

    protected  void testS2(){
        System.out.println("=======s2======");
    }

    private String testS3(String name){
        System.out.println("我们输出了s3"+name);
        return "学习反射真快乐!!!";
    }

    public static  void testSs1(){
        System.out.println("========ss1=======");
    }

    protected static void testSs2(){
        System.out.println("=======ss2======");
    }

    private static void testSs3(){
        System.out.println("======ss3=======");
    }

    public Student() {
    }

    private Student(String s1,String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public Student(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }


    public static String getSs1() {
        return ss1;
    }

    public static void setSs1(String ss1) {
        Student.ss1 = ss1;
    }

    public static String getSs2() {
        return ss2;
    }

    public static void setSs2(String ss2) {
        Student.ss2 = ss2;
    }

    public static String getSs3() {
        return ss3;
    }

    public static void setSs3(String ss3) {
        Student.ss3 = ss3;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }
}
