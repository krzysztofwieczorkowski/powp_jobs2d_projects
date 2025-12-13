package edu.kis.powp.jobs2d.drivers;

import java.util.logging.Logger;
import edu.kis.powp.jobs2d.Job2dDriver;


public class LoggerDriver implements Job2dDriver {
    private final Logger logger;
    
    private int operationCount = 0;
    private int currentX = 0;
    private int currentY = 0;


    public LoggerDriver() {
        this(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
    }


    public LoggerDriver(Logger logger) {
        this.logger = logger;
    }


    public LoggerDriver(String loggerName) {
        this.logger = Logger.getLogger(loggerName);
    }


    @Override
    public void operateTo(int x, int y) {
        operationCount++;
        currentX = x;
        currentY = y;
        logger.info(String.format("operateTo: (%d, %d) [op: %d]", x, y, operationCount));
    }

    @Override
    public void setPosition(int x, int y) {
        operationCount++;
        currentX = x;
        currentY = y;
        logger.info(String.format("setPosition: (%d, %d) [op: %d]", x, y, operationCount));
    }


    public int getCurrentX() {
        return currentX;
    }


    public int getCurrentY() {
        return currentY;
    }

    public int getOperationCount() {
        return operationCount;
    }

    public void reset() {
        operationCount = 0;
        currentX = 0;
        currentY = 0;
        logger.info("LoggerDriver reset [op: 0]");
    }
}