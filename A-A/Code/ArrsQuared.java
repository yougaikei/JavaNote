import java.util.Arrays;
public class ArrsQuared {
    
    public static void main(String[] args){
        int[] oArr = new int[5];

        int[][] oArrs = new int[5][5];

        Arrays.fill(oArr, 5);
        System.out.println("---------- 一维数组 ----------");
        System.out.println(Arrays.toString(oArr));

        for (int i = 0; i < oArrs.length; i++) {
            Arrays.fill(oArrs[i], i + 1);
        }

        System.out.println("---------- 二维数组 ----------");
        for (int i = 0; i < oArrs.length; i++) {
            System.out.println(Arrays.toString(oArrs[i]));
            System.out.println("=============================");
        }
    }
}
