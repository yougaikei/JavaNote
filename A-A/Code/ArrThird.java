import java.util.Scanner;

public class ArrThird {
    public static void main(String[] args) {

        // 提示用户输入
        System.out.println("请输入一个整数：");


        // 统计 用户输入的数字出现的次数
        Scanner oSc = new Scanner(System.in);

        // 读取用户输入的数字
        int iNum = oSc.nextInt();

        // 定义一个数组
        int[] oArr = new int[10];

        // 拆分数字
        int oI = iNum;
        while(oI > 0){
            oArr[oI %10] ++;
            oI = oI / 10;
        }

        // 输出结果
        for(int i = 0; i < oArr.length; i++){
            if(oArr[i] > 0){
                System.out.println(i + "出现了" + oArr[i] + "次");
            }
        }

        oSc.close();
    }
}