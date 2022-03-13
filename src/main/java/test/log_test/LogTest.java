package test.log_test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description 快速搭建lobback日志框架,记录程序的执行情况,记录到控制台 文件中
 *
 * @author miaozesheng 2022/03/13 13:00
 */
public class LogTest {

    // 创建logback的日志对象
    public static final Logger LOGGER = LoggerFactory.getLogger("LogTest.class");

    public static void main(String[] args) {
            try{
                LOGGER.debug("main方法开始执行了");
                LOGGER.info("我开始第二行日志了");
                int a  = 10 ;
                int b = 0;
                LOGGER.trace(String.valueOf(a));
                System.out.println(a/b);
            }catch (Exception e){
                e.printStackTrace();
                LOGGER.error("错误");
            }


    }
}
