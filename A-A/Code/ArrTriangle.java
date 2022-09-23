import java.util.Arrays;
import java.util.Scanner;
public class ArrTriangle {
    
    public static void main(String[] args){
       
        System.out.println("请用户输入一个整数:");
        Scanner oSc = new Scanner(System.in);
        int iNum = oSc.nextInt();

        // 创建一个对应用户输入行数的数组, 二维数组处暂不声明
        int[][] oArrs = new int[iNum][];

        // 初始化二维数组
        for(int i = 0; i < iNum; i++){
            oArrs[i] = new int[i+1];
        
            for(int j = 0; j < i + 1; j++){
                oArrs[i][j] = 0 == j || j == i ? 1 : oArrs[i-1][j-1] + oArrs[i-1][j];
            }
        }

        for(int i = 0; i < iNum; i++){
            System.out.println(Arrays.toString(oArrs[i]));
        }

        oSc.close();
    }
}
