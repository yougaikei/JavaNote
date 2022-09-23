import java.util.Arrays;
public class ImportArrThird {
    
    public static void main(String[] args){

        // 创建两个数组
        int[] oArr1 = new int[5];
        int[] oArr2 = new int[5];
        
        // 填充两个数组 10
        Arrays.fill(oArr1, 10);
        Arrays.fill(oArr2, 10);

        // 使用 Arrays.equals() 方法比较两个数组
        System.out.println("oArr1 和 oArr2 数组是否相等: " + (Arrays.equals(oArr1, oArr2)? "IsTrue": "IsFalse" ));
    }
}
