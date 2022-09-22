# Java 面向对象编程

## 1. 语言分类

- C 语言是一门面向过程的语言
- C++ 语言 面向过程 + 面向对象 的语言
- Java 语言是纯面向对象的编程语言

---

## 2. 面向对象编程

- 类的定义

```java
package IsAA;

/**
 * public class 类名 {
 *    类体
 * }
 */

public class Names{
    // 主体部分
}
```

※ 注意: 通常情况下, 类名由多个英文单词组成 ( 单词需要包含功能的大致意思 ), 且每一个单词的首字母要求大写.

- 成员变量的定义

```java
package IsAA;

public class Names{
    // 数据类型 变量名 = 值;
    init oA = 123;
}
```

※ 注意: 通常情况下, 变量名由多个英文单词组成 ( 单词需要包含功能的大致意思 ), 且需要按照指定的方式去书写.

- 1、匈牙利命名法: 采用数据类型加单词名称的方式, 如: 对象类型: oData 中 o 代表的是 Object, 而后面的 Data 是对应的单词, 并首字母大写.
  如果实在不清楚它的开头简写是什么可以对照以下内容进行参考.

```js
const oData = {
    oProperty: {
        oDefault: '属性部分',
        oValue: {
            g: '全局变量',
            c: '常量',
            m: 'C++ 类成员变量',
            s: '静态变量'
        }
    },
    oType: {
        oDefault: '类型部分',
        oValue: {
            a: '数组',
            p: '指针',
            fn: '函数',
            v: '无效',
            h: '句柄',
            l: '长整型',
            i: '整型',
            cnt: "计数器",
            ch: '字符',
            o: '对象',
            s: '字符串',
            b: '布尔值',
            n: '数字',
            e: '枚举',
            u: '未知',
            r: '引用',
            f: '浮点型',
        }
    },
    oDescription: {
        oDefault: '描述部分',
        oValue: {
            Max: '最大值',
            Min: '最小值',
            Init: '初始值',
            Src: '源对象',
            Dest: '目标对象'
        }
    }
}
```

- 小驼峰命名法: 从第二个英文单词开始首字母进行大写处理, 如: styleData ( 样式数据 )
- 大驼峰命名法: 从首个英文单词开始大写, 如: StyleData ( 样式数据 )

---

## 3. 初次创建一个对象

- 这里举例为: 创建一个 IsAA 的类, 然后再 main 方法中创建一个类对象, 再在类对象中设置 name 和 age 属性

```java
package newObject;

public class IsAA{
    // Type Init
    String name;
    int age;

    public static void main(String[] args) {
        // 创建一个对象
        IsAA p = new IsAA();

        // 打印测试  这里因为没有给 name 和 age 赋值，所以会打印出的会是初始值 
        // name:String = null 和 age:int = 0
        System.out.println("My Name is " + p.name + ", I am " + p.age + " years old.");

        // 给 name 和 age 赋值
        p.name = "Tom";
        p.age = 18;

        // 打印测试
        System.out.println("My Name is " + p.name + ", I am " + p.age + " years old.");
       
    }
}
```

---

## 4. 成员方法定义

- 创建成员的 方法 和 定义方式

```java
package newObject;

public class MemberMethodsFirst {

    /**
     * 基本成员方法的 格式 和 定义方法
     * 返回值类型 方法名(参数类型 参数名, ..., 参数类型 参数名N) {
     *     方法体
     * }
     */

    String CreateFirst() {
        String sData = "Hello World";
        System.out.println("第一个成员方法");
        return sData;
    }


}
```

- 成员方法体主要用于编写描述该方法功能的语句块
- 成员方法可以实现代码的宠用, 进而简化代码, 减少书写量

## 5. 成员方法的调用

- 使用方法: 引用变量名.成员方法名称( 实参列表 )
- 实际参数可以传递: 变量、表达式、直接量、方法的调用...
- 实际参数列表主要用于对形式参数列表进行初始化操作, 因此参数的个数及它的类型, 包括顺序都要完全一致, 否则会出现报错.

