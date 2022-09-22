public class ThisUsageMethodSecond {
    
    // 创建两个变量
    String name;
    int age;

    // 创建一个构造方法
    ThisUsageMethodSecond(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 创建一个 * 年龄提升 * 方法
    void oUp() {
        age ++;
    }

    // 创建一个 * 打印 * 方法
    void oPrint() {

        // todo: 假设此处想要在每次打印时，年龄提升一岁, 可以使用 this 关键字
        this.oUp();

        // 打印变量
        System.out.println("姓名：" + name + "，年龄：" + age);
    }

    // 创建一个 * 获取当前对象 * 方法
    ThisUsageMethodSecond oGet() {
        return this;
    }


    // 创建一个 * Main * 方法
    public static void main(String[] args) {

        // 创建一个对象
        ThisUsageMethodSecond oTums = new ThisUsageMethodSecond("张三", 18);

        // todo: 此处直接调用 oPrint 方法
        oTums.oPrint();

        // todo: 此处调用 oGet 方法，获取当前对象
        ThisUsageMethodSecond oTums2 = oTums.oGet();

        // 打印测试
        System.out.println("oTums: " + oTums);
        System.out.println("oTums2: " + oTums2);
    }
}
