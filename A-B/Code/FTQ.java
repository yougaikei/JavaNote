// 导入 Scanner 类
import java.util.Scanner;

public class FTQ {
    /**
     * todo: (FactorialTestQuestions)
     * 编程实现求阶乘的方法
     */

    int oFactorial(int oNum) {
        // 定义一个累加器
        int sum = 1;
        // 定义一个阶乘的累乘器
        for ( int i = 1; i <= oNum; i++ ) {
            sum *= i;
        }
        return sum;
    }

    int oFtqs( int i ) {
        // 如果 i == 1, 返回 1
        if ( i == 1 ) return 1;

        // 如果 i 不为 1, 返回 i * oFtqs(i - 1)
        // 递归调用, 每次调用都会将 i - 1 传入
        // 直到 i == 1, 返回 1
        /**
         *  若 i = 5 时:
         *  !5 => 5 * !4
         *  !4 => 4 * !3
         *  !3 => 3 * !2
         *  !2 => 2 * !1
         *  !1 => 1
         */
        return i * oFtqs( i - 1 );
    }

    public static void main(String[] args){
        
        // 创建一个 Scanner 对象
        Scanner oInput = new Scanner(System.in);
        // 提示用户输入一个数字
        System.out.print("请输入一个数字: ");
        // 接收用户输入的数字
        int oNum = oInput.nextInt();
        // 创建一个 FTQ 对象
        FTQ oFtq = new FTQ();
        // 调用 oFactorial 方法
        int oResult = oFtq.oFactorial(oNum);
        // 输出
        System.out.println(oNum + " 的阶乘是: " + oResult);

        // 调用 oFtqs 方法
        int oResult2 = oFtq.oFtqs(oNum);
        // 输出
        System.out.println(oNum + " 的阶乘是( 便捷 ): " + oResult2);

        oInput.close();
    }
}
