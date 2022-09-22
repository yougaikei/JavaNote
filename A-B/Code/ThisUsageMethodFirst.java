public class ThisUsageMethodFirst {

    // 创建两个成员变量
    String name;
    int age;
    
    // 创造一个构造方法
    ThisUsageMethodFirst(String name, int age){
        // 此处使用 this 关键字; 代表当前对象 => this.name == 我的 name 而不是形参的 name
        // 而 this.age == 我的 age 而不是形参的 age, 这样赋值的话就不会出现形参给形参赋值的情况
        // 从而避免了错误输出
        this.name = name;
        this.age = age;
    }

    // 创建一个空的成员方法, 避免报错
    void show(){}

    // 创建一个成员方法
    void show(int age){
        this.age += age;

        // 此处因为姓名没有分歧, 所以直接输出
        // 而年龄有分歧, 所以使用 this.age 输出
        System.out.println("B.姓名: " + name + ", 年龄: " + this.age);
    }

    // 创建一个 Main 方法
    public static void main(String[] args) {
        ThisUsageMethodFirst obj = new ThisUsageMethodFirst("张三", 20);
        System.out.println("A.姓名: " + obj.name + ", 年龄: " + obj.age);
        obj.show(5);
    }

}
