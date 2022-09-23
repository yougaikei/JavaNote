import java.util.Arrays;
public class ImportArrFirst {
    
    public static void main(String[] args){

        // A. 声明一个数组; init: 5, 10, 15, 20, 25
        int[] oArr = {5, 10, 15, 20, 25};

        // B. 原始打印数组
        System.out.println("---------- 原始打印数组 ----------");
        System.out.print("[");
        for(int i = 0; i < oArr.length; i++){
            System.out.print(oArr[i] + (i == oArr.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        // C. 使用 Arrays.toString() 打印数组
        System.out.println("---------- Arrays.toString() ----------");
        System.out.println(Arrays.toString(oArr));
    }
    
}
