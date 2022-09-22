public class IsMin {

    // 定义一个随机函数,max min为随机数的范围
    public static int getRandom(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void main(String[] ages) {

        // oArr.length = 5;
        int[] oArr = new int[5];

        // 对 oArr 进行初始化
        for (int oLet = 0; oLet < oArr.length; oLet++) {
            // 使用 getRandom() 函数初始化 oArr 配置随机数
            oArr[oLet] = getRandom(100, 1);
            // 输出 oArr[oLet] 项
            System.out.println("No." + oLet + " : " + oArr[oLet]);
        };

        // 设置初始值为 oArr 的第一个元素
        int oMin = oArr[0];

        // 对 oArr 进行遍历,查找最小值
        for (int oLet = 0; oLet < oArr.length; oLet++) {

            // 判断 oArr[oLet] 是否小于 oMin
            if (oArr[oLet] < oMin) {
                // 如果小于,则 oMin 等于 oArr[oLet]
                oMin = oArr[oLet];
            };
        };

        // oMin
        System.out.println("最小值为 : " + oMin);
    }
}