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

- 

···

---

## 8. 内存结构 ( 栈区 )

- 栈用于存放程序运行过程当中所有的局部变量, 一个运行的 Java 程序从开始到结束会有多次的方法调用
