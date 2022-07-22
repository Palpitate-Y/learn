package lesson2队列;

/**
 *
 * @author Palpitate Yzr
 */
public class Lesson2 {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(8);
        arrayQueue.add("a");
        arrayQueue.add("b");
        arrayQueue.add("c");
        arrayQueue.add("d");
        System.out.println(arrayQueue);
/*        System.out.println( arrayQueue.get());
        System.out.println(arrayQueue.get());
        arrayQueue.get();
        arrayQueue.get();*/
        System.out.println(arrayQueue.elementsCount());
        System.out.println(arrayQueue);
        //arrayQueue.get();
        CirCleArrayQueue queue = new CirCleArrayQueue(5);
        queue.add("11");
        queue.add("22");
        queue.add("33");
        queue.add("44");
        queue.get();
        queue.get();
        queue.add("55");
        queue.add("66");
        System.out.println(queue);
    }
}
