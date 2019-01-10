package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class TestLog4j {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    public void test1(){
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
        System.out.println("Hello World!");
    }

}
