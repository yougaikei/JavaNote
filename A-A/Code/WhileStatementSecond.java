// 引入 java.util.Scanner 类
import java.util.Scanner;

public class WhileStatementSecond {
    
    public static void main(String[] args){

        // 此处开始用 while 循环来实现
        // 创建一个 Scanner 对象
        Scanner oSc = new Scanner(System.in);

        // 对用户进行提示: 请输入一个整数
        System.out.println("请输入一个整数: ");

        // 从控制台接收一个整数
        int iNum = oSc.nextInt();

        // 定义一个带有小数的变量
        double dSum = 0.0;

        // 定义一个变量, 用来记录循环的次数
        int i = 1;

        // 开始用 while 循环来实现
        while(i <= iNum) {

            // 此处需要注意: 1.0 是因为如果不写 1.0 而写 1 的话, 
            // 会被当成整数来处理, 除了 1 / 1 会得到 1, 其余的都会得到 0
            dSum += 1.0 / iNum;

            // 每次循环结束后, iNum 都要加 1
            iNum ++;
        }

        // 输出结果
        System.out.println("1 + 1/2 + 1/3 + ... + 1/" + iNum + " = " + dSum);

        oSc.close();
    }
}
