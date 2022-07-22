package lesson1稀疏数组;

/**
 * @author Palpitate Yzr
 */
public class SparseArrayUtil {



    /*稀疏数组工具类*/
    public static int getEffValueCount(final int[][] sourceArray,final int defaultValue){
        int effValueCount=0;
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                if (anInt!=defaultValue) effValueCount++;
            }
        }
        return effValueCount;
    }


    public static boolean shouldConvert(final int[][] sourceArray,final int defaultValue){
        //自身所占地址空间+数组所占地址空间
        int srcSpaceCount= sourceArray.length*sourceArray[0].length+ sourceArray.length;
        int effValueCount=SparseArrayUtil.getEffValueCount(sourceArray,defaultValue);

        int num2=3+effValueCount*3+(effValueCount+1);
        return num2<srcSpaceCount;
    }



    public static int[][] parseArray(int[][] array,int defaultValue){
        //行
        int rowCount=array.length;
        //列
        int colCount=array[0].length;
        //有效值个数
        int effValueCount=0;
        for (int[] ints :array) {
            for (int anInt: ints) {
                if (anInt!=defaultValue) effValueCount++;
            }
        }
        int[][] result=new int[effValueCount+1][3];
        result[0][0]=rowCount;
        result[0][1]=colCount;
        result[0][2]=effValueCount;
        int count=0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (array[i][j]!=0){
                    count++;
                    result[count][0]=i;
                    result[count][1]=j;
                    result[count][2]=array[i][j];
                }
            }
        }
        return result;
    }
    //final 代码里不能更改
    public static int[][] arrayParse(int[][] array,final int defaultValue){
        int row=array[0][0];
        int col=array[0][1];
        //先解析第一行数据
        int[][] result=new int[row][col];
/*        for (int[] ints : result) {
            for (int anInt : ints) {
                anInt=defaultValue;
            }
        }*/
if (defaultValue!=0){
    for (int i = 0; i < row ;i++) {
        for (int j = 0; j < col; j++) {
            result[i][j]=defaultValue;
        }
    }
}
        for (int i = 1; i < array.length ; i++) {
            //result的第几行第几列 等于什么值
            //行：array的第i行第一个数array[i][0]
            result[array[i][0]][array[i][1]]=array[i][2];
        }
        return result;
    }
}
