public class Multiple {

    public static void main(String[] args) {
        // 创建一个 int 类型的累加器
        int iSum = 0;

        // 创建一个 for 循环, 内容 1 ~ 100
        for(int i = 0; i < 100; i++){

            // 判断 i 是否是 3 和 5 的倍数
            if(i % 3 == 0 && i % 5 == 0){
                // 如果是, 则累加
                iSum += i;
            }

        }

        // 输出累加结果
        System.out.println(iSum);
    }

}