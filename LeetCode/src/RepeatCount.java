import java.util.HashMap;
import java.util.Locale;

/**
 * @author Palpitate Yzr
 */
public class RepeatCount {
    public int solution(String string){
        //找出字符串中重复出现的字母或数字的个数
        //存入hashmap k=字符 v=出现次数 因为出现次数大于1就加一（只加一次）
        //统计map中v>1的个数
        String s=string.toLowerCase();
        int v=1;
        HashMap<Object, Object> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c,v+1);
            }else {
                map.put(c,v);
            }
        }
        int result=0;
        for (Object value : map.values()) {
            Integer i= (Integer) value;
            if (i>1){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatCount repeatCount=new RepeatCount();
        System.out.println(repeatCount.solution("AAbc122"));
    }
}