```java
package newObject;

public class MemberConciseCode{

    // Style Init
    String name;
    int age;

    // 创建一个快速打印的方法, 传参顺序:
    // 1. sName 形参 String 类型
    // 2. iAge 形参 int 类型
    void oPrint(String sName, int iAge) {
        System.out.println("My Name is " + sName + ", I am " + iAge + " years old.");
    }

    // 当然像这种内部创建内部使用的方法也可以不传任何参数直接书写变量名
    void oPrintInCode() {
        System.out.println("My Name is " + name + ", I am " + age + " years old.");
    }

    public static void main(String[] args) {
        // 创建对象
        MemberConciseCode p = new MemberConciseCode();

        // 修改 name 和 age 的值
        p.name = "Tom";
        p.age = 18;

        // 调用方法, 进行打印测试
        p.oPrint(p.name, p.age);

        // 调用内部方法, 进行打印测试
        p.oPrintInCode();
    }

}
```

---

## 6. Person 类中可变长参数

- 可变长参数是指方法参数部分指定类型的参数个数是可以改变的 ( , 也就是说可以定义 0 ~ n 个 ) , 使用方式: 
  返回值类型 方法名 ( 参数的类型... 参数名 )
- 一个方法的形参列表中最多只能声明一个可变长形参, 并且需要放到参数列表的末尾

```java
void oName( AnyType... i ) {
    ClassBody
}
```

- 例如:

```java
package newObject;

public class CustomLength {

    void InString(String... oStr){
        for(int i = 0; i < oStr.length; i++){
            System.out.println("第 " + i +" 个参数的值为: " + oStr[i]);
        }
    }

    public static void main(String[] args) {
        CustomLength cl = new CustomLength();
        cl.InString("a", "b", "c");
    }

}
```

---

## 7. 参数传递的注意事项

- 基本数据类型的变量作为方法的参数传递时,  形参变量熟知的改变通常不会影响到实参变量的数值, 因为两个变量都有各自独立的内存空间

```java
package newObject;

public class IsMax {

    void getNums ( int i) {
        i = 200;
        System.out.println( "最终 i 为: " + i );
        System.out.println("---------- End ----------");
    }

    public static void main(String[] args){

        // Create Object
        IsMax oMax = new IsMax();

        // 测试引用变量是否会在调用方法时被替换掉
        int iNumA = 100;
        oMax.getNums(iNumA);
        System.out.println("运行结束后 iNumA 的结果： "+ iNumA);
        System.out.println("---------- End ----------"); 
    }
}

```

- 引用数据类型的变量作为方法的参数传递时, 形参变量指向内容的改变会影响到实参变量的指向内容的数值, 因为两个变量指向同一块内存空间

- 值的传递就是当参数是基本类型时, 传递参数的值, 如: int iI = 10; 真实传参时就会将参数 iI 赋值给形参, 当参数传递的是对象时, 传递的就是对象的值, 也就是说将对象的内存地址赋给了形参

---

## 8. 内存结构 ( 栈区 )

- 栈用于存放程序运行过程当中所有的局部变量, 一个运行的 Java 程序从开始到结束会有多次的方法调用

---

## 9. 构造方法

### 概念

#### 基本概念

- 构造方法名与类名完全相同并且没有返回值 !important; 包括空返回的 void

```java
public class oName {
    oName(Type fp1, ..., Type fpN){
        // Method Body
    }
}
```

#### 默认构造方法

- 当一个类中没有定义任何构造方法时, 编译器会自动添加一个无参空构造的构造方法, 这种构造方法就叫做: 默认构造方法 或是 缺省构造方法.
- 但若类中出现了构造方法, 则编译器不在提供任何形式的构造方法.

### 使用

- 在使用中创建的构造方法要与 class 类名统一, 具体格式如上, 请参考上方格式和下方案例

```java
public class ConstructionMethodFirst {
    
    String name;
    int age;

    // 这是一个构造方法
    public ConstructionMethodFirst() {
        
        System.out.println("This is the first construction method");

    }

    // 这是一个类方法
    void sayHello() {
        System.out.println("Hello, " + name + ", you are " + age + " years old this year.");
    }

    public static void main(String[] args) {

        // 创建类
        ConstructionMethodFirst oCMF = new ConstructionMethodFirst();

        // 输出类的属性
        oCMF.sayHello();
    }

}
```

### 构造方法作用

- 对内部进行一个最基础的书写, 如下

