package lesson1稀疏数组;

/**
 * @author Palpitate Yzr
 */
public class Lesson1 {
    /*稀疏数组*/
    public static void main(String[] args) {
        int [][] array={
                {0,0,0,10,0,0,0},
                {0,0,1,0,0,0,0},
                {0,0,2,0,0,0,2},
                {0,0,0,0,0,0,1},
                {0,0,4,0,0,0,28},
                {0,0,0,1,0,0,0},
        };
        for (int[] ints :array) {
            for (int anInt: ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] sparseArray = SparseArrayUtil.parseArray(array, 0);
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] arraySparse = SparseArrayUtil.arrayParse(sparseArray,7);
        for (int[] ints : arraySparse) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
