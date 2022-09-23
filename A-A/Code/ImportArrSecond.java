import java.util.Arrays;
public class ImportArrSecond {
    
    public static void main(String[] args) {
        
        // 创建两个长度为 5 的数组
        int[] oArr1 = new int[5];
        int[] oArr2 = new int[5];

        System.out.println("=========== 基础赋值操作开始 ===========");
        // 数组 oArr1 赋值为 10
        for (int i = 0; i < oArr1.length; i++) {
            oArr1[i] = 10;
        }

        // 打印 oArr1 数组
        System.out.println("oArr1 数组的值为: " + Arrays.toString(oArr1));
        System.out.println("=========== 基础赋值操作结束 ===========");

        System.out.println("=========== 数组 fill 赋值开始 ===========");
        // 数组 oArr2 赋值为 20
        Arrays.fill(oArr2, 20);

        // 打印 oArr2 数组
        System.out.println("oArr2 数组的值为: " + Arrays.toString(oArr2));
        System.out.println("=========== 数组 fill 赋值结束 ===========");

    }
}
