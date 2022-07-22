package lesson2队列.exception;

/**
 * 队列已满异常
 * @author Palpitate Yzr
 */
public class FullQueueException extends RuntimeException{

    /**
     * 初始化
     * @param message 异常描述
     * */
    public FullQueueException(String message) {
        super(message);
    }
}
