package test.annotation_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 22:14
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Desk {
    String value();
    double price() default 100.0;
    String [] authors ();
}