```java
public class ConstructionMethodFirst {
    
    String name;
    int age;

    // 这是一个构造方法
    public ConstructionMethodFirst() {
        
        // 这时我们给 name 和 age 赋初始值 ( init: Tom, 10 )
        name = "Tom";
        age = 10;

    }

    // 这是一个类方法
    void sayHello() {
        System.out.println("Hello, " + name + ", you are " + age + " years old this year.");
    }

    public static void main(String[] args) {

        // 创建类
        ConstructionMethodFirst oCMF = new ConstructionMethodFirst();

        // 输出类的属性
        oCMF.sayHello();
    }

}
```

- 使用 new 关键字创建对象时会自动调用构造方法实现成员变量初始化工作

```java
public class ConstructionMethodFirst {
    
    String name;
    int age;

    // 这是一个构造方法
    public ConstructionMethodFirst( String oName, int oAge ) {
        
		// 此处通过形参赋值的方式, 对齐附上不同的值
        name = oName;
        age = oAge;
    }

    // 这是一个类方法
    void sayHello() {
        System.out.println("Hello, " + name + ", you are " + age + " years old this year.");
    }

    public static void main(String[] args) {

        // 创建类; 并传入实参 - 01
        ConstructionMethodFirst oCMF = new ConstructionMethodFirst("Tom", 10);

        // 输出类的属性
        oCMF.sayHello();

        // 创建类; 并传入实参 - 02
        ConstructionMethodFirst oCMF2 = new ConstructionMethodFirst("Jerry", 20);

        // 输出类的属性
        oCMF2.sayHello();
    }

}
```

### 测试

- 编程实现: XXX 类的定义, 并向 XXX 类中添加构造方法
  - 为 XXX 类默认创建原点对象
  - 为 XXX 类创建 ( int i, int j ) 方法, 根据参数创建对象

```java
public class CMTQ {
    /** 
     * todo: ( ConstructionMethodTestQuestions )
     * 编程实现: 该类的定义, 并向该类中添加构造方法
     *   1. 该类默认创建原点对象
     *   2. 该类拥有 ( int i, int j ) 的构造方法, 根据参数创建对象
     */

    //  此处创建两个 int 类型的对象
    int oX, oY;

    // 此处创建一个无参的构造方法
    public CMTQ() {}

    // 此处创建一个形参为 ( int i, int j ) 的构造方法
    public CMTQ( int i, int j ) {

        // 此处为对象赋值
        oX = i;
        oY = j;

    }

    // 此处创建一个方法, 用于输出坐标属性
    void oLog() {
        System.out.println("X: " + oX + " \nY: " + oY);
        System.out.println("=========== End ==========");
    }

    public static void main(String[] args) {
        
        // 开始创建对象 ( 无参 )
        CMTQ oCmtq1 = new CMTQ();

        // 输出对象的值
        oCmtq1.oLog();


        // 开始创建对象 ( 有参 )
        CMTQ oCmtq2 = new CMTQ( 10, 20 );

        // 输出对象的值
        oCmtq2.oLog();
    }
}

```

---

## 10. 方法重载的概念

- 方法重载 ( Overload ) :若方法名称相同, 参数列表不同, 这样的方法之间构成重载关系.

- 方法重载主要体现在: 参数的个数、参数的类型、参数的顺序 不同, 它与形参变量名称 和 数据的返回值 无关!important, 但是为了更好的编译尽可能返回值的类型最好相同

``` java
public class Overload {
    
    void oFunc(){
        System.out.println("Is oFunc");
    }

    // 不会随着形参的数量而重载
    void oFunc(int i){
        System.out.println("Is oFunc: " + i);
    }

    // 不会随着形参的类型而重载
    void oFunc(int i, double d ){
        System.out.println("Is oFuncI: " + i + "oFuncD: " + d);
    }
    
    // 不会随着形参的顺序而重载
    void oFunc(double d, int i){
        System.out.println("Is oFuncD: " + d + "oFuncI: " + i);
    }

    /**
     * todo: 与 返回值类型 无关
     * ! Error: 不可以这么书写
     * int oFunc(int i, double d){
     *    System.out.println("Is oFuncI: " + i + "oFuncD: " + d);
     * }
     * 
     * todo: 与 形参的名称 无关
     * ! Error: 不可以这么书写
     * void oFunc(int j, double d){
     *   System.out.println("Is oFuncI: " + i + "oFuncD: " + d);
     * }
     */

    public static void main(String[] arsg) {

        // 创建一个对象
        Overload oOve = new Overload();

        // 调用方法
        oOve.oFunc(); //
        
        oOve.oFunc(666); // 不会随着形参的数量而重载

        oOve.oFunc(666, 3.14); // 不会随着形参的类型而重载

        oOve.oFunc(3.14, 666); // 不会随着形参的顺序而重载
    }

}

```

