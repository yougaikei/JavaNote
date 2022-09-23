public class ArrFirst {
    
    public static void main(String[] args) {

        // 创建一个长度为 5 的 int 类型的数组
        int[] oArr = new int[5];
        System.out.println("数组的长度为：" + oArr.length);

        for (int i = 0; i < oArr.length; i++) {
            System.out.println("第" + (i + 1) + " 个为: " + oArr[i]);
        }

        System.out.println("--------------------");
        for(int i = 1; i <= oArr.length; i++) {
            int j = i - 1;
            oArr[j] = i * 11;
            System.out.println("第" + i + " 个为: " + oArr[j]);
        }

        System.out.println("---------- 遍历数组结束 ----------");

        // 插入操作
        System.out.println("---------- 插入操作开始 ----------");
        int[] nArr = new int[6];
        for(int i = 1; i < nArr.length; i++) {
            int j = i - 1;
            nArr[j] = i * 11;
            System.out.println("第" + i + " 个为: " + nArr[j]);
        }

        System.out.println("---------- 查询遍历修改到第 5 位的结果 ----------");
        for (int i = 0; i < nArr.length; i++) {
            System.out.println("第" + (i + 1) + " 个为: " + nArr[i]);
        }

        // 通过以上打印结果可以看到第 6 个元素的值为 0

        // 此处将 99 插入到第一个
        for(int i = nArr.length - 1; i > 0; i--) {
            nArr[i] = nArr[i - 1];
        }

        // 再次打印
        System.out.println("---------- 查询后移 ------------");
        for (int i = 0; i < nArr.length; i++) {
            System.out.println("第" + (i + 1) + " 个为: " + nArr[i]);
        }

        // 将最终的第 0 位覆盖为 99
        nArr[0] = 99;
        System.out.println("---------- 查询最终结果 ------------");
        for (int i = 0; i < nArr.length; i++) {
            System.out.println("第" + (i + 1) + " 个为: " + nArr[i]);
        }

        System.out.println("--------------------");

    }
}
