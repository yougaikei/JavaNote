// 导入 java.util.Scanner 输入模块
import java.util.Scanner;

public class Menu {

    public static void main(String[] ages) {

        // 配置一个 Scanner 对象
        Scanner input = new Scanner(System.in);

        // 定义一个循环变量
        Boolean IsTrue = true;

        while (IsTrue) {

            // 输出菜单
            System.out.println("1. 新建");
            System.out.println("2. 打开文件");
            System.out.println("3. 保存");
            System.out.println("4. 刷新");
            System.out.println("5. 退出");

            // 接收用户输入
            int iNum = input.nextInt();

            // 判断用户输入
            switch (iNum) {
                case 1:
                    System.out.println("新建成功");
                    break;
                case 2:
                    System.out.println("打开文件");
                    break;
                case 3:
                    System.out.println("保存成功"); 
                    break;
                case 4:
                    System.out.println("刷新成功");
                    break;
                case 5:
                    System.out.println("正在退出...");
                    IsTrue = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }

        input.close();
    }
}