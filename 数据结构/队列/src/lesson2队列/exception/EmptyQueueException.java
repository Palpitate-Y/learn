package lesson2队列.exception;

/**
 * @author Palpitate Yzr
 */
public class EmptyQueueException extends RuntimeException{
    /**
     * 初始化
     * @param message 异常描述
     * */
    public EmptyQueueException(String message) {
        super(message);
    }

}
