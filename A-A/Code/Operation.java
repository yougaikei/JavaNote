public class Operation {

    public static void main(String[] args) {
        // 强制类型转换
        int iA = 10;
        int iB = 20;

        // 将 int 类型的 iA 转换为 double 类型
        double dA = (double) iA;

        // 这里重新输出一下 iA 和 dA 的值
        System.out.println("iA = " + iA);
        System.out.println("dA = " + dA);

        // 接下来于 iA 进行运算 ( 一个即可，两个有点多余，只会加重代码量 )
        System.out.println("dA + iB 的值为：" + (dA + iB));

    }

}