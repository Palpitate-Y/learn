/**
 * @author Palpitate Yzr
 */
public class DiGui {
    /*
     * 25>2+5=7
     * 665>6+6+5=17>1+7=8
     * */
    public int solution(int x) {
        //获得x的所有位数 如果是个位数（<10）进行返回
        //每一个位数进行相加 得数>10 递归 直到＜10返回
        if (x < 10) return x;
        int result = 0;
        // %10获得个位数  /10获得前面几位数 （如果这个数>10 再次%10 /10）
        //17 result>10 递归
        while (x > 0) {
            result += x % 10;
            x = x / 10;
        }
        if (result>10){
           return this.solution(result);
        }
        return result;
    }

    public static void main(String[] args) {
        DiGui diGui=new DiGui();
        System.out.println(diGui.solution(823988));
    }
}
