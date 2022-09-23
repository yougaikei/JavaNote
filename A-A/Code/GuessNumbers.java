import java.util.Random;
import java.util.Scanner;

public class GuessNumbers {
    

    public static void main(String[] args){

        // 猜数字游戏
        
        // 生成一个随机数
        int oNum = new Random().nextInt(100) + 1;

        // 猜测次数
        int oCount = 0;

        Scanner oSc = new Scanner(System.in);
        // 开始猜测
        while(true) {
            // 猜测次数加1
            oCount++;
            // 输入猜测的数字
            System.out.println("请输入你猜测的数字：");
            int UserNum = oSc.nextInt();
            // 判断猜测的数字是否正确
            if(UserNum == oNum) {
                System.out.println("恭喜你，猜对了！");
                System.out.println("你一共猜了" + oCount + "次");
                break;
            } else if(UserNum > oNum) {
                System.out.println("猜大了！");
            } else {
                System.out.println("猜小了！");
            }
        }
        oSc.close();
    }
}
