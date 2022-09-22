public class ConstructionMethodFirst {
    
    String name;
    int age;

    // 这是一个初始化的缺省构造方法; 为了防止空调用出错
    public ConstructionMethodFirst() {}

    // 这是一个构造方法
    public ConstructionMethodFirst( String oName, int oAge ) {
        
        // System.out.println("This is the first construction method");

        // 通过构造默认值, 对其初始化 ( init: Tom, 10 )
        /**
         * name = "Tom";
         * age = 10;
        */

        // 此处通过形参赋值的方式, 对齐附上不同的值
        name = oName;
        age = oAge;
    }

    // 这是一个类方法
    void sayHello() {
        System.out.println("Hello, " + name + ", you are " + age + " years old this year.");
    }

    public static void main(String[] args) {

        // 创建类
        // ConstructionMethodFirst oCMF = new ConstructionMethodFirst();

        // 创建类; 并传入实参 - 01
        ConstructionMethodFirst oCMF = new ConstructionMethodFirst("Tom", 10);

        // 输出类的属性
        oCMF.sayHello();

        // ! ========== End ==========

        // 创建类; 并传入实参 - 02
        ConstructionMethodFirst oCMF2 = new ConstructionMethodFirst("Jerry", 20);

        // 输出类的属性
        oCMF2.sayHello();

        // ! ========== End ==========

        // 创建类; 并传入空参 - 03; 
        /** 
         * 此处需要注意因为上方有一个 String oName && int oAge 的构造方法, 
         * 所以 Java 不会再帮我们创建一个空参的构造方法,如果书写此处时,自己没有写一个空参的构造方法,
         * 那么就会因为找不到空参的构造方法而报错 
         * ! ( Err )
         */
        ConstructionMethodFirst oCMF3 = new ConstructionMethodFirst();

        // 输出类的属性
        oCMF3.sayHello();
    }

}