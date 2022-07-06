import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Palpitate Yzr
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list3 = new ArrayList();
        list.add("111");
        list.add("222");
        list2.add("2111");
        list2.add("2222");
        list3.add(list);
        list3.add(list2);
        Iterator i = list3.iterator();
        while (i.hasNext()){
            ArrayList next = (ArrayList) i.next();
            Iterator i2 = next.iterator();
            while (i2.hasNext()){
                System.out.println(i2.next());
            }
        }

    }
}
