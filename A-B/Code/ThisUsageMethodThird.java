public class ThisUsageMethodThird {
    
    // 创建一个变量
    String oName;

    ThisUsageMethodThird() {

        // 此处调用有参构造方法 ( ※ 注: 有无参构造方法中的 this() 语句都必须放在第一行 )
        this("未命名");

        // 输出当前状态
        System.out.println("========== 无参构造方法 ==========");
    }

    // 此处书写一个有参构造方法
    ThisUsageMethodThird( String oName ) {

        // 此处配置姓名
        this.oName = oName;

        // 输出当前状态
        System.out.println("========== 有参构造方法 ==========");
    }

    // 此处书写一个方法
    void printName() {

        // 此处输出姓名
        System.out.println("姓名: " + this.oName);

    }

    // 此处书写一个 * Main * 方法
    public static void main ( String[] args ) {

        // 创建一个对象
        ThisUsageMethodThird oTumt = new ThisUsageMethodThird();
        oTumt.printName();

    }

}