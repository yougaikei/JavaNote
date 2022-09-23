// 引入 java.util.Scanner 模块
import java.util.Scanner;

public class IsClass {
    // 定义一个返回 max 和 min 中随机数的方法
    public static int getRandom(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {

        // 定义一个 Scanner 对象
        Scanner sc = new Scanner(System.in);

        // String `请输入一个整数`
        System.out.println("请输入班级人数(整数):");

        // 提示: 输入一个整数
        int oInput = sc.nextInt();

        // 创建一个 int 类型的数组，数组长度为 oInput
        int[] oArr = new int[oInput];

        // 向数组内添加随机数，每次随机数的范围为 0-100
        for (int i = 0; i < oInput; i++) {
            oArr[i] = getRandom(100, 0);
        }

        // 记录不合格的人数
        int oAborted = 0;

        // 遍历数组，判断每个数是否大于等于 60，如果不是，则 oAborted + 1
        for (int i = 0; i < oInput; i++) {
            if (oArr[i] < 60) {
                oAborted++;
            }
        }

        // 记录班级平均分
        double oAverage = 0;
        // 遍历数组，计算班级平均分
        for (int i = 0; i < oInput; i++) {
            oAverage += oArr[i];
        }
        // 计算班级平均分，且四舍五入保留两位小数
        oAverage = Math.round(oAverage / oInput * 100) / 100.0;

        // String `第 ${i} 人的分数：${oArr[i]}`
        for (int i = 0; i < oInput; i++) {
            System.out.println("第 " + (i + 1) + " 人的分数：" + oArr[i]);
        }

        // String `不及格人数为：${oAborted}`
        System.out.println("不及格人数为：" + oAborted);

        // String `班级平均分为：${oAverage}`
        System.out.println("班级平均分为：" + oAverage);

        // 关闭 Scanner 对象
        sc.close();

    }
}