### 练习

- 编程实现为 XXX 类添加重载的成员方法:
  - oUp() 实现纵坐标 -1 的功能
  - oUp(int i) 实现纵坐标 -i 的功能

```java
public class OTQ {
    /**
     * todo: ( OverloadTestQuestions )
     * 编程实现为 XXX 类添加重载的成员方法:
     *   oUp() 实现纵坐标 -1 的功能
     *   oUp(int i) 实现纵坐标 -i 的功能
     */

    int oX;
    
    // 此处是为了避免报错而添加的空构造方法
    OTQ() {};

    // 此处给一个 int i 形参
    OTQ(int i) {
        // 默认构造方法
        oX = i;
    }

    void oUp() {
        oX--;
    }

    void oUp(int i) {
        oX -= i;
    }

    public static void main(String[] args) {
        
        // 创建一个对象
        OTQ oOve1 = new OTQ(109);
        oOve1.oUp(); // 此处调用的是 oUp() 无形参的方法
        System.out.println(oOve1.oX); // 108: 109 - (oX++)1

        oOve1.oUp(8); // 此处调用的是 oUp(int i) 有形参的方法
        System.out.println(oOve1.oX); // 16: 11 + i(8)

    }
}

```

---

## 11. this 的基本概念

- 如果 this 出现在构造方法中; 则这个 this 代表当前正在构造的对象
- 如果 this 出现在成员方法中; 则这个 this 代表当前正在调用的对象
- this 关键字本质上就是当前类类型的引用变量

```java
public class ThisDemo {

    // * 构造方法中的this
    ThisDemo(){
        System.out.println("This is: " + this);
        System.out.println("===== 构造方法中的this =====");
    }

    // ! ===== 构造方法中的this 结束 =====

    // * 成员方法中的this
    void oThis(){
        System.out.println("This is: " + this);
        System.out.println("===== 成员方法中的this =====");
    }

    // ! ===== 成员方法中的this 结束 =====

    public static void main(String[] args){

        // * 构造方法中的this
        ThisDemo oTD = new ThisDemo();
        System.out.println("Main 中的 oTD: " + oTD);

        // ! ===== 构造方法中的this 结束 =====

        // * 成员方法中的this
        oTD.oThis();
        // ! ===== 成员方法中的this 结束 =====

    }

}
```

- 当形参与实参变量名称相同时, 在方法体中会因为就近原则使用实参的内容, 这样的话就会导致形参给形参赋值, 与实参没有关系的情况

```java
public class Demo {
    
    String oName;
    
    Demo( String oName ) {
        // 因为就近原则, 离的最近的 oName 是 Demo( String oName ) 中的 oName
        // 所以这里会 形参 oName = 形参 oName
        // 与实际参数毫无干系...就实参没有任何改变
        oName = oName;
    }
    
    public static void main( String[] args ) {
        
        Demo oD = new Demo("测试代码");
        System.out.println(oName); // 输出为 null
        
    }
}
```

- 所以为了做出区分则会使用 this 关键字去做区分

```java
public class Demo {
    
    String oName;
    
    Demo( String oName ) {
        // 这里的 this 会区分出实参中 我的 oName 和 本次形参的 oName
        this.oName = oName;
    }
    
    public static void main( String[] args ) {
        
        Demo oD = new Demo("测试代码");
        System.out.println(oName); // 输出为 测试代码
        
    }
}
```

- 实际操作中尽可能使用相同的变量名称, 以此方便其他程序员的区分, 也更容易阅读: 

```java
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

```

- 在 Java 中 this 关键字除了调用成员 变量、方法 之外还可以作为返回值去使用

```java
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

```

- 在 Java 中 this 关键字除了以上的用法之外还能调取自身的方法, 如下:

```java
public class ThisUsageMethodThird {
    
    // 创建一个变量
    String oName;

    ThisUsageMethodThird() {

        // todo: 此处调用有参构造方法 ( ※ 注: 有无参构造方法中的 this() 语句都必须放在第一行 )
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
```

### 练习

- 编程实现: 求阶乘的方法
  - 使用递推方式进行累加
  - 使用递归的方式进行运算
    如: !3 => 3 * !2;
          !2 => 2 * !1;
          !1 => 1;

```java
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

```

