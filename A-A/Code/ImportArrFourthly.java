import java.util.Arrays;
public class ImportArrFourthly {
    
    public static void main(String[] args) {
        int[] oArr = { 2, 3, 1, 4, 5, 9, 6, 8, 7 };
        System.out.println("------ 排序前的数组 ------");
        System.out.println(Arrays.toString(oArr));
        System.out.println("--------------------");

        // 使用 Arrays.sort() 方法对数组进行排序
        Arrays.sort(oArr);
        System.out.println("------ 排序后的数组 ------");
        System.out.println(Arrays.toString(oArr));
        System.out.println("--------------------");

        // 使用 Arrays.binarySearch() 方法查找元素
        System.out.println("元素 5 在数组中的下标位置为: " + Arrays.binarySearch(oArr, 5));
    }
}
