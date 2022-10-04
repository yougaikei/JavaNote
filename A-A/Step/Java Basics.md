# Java 语言基础

---

## 1. 初始计算机 和  Java 语言

---

### 1.1 计算机的基本概念

  计算机( Computer )俗称电脑，是现代一种用于高级计算，使用非常广泛的设备，主要由 <b><u>计算机硬件</u></b> 和 <b><u>计算机软件</u></b> 两个部分组成。

  计算机硬件是客观存在的各种计算机相关设备，而计算机的软件是用于控制各种硬件设备完成各种功能。

---

###  1.2 常见的主要硬件

  计算机硬件( Computer Hardware )主要包括：<u>中央处理器( CPU )、内存、硬盘、输入输出设备、主板、机箱以及电源等辅助设备</u>。

#### 1.2.1 CPU 的概述

- CPU
  - 中央处理器( Central Processing Unit )。
  - 计算机中最核心的部件，类似于人类的大脑。
  - 是计算机的 <b><u>运行核心</u></b> 和 <b><u>控制核心</u></b>，所有运算。
  - 功能主要是解释计算机指令以及处理计算机软件中的数据。

#### 1.2.2 内存的概述

- 内存
  - 内存是计算机中存储部件，内存( Memory )也被称为：<u>内存储器</u>。
  - 内存可用于暂时存放 CPU 中的运算数据，以及与硬盘等外部存储器交换的数据。
  - CPU 可以直接访问内存的数据，而且效率比较高。
  - 内存容量小，不能实现永久存储，一旦断电就会造成数据丢失。<strong><em>(Ps: 所以在书写代码时或是做其他工作时切记时刻进行保存！温馨提示：绝大多数快捷键：Ctrl + S 进行保存)</em></strong>。

#### 1.2.3 硬盘的概述

- 硬盘
  - 硬盘是计算机中的存储部件。
  - 主要用于<b style='color: rgba(255, 0, 0, 1);'>永久</b>存放数据内容，容量大且断电不会造成数据丢失。
  - CPU 不能直接访问硬盘中的数据，如果要访问的话则需要先加载到内存中。

#### 1.2.4 存储换算

  1TB = 1024GB

  1GB = 1024MB

  1MB = 1024KB

  1KB = 1024Byte( 字节 )

#### 1.2.5 输入输出设备

- 输出设备（如）：音箱、打印机、显示器...
- 输入设备（如）：键盘、鼠标、扫描仪...

---

  ### 1.3 常见的主要软件

  计算机软件( Computer Software )可分为 <b><u>系统软件</u></b> 和 <b><u>应用软件</u></b>，系统软件就是操作系统，是其他软件的基础。

  主流的操作系统：<u>Windows、Unix、Linux、IOS、Android</u>。

---

### 1.4 计算机的体系结构

  基础流程：Java 应用 ==> 操作系统外壳 ==> 操作系统内核 ==> 硬件

---

### 1.5 计算机语言的概述

  计算机语言是人与计算机之间交流的表达方式，该语言有很多种，如：<u>Java、HTML、JavaScript</u>。

  第一代语言：机器语言，以二进制代码方式存在，最开始是使用穿孔卡片进行打孔编译。

  第二代语言： 汇编语言，以使用助记符表示一条机器命令，如：<u>ADD、SUB 等</u>。

  第三代语言：<u>高级语言，Java、C、C++、Python、HTML、JavaScript 等</u>。

---

### 1.6 编译 Java 语言

#### 1.6.1 Java 语言的发展历史

  1995 年 Java 问世

  1996 年 Java 发布 1.0 版本

  1999 年 Java 发布 1.2 版本且分出了：Java SE、Java EE、Java ME

  2004 年 Tiger 发布 Java 5.0 版本，Java 登录火星

  2011 年 7 月 Oracle 公司正式发布 Java 7.0 版本

  2014 年 3 月 19 日 Oracle 公司发布 Java 8.0 的正式版本

  2017 年 9 月 21 日 Java 9.0 正式发布

  2018 年 9 月 25 日 Oracle 官方宣布 Java 11 正式发布

#### 1.6.2 Java SE ( 桌面应用 )

  Java SE ( Java Platform Standard Edition ) 称之为：“Java 平台标准版”，是 Java 平台的基础版。

  Java SE 包含了运行 Java 应用所需要的基础环境和核心类库。

  Java SE 还定义了基于桌面应用的基础类库，通过使用这些类库，我们可以编写出类似于 Office 那样的丰富多彩的桌面应用。

#### 1.6.3 Java EE ( 企业应用 )

  Java EE ( Java Platform Enterprise Edition) 称之为： “Java 平台企业版”。

  Java EE 构建在 Java SE 基础之上，用于构建企业级应用。所谓企业级应用，就是指那些为商业组织、大型企业而创建的应用系统，例如：移动、联通、电信的“计费系统”、各大银行的“网银系统”等。

#### 1.6.4 Java ME ( 移动应用 )

  Java ME ( Java Platform Micro Edition ) 称之为： “Java 平台微型版”。

  Java ME 可为机顶盒、移动电话和 PDA 等嵌入式消费电子设备提供 Java 解决方案。随着 3G、4G 移动只能平台时代的到来，特别是以 Java 为核心编程语言的 Android 智能平台的迅速普及，<em style='color:red;'><b><u>Java ME 已经走向淘汰</u></b></em>

#### 1.6.5 开发工具的 下载 和 安装

  下载方式：[http://www.sun.com](javascript:'void(0);')

  下载方式：[http://www.oracle.com](javascript:void(0);)

  具体地址：[(https://www.oracle.com/java/technologies/downloads/)](javascript:void(0);)

#### 1.6.6 JDK 的目录结构

  bin 目录：该目录下主要存放 JDK 的各种工具命令。

  conf 目录：该目录下主要存放 JDK 的相关配置文件。

  include 目录：该目录下主要存放了一些平台的头部文件。

  jmods 目录：该目录下主要存放了 JDK 的各种模块。

  legal 目录：该目录下主要存放了 JDK 各模块的授权文档。

  lib 目录：该目录下主要存放了 JDK 工具的一些补充 jar 包和源代码。

#### 1.6.7 相关概念

  JDK 称为：<u>Java 开发工具包 ( Java Development Kit )</u>。Java 开发人士需要下载和安装 JDK，目前的主流版本为 JDK11。

  JRE 称为：<u>Java SE 运行时环境 ( Java SE Runtime Environment)，提供了运行 Java 应用程序所必须的软件环境。无论是开发还是运行 Java 应用都必须安装。</u>

  javac.exe 是 <u>Java 编译器，主要用于将高级 Java 源代码翻译成字节码文件</u>。

  java.exe 是 <u>Java 解释器，主要用于启动 JVM 对字节码文件进行解释并执行</u>。

***※ 注：Java JVM 是指 Java Virtual Machine ( Java 虚拟机 )***

#### 1.6.8 JDK、JRE 和 JVM 之间的关系

  关系链：

​    Java 开发工具包 ( Java Development Kit ) ==>

​      1、编译器等开发工具 

​      2、Java 运行时环境 ( Java Runtime Environment ) ==>  

​        1、运行类库

​        2、Java 虚拟机 ( Java Virtual Machine )

---

### 1.7 Java 开发的常用工具

  文本编辑器（如）：记事本、Notepad++、Edit Plus、UItraEdit 等

  集成开发环境（如）：Jbuilder、NetBeans、Eclipse、MyEclipse、IDEA 等

#### 1.7.1 编写 Java 程序的流程（文本编辑器）

  1、新建文本文档，将文件扩展名修改为：Name.text => Name.java。

  2、使用 <b><u>记事本</u></b> 或 <b><u>Notepad++</u></b> 的方式打开，编写 Java 代码并进行保存。

  3、启动 cmd 管理器窗口，并使其路径在当前 Java 文件目录下。***※ 注：在 Name.java 目录下直接在地址栏书写 cmd 即可快速打开含有当前目录的 cmd 窗口***

  4、使用 <em><b>javac Name.java</b></em> 进行编译，会在同级目录下生成一个 <b>Name.class</b> 的字节码文件。

  5、使用 <em><b>java Name</b></em> 的方式进行解释并执行，会输出相应的结果。

#### 1.7.2 基础框架样式

```java
/*
 * 项目名称：
 * 项目功能：
 * 作   者：
 * 版   本：
 * 所 有 者：
 * 备   注：
 */
public class FileName{
    
}
```



#### 1.7.3 Hello World

```java
public class HelloWorld {
    public static void main(String[] args){
    	System.out.println("Hello World");
    }
}
```

#### 1.7.4 快捷键 和 注释

##### 1.7.4.1常用的快捷键

​    *注：C = Ctrl && S = Shift && W = Windows && A = Alt && T = Tab && D = Delete

​        1、保存：C + s

​        2、复制：C + c

​        3、粘贴：C + v

​        4、全选：C + a

​        5、剪切：C + x

​        6、撤销：C + z

​        7、搜索：C + f

​        8、切换输入法：C + S

​        9、中文中英文切换：S

​        10、切换至桌面：W + d

​        11、显示桌面：W + m

​        12、打开资源管理：W + e

​        13、锁屏：W + l

​        14、打开运行：W + r

​        15、切换任务窗口：A + T

​        16、切换桌面：W + T

​        17、启动任务管理器：C + A + D

##### 1.7.4.2 注释

  注释用于进行代码说明，是给程序员看的文字描述，编辑器会自动忽视注释。

``` java
// 单行注释：只限本行内书写注释

/*
 * 多行注释：
 * 从注释头到注释尾内可随意书写都在注释范畴内
 */

/**
 * 多行文本注释：
 * 与上方用法相同但是一种支持提取的注释。
 */
```

#### 1.7.5 环境变量的配置

- 基本概念
  - 通常情况下可执行文件只能在该文件所在的路径中使用，为了使这个可执行文件可以在任意路径中都能被正常执行或使用，则需要将该文件所在的路径信息配置到环境变量 Path 中。（ Src: 计算机( 此电脑 ) => 单击鼠标右侧 => 属性 => 高级系统设置 => 高级 => 环境变量 => 系统环境变量 ）

***※ 注意：配置完成后需要重启 dos 窗口。***

---

## 2. 变量 和 数据类型

---

### 2.1 变量的基本概念

- 当需要在程序中记录单个数据内容时，则声明一个变量即可，而变量的本质就是在内存中申请一个存储单元，由于该存储单元中的数据内容可以发生改变，因此得名：<b>变量</b>。
- 由于存放的数据内容大小不一样，导致所需存储单元的大小也不一样，在 Java 语言中使用数据类型加以描述，为了便于下次访问还需要给变量指定一个变量名，用于记录该变量对应的存储单元，类似于身份证。
- 使用方式：<i><u>dataType Name = Value;</u></i>

※ 注：上方的 Value 是变量的初始值，也可以省略不给。

#### 2.1.1 变量的注意事项

1. Java 是强类型语言，变量在使用前必须声明来指明变量的数据类型。
2. 变量在使用之前必须初始化。
3. 变量不可以被重复声名。
4. 变量名可以由数字、字母、下划线、$ 符组成，但不可以由数字打头。
5. 在命名的时候不能以 Java 语言的关键字，去进行命名，且变量名是严格区分大小写的。
6. 变量可以使用 kebab-case ( 烤肉串盒 ) 命名 或是 PascalCase ( 帕斯卡 ) 命名 也可以使用 camelCase ( 驼峰 )
   1. kebab-case ( 烤肉串盒 )：int demo_number = 1;
   2. PascalCase ( 帕斯卡 )：int DemoNumber = 1;
   3. camelCase ( 驼峰 )：int demoNumber = 1;
7. 变量名可以使用见名知义的英文单词去进行命名，如上方的 ：测试数字 ( demo number )；且在 Java 语言中支持中文变量，但为了程序的稳定性和一致性不推荐使用。( 强行使用容易报错！ )

---

### 2.2 数据分类

- 通常情况下 Java 语言的数据分为两大类：

  1、基本数据类型：<i><u>byte、short、int、long、float、double、Boolean、char</u></i> ( 共计 8 个 )

  2、引用数据类型：<b><u>数组、类、接口、枚举、标注</u></b> ( 共计 5 个 )

---

### 2.3 进制之间的转换

#### 2.3.1 常用的进制

- 在生活中采用的是十进制，逢十进一，十进制的权重：10 ^ 0、10 ^ 1、...
- 在计算的底层采用的是二进制，逢二进一，二进制的权重：2 ^ 0、2 ^ 1、...
- 二进制中的最高位( 最左边 )用于代表符号位，若该位是 0 则表示非负数，若该位是 1 则表示负数。
- 八进制和十六进制本质上都是二进制的简写。

#### 2.3.2 进制转换 ( 十 => 二 )

##### 2.3.2.1 进制转换( +10 => 2)

- 区分：可在当前进制的数字前面加：0B (Or 0b)；如：0B1010

```Typora
1、可以使用除二取余法:
	目标数字除以 2 直到除到 0;再将余数倒置过来
	如：(33)
        33 / 2 = 16 - 1
        16 / 2 = 8 - 0
        8 / 2 = 4 - 0
        4 / 2 = 2 - 0
        2 / 2 = 1 - 0
        1 / 2 = 0 - 1
	从下往上看，其结果为：0B 10 0001
	
2、可以使用权重位数法：
	使用 2 的倍数进行从左到右的列举
	 10   9   8   7   6  5  4 3 2 1 0(倍)
	1024 512 256 128 64 32 16 8 4 2 1
	如：(43)
		43 = 32 + 8 + 2 + 1
		带入
		32 16 8 4 2 1
		1  0  1 0 1 1
	从位数上可以看出，其结果为：0B 10 1011
	
```



##### 2.3.2.2  进制转换( -10 => 2)

```Typora
※ 使用上面两种方法中的任意一种后，再进行以下操作
   1、示例使用第 2 种方法 如：[ -70 ]
       64 32 16 8 4 2 1
        1  0  0 0 1 1 0
    结果：0100 0110
    再执行取反 和 +1
    取反：1011 1001
    加法：1011 1010
    -70 转 二进制 的最终结果为：1011 1010

```



#### 2.3.3 进制转换 ( 二 => 十 )

##### 2.3.3.1 进制转换( +2 => 10)

```Typora
1、权重位数法反向运算
	如：( 0b 0011 1100 )
		128 64 32 16 8 4 2 1
		 0   0  1  1 1 1 0 0
		 X = 0 + 0 +32 + 16 + 8 + 4 +0 + 0
		 X = 60
```



##### 2.3.3.2 进制转换( -2 => 10)

```Typora
1、此处需要反向运算
	如：- 1001 1100
	先减法( -1 )：- 1001 1011
	再取反：0110 0100
	
	权重法计算
	128 64 32 16 8 4 2 1
	  0  1  1  0 0 1 0 0
	
	X = 64 + 32 + 4
	
	X 结果：100
	
	∵ 二进制为负数
	∴ 十进制也为负数：-100
```



##### 2.3.3.3 八位二进制 <u><span style='color: red'>最大</span></u> 和 <u><span style='color: blue'>最小</span></u> 表示范畴

- 在计算机中单个字节表示八位二进制位，其中最高位代表符号位，使用 0 代表 非负数，使用 1 代表 负数，具体表示的整数范围如下。

- 非负数范围：0000 0000 ~ 0111 1111

  转换结果为：0 ~127 也就是：0 ~ 2 ** 7 - 1（2 的 7 次方）

- 负数范围：1000 0000 ~ 1111 1111

  转换结果：-128 ~ -1 也就是： -2 ** 7 ~ -2 ** 0

- 最终范围：-2 ** 7 ~ 2 ** 7 - 1 也就是：-128 ~ 127 （128 - 1 是指在计算机中 0 也算是一位）

####  2.3.4 进制转换 ( 十 => 八 )

- 区分：可在当前进制的数字前面加：0

#### 2.3.6 进制转换 ( 十 => 十六 )

- 区分：可在当前进制的数字前面加：0X ( Or 0x )；如：0XA

---

### 2.4 整数类型的概念

- 在 Java 语言中描述证书数据的类型由：<u>byte、short、int、long</u>，但推荐使用 <b><i><u>int</u></i></b> 类型。
- 其中 byte 类型在内存空间中占 1 个字节，表示范围是：-2 ** 7 ~ 2 ** 7 - 1 (-128 ~ 127 )
- 而 short 类型在内存空间中占 2 个字节，表示范围：-2 ** 15 ~ 2 ** 15 - 1 ( -3 2768 ~ 3 2767 )
- 再其次 int 类型 在内存空间中占 4 个字符，表示范围：-2 ** 31 ~ 2 ** 31 - 1 ( -21 4748 3648 ~ 21 4748 3647 )
- 在不够还可以使用 long 类型，它在内存中占 8 个字节，表示范围：-2 ** 63 ~ 2 ** 63 - 1 ( -922 3372 0368 5477 5808 ~ 922 3372 0368 5477 5807 )
- 在 Java 程序中直接写出的整数数据叫做：<u><b>直接量</b>、<b>字面值</b>、 <b>常量</b></u> ，默认为 int 类型，如希望表达更大的直接量或字面值、常量时，可以直接在后面加上 L (当然小写的也可以 l ，但不推使用，建议使用大写 L)。

---

### 2.5 浮点类型的概念

- 在 Java 语言中用于描述小数数据的类型：<u><i>float</i></u> 和 <u><i>double</i></u> ，推荐使用 <u><i>double</i></u> 类型。
- 其中 <u><i>float</i></u> 类型在内存空间占 4 个字节，叫做单精度浮点数，可以表示 7 位有效数字，范围：-3.403E38 ~ 3.403E38。
- 而 <u><i>double</i></u> 类型在内存空间占 8 个字节，叫做双精度浮点数，可以表示 15 位有效数字，范围：-1.798E308 ~ 1.798E308。
- 在 Java 语言程序中直接写出的小数数据叫做直接量，默认为：double 类型，如希望表达 float 类型的直接量，则需要在直接量后面加上 F 或是 f ( 建议都是用大写的字符，便于阅读 )。
- ※ 注：E 在科学计数法中代表的是 10 的 X 次方，如：3.403E38 此时表示的是 10 的 38 次方。
- ※ 注意：<span style='color: rgb(255, 0, 0)'>在商业或需要做到及其精确的地方请不要使用上方的两种类型，因为它们在运算时可能会有误差，导致直接或间接的损失</span>！但要想实现精确运算可以使用：<code>java.math.BigDecimal</code> 类型

---

### 2.6 布尔类型的概念

- 在 Java 语言中用于描述真假信息类型用 boolean 类型，数值只有：true 和 false。
- 布尔类型在内存空间中所占大小没有明确的规定，可以认为是 1 个字节。

---

### 2.7 字符类型的概念

- 在 Java 语言中用于描述单个字符的数据类型：char 类型，如：'你', '1', 'D' 等。
- 其中 char 类型在内存中空间中占 2 个字节，并且没有符号位，表示范围：0 ~ 65535，由于现实生活中很少有数据能够被单个字符描述，因此在以后实际开发中更多的使用由多个字符组成的字符串，使用 String 类型加以描述，如："Hello",  "我爱 Java"等...
- char 在 Java 中存储时没有符号位。

### 2.8 转义字符

- Java 字符类型采用 Unicode 字符集 编码。Unicode 是世界通用的定长字符集，所有的字符都是 16 位。
- 转义字符：\ 可以使用在：<code>\\" 或 \\' 再或是 \\\\ 也可以进行换行 \\n 制表 \\t</code> 等

---

### 2.9 自动类型转换的概念和作用

- Java 语言中基本数据类型之间的转换方式：自动类型转换 和 强制类型转换。
- 其中自动类型转换主要是指从小类型转换成大类型，这两者之间的抓换。

``` Typora
按类型：
byet => short => int => long => float => double
        char =>  ^
        
按字节：
1 字节 => 2 字节 => 4 字节 => 8 字节 => 4 字节 => 8 字节
         2 字节 => ^
```

- 而强制类型转换主要指从大类型到小类型之间的转换。

```Typora
目标类型 变量名 = (强制类型)源类型变量名;
```

- 强制转换会出现错误,如：

``` Typora
public class Names {
	
	public  static void main(String[] args) {
	
	byte b1 = 0;
	short b2 = 128;
	b1 = (byte)b2;
	System.out.println("b1 = " + b1);
	System.out.println("b2 = " + b2);
	
	}
}


/*
 * 最终打印结果为：
 *      b1 = -128
 *      b2 = 128
 * --------------------------------------------------
 * 说明：
 *      因为类型被强制转换后发生了：
 *          1. 将b2的值赋给b1
 *          2. 也就是：128 在存储时是一个short类型，而b1是一个byte类型，所以转换后，b1的值为-128
 *          3. 因为一个字节占 8 位，所以在转换的过程中，也就是16位转8位，此时从末端去后八位数字进行存储
 *          4. 过程：128: 0000 0000 1000 0000 => 1000 0000 此处最高位是符号位，1 是负数，0 是正数
 *          5. 在转换的过程中需要 -1，也就变成了 0111 1111  按位取反 1000 0000 => 128 加上负号 => -128
 */
```

---

### 2.10 总结

- 在使用以上变量的时候需要注意：在使用整数类型的时候在byte 类型、short 类型、int 类型、long 类型中优先选择 int 类型 ( 无特殊情况下 )
- 在使用以上变量的时候需要注意：在使用浮点数类型时，在 float 类型、double 类型 中优先选择 double 类型，有效位数 15位 且以现在的计算机存储能力来说仅相差 4 个字节。

---

## 3. 运算符

---

### 3.1 运算符的概念和使用

- 在 Java 运算中当两个整数相除时结果只保留整数部分，丢弃小数部分。

※ 如想要保留小数可以使用：

``` Typora
1、强制转换其中的一个数据，转换为 double 类型即可
    int a = 10;
    int b = 4;
    System.out.println("10 / 4 = " + (double)a / b);
    System.out.println("10 / 4 = " + a / (double)b);
    System.out.println("10 / 4 = " + (double)a / (double)b);
※ 一个即可，两个有点多余，只会加重代码量。

2、计算转换法，使其中第一个数字 * 1.0 即可
    int c = 12;
    int d = 5;
    System.out.println("12 / 5 = " + c * 1.0 / d);
```

- 0 不能做除数！

---

### 3.2 运算符

- 在 Java 语言中有 + ( 加 )、- ( 减 )、* ( 乘)、/ ( 除 )、% ( 取余 )

``` java
public class Operation {
    public static void main(String[] args) {
    //    int [a, b] = [10, 4]
        int a = 10;
        int b = 4;

    //    c = a + b
        int c = a + b;
    //    D = a - b
        int d = a - b;
    //    E = a * b
        int e = a * b;
    //    F = a / b
        int f = a / b;
    //    G = a % b
        int g = a % b;
        
    //    分辨打印结果中间使用分割符号
        System.out.println("10 + 4 = " + c);
        System.out.println("----------------------------");
        System.out.println("10 - 4 = " + d);
        System.out.println("----------------------------");
        System.out.println("10 * 4 = " + e);
        System.out.println("----------------------------");
        System.out.println("10 / 4 = " + f);
        System.out.println("----------------------------");
        System.out.println("10 % 4 = " + g);
        System.out.println("----------------------------");
        
    //    保留小数点后两位
        System.out.println("10 / 4 = " + (double)a / b);

    //    输出
        System.out.println("测试结果为：" + 12 / 5 * 1.0);

    }
}

```

---

### 3.3 关系运算符

- 在 Java 语言中有：< ( 小于 )、<= ( 小于等于 )、> ( 大于 )、>= ( 大于等于 )、== ( 相等 )、!= (  不等)

---

### 3.4 三元运算符

- 三元运算符又被称为: 条件运算符 或 三目运算符

- <u>条件表达式</u> ? <u>表达式1 ( true )</u> : <u>表达式 2 ( false )</u> 
- 判断条件表达式是否成立，成立则执行 <b>表达式 1</b> ，如果不成立则执行 <b>表达式 2</b> .

```java
package JavaDemo;

// 导入输入模块
import java.util.Scanner;

public class DemoA {
    public static void main(String[] args) {
        // 提示用户输入
        System.out.println("请输入两个正整数");
        // 创建输入模块使用
        Scanner sc = new Scanner(System.in);
        // Int: 同时设置 输入 A、B
        int oInputA = sc.nextInt(),
                oInputB = sc.nextInt();
		// 使用三元表达式比较大小
        int oMax = oInputA > oInputB ? oInputA : oInputB;
        System.out.println(oInputA+ " 和 " + oInputB + " 的最大值是: " + oMax);
    }
}

/**
 * @print:
 *     请输入两个正整数
 *     10 ( <= 输入示例值 )
 *     12 ( <= 输入示例值 )
 *     10 和 12 的最大值是 12
 */
```

---

### 3.5 赋值运算符

- 单个等号 ( = ) 在 Java 语言中表示赋值运算符，相当于把右侧数据赋值给左侧变量，且如果该变量已有值则覆盖原有数值。

- 复合运算符

  +=  加等于

  -=  减等于

  *=  乘等于

  /=  除等于

``` java
package JavaDemo;

public class DemoB {
    public static void main(String[] args){
        // int: 设置默认数值, 先创建 oA 再使用 oB = oA = 8 => oA = 8 => oB = oA (8) => oB = 8
        int oA,oB = oA =8;
        oA = oA + 2;
        oB += 2;
        System.out.println("oA 结果 " + oA);
        System.out.println("oB 结果 " + oB);
    }
}

/**
 * @print: 
 *     oA 结果 10
 *     oB 结果 10
 */
```

<p style="color: red;font-weight: bold;font-style: oblique;">※ 注意: 虽然结果一样但是处理过程是不一样的。</p>

---

### 3.6 移位运算符 ( <span style="color: red">了解</span> )

- << 左移位运算符，用于将数据的二进制位向左移动，而右侧则会使用 0 进行补位
- \>\> 右移位运算符，用于将数据的二进制位向右移动，而左侧则会使用符号位进行补位
- \>\>\> 表示逻辑右移运算符，用于将数据的二进制位向右移动，而左侧使用 0 进行补位。

``` java
package JavaDemo;

public class DemoC {
    public static void main(String[] args) {
        // @Type: byte
        // @Create: oA
        byte oA = 10;

        // @Prints: oA
        System.out.println("oA = " + oA);

        // @Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: oB
        // @Process: 左移位运算
        byte oB = (byte)(oA << 1);

        // @Prints: oB
        System.out.println("oB = " + oB);

        // @Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: oC
        // @Process: 左移位运算
        byte oC = (byte)(oA >> 1);

        // @Prints: oC
        System.out.println("oC = " + oC);

        // @Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: od
        // @Process: 左移位运算
        byte oD = (byte)(oA >>> 1);

        // @Prints: oD
        System.out.println("oD = " + oD);
    }
}

/**
 * @Print:
 *     oA = 10
 *     ----------------
 *     oB = 20
 *     ----------------
 *     oC = 5
 *     ----------------
 *     oD = 5
 *     ----------------
 */
```



---

### 3.7 位运算符 ( <span style="color: red">了解</span> )

- & 表示按位与运算符，按照二进制位进行与运算 { 全为 1 则是 1; 有一个 0 则为 0 }
- | 表示按位或运算符，按照二进制位进行或运算 { 全为 0 则是 0; 有一个 1 则是 1 }
- ~ 表示按位取反运算符，按照二进制位进行取反 { 1 转 0; 0 转 1 }
- ^ 表示按位异或运算符，按照二进制位进行异或运算 { 参与运算的两个数的二进制位相等则为 1; 不等则为 0 }

``` java
package JavaDemo;

public class DemoD {
    public static void main(String[] args){
        
        // @Type: byte
        // @Create: oA oB
        byte oA = 10;
        byte oB = 20;

        // @Type: byte
        // @Create: oC
        // @Process: 按位与运算符
        byte oC = (byte)(oA & oB);

        // @Prints: oC
        System.out.println("oA & oB " + oC);

        //@Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: oD
        // @Process: 按位或运算符
        byte oD = (byte)(oA | oB);

        // @Prints: oD
        System.out.println("oA | oB "+ oD);

        //@Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: oE oF
        // @Process: 按位或运算符
        byte oE = (byte)(~oA);
        byte oF = (byte)(~oB);

        // @Prints: oE oF
        System.out.println("~oA "+ oE);
        System.out.println("~oB "+ oF);

        //@Prints: 分割线
        System.out.println("----------------");

        // @Type: byte
        // @Create: oG
        // @Process: 按位或运算符
        byte oG = (byte)(oA ^ 20);

        // @Prints: oG
        System.out.println("oA ^ oB "+ oG);

    }
}

/**
 * @print:
 *     oA & oB 0
 *     ----------------
 *     oA | oB 30
 *     ----------------
 *     ~oA -11
 *     ~oB -21
 *     ----------------
 *     oA ^ oB 30
 */
```

#### 3.7.1 按位与运算符

``` java
package JavaDemo;

public class DemoE {
    public static void main(String[] args){
        // @Type: byte
        // @Create: oA oB oC
        byte oA = 10;
        byte oB = 20;

        /** @Process:
         *      计算结果:
         *          10: 0000 1010
         *          20: 0001 0100
         *          得: 0000 0000 => ( 二进制 ) => 0
         *
         *      计算器
         *          算: 0000 0000 => ( 二进制 ) => 0
         *
         *      Run:
         *          oA & oB 的结果是 0
         *
         */
        byte oC = (byte)(oA & oB);

        // @Prints: oC
        System.out.println("oA & oB 的结果是 " + oC);
    }
}

```

<p style="color: red;">※ 注意: 前后均需转为二进制后对位进行<u>且比较</u>，若有任意一方为 0 则按 0处理。</p>

#### 3.7.2 按位或运算符

```java
package JavaDemo;

public class DemoF {
    public static void main(String[] args){
        // @Type: byte
        // @Create: oA oB oC
        byte oA = 10;
        byte oB = 20;

        /** @Process:
         *      计算结果:
         *          10: 0000 1010
         *          20: 0001 0100
         *          得: 0001 1110 => ( 二进制 ) => 30
         *
         *      计算器
         *          算: 0001 1110 => ( 二进制 ) => 30
         *
         *      Run:
         *          oA | oB 的结果是 30
         *
         */
        byte oC = (byte)(oA | oB);

        // @Prints: oC
        System.out.println("oA | oB 的结果是 " + oC);
    }
}

```

<p style="color: red;">※ 注意: 前后均需转为二进制后对位进行<u>或比较</u>，若有任意一方为 1 则按 1处理。</p>

#### 3.7.3 按位取反运算符

```java
package JavaDemo;

public class DemoG {
    public static void main(String[] args){
        // @Type: byte
        // @Create: oA oB oC oD
        byte oA = 10;
        byte oB = 20;

        /** @Process:
         *      计算结果:
         *          10: 0000 1010
         *          反: 1111 0101
         *          由于符号位是 1 则为负数，负数转十进制 => -1 => 取反 => 转换 => 加负号
         *          减: 1111 0100
         *          反: 0000 1011
         *          转: 128 64 32 16 08 04 02 01
         *               0  0  0  0  1  0  1  1
         *               8 + 2 + 1 = 11
         *          负: -11
         *
         *      Run:
         *          ~oA 的结果是 -11
         *
         */
        byte oC = (byte)(~oA);

        /** @Process:
         *      计算结果:
         *          20: 0001 0100
         *          反: 1110 1011
         *          由于符号位是 1 则为负数，负数转十进制 => -1 => 取反 => 转换 => 加负号
         *          减: 1110 1010
         *          反: 0001 0101
         *          转: 128 64 32 16 08 04 02 01
         *               0  0  0  1  0  1  0  1
         *               16 + 4 + 1 = 21
         *          负: -21
         *
         *      Run:
         *          ~oB 的结果是 -21
         *
         */
        byte oD = (byte)(~oB);

        // @Prints: oC oD
        System.out.println("~oA 的结果是 " + oC);
        System.out.println("~oB 的结果是 " + oD);
    }
}

```

<p style="color: red;">※ 注意: 前后均需转为二进制后对位进行<u>或比较</u>，若有任意一方为 1 则按 1处理。</p>

#### 3.7.4按位异或运算符

```java
package JavaDemo;

public class DemoH {
    public static void main(String[] args){
        // @Type: byte
        // @Create: oA oB oC
        byte oA = 10;
        byte oB = 20;

        /** @Process:
         *      计算结果:
         *          10: 0000 1010
         *          20: 0001 0100
         *          得: 0001 1110 => ( 二进制 ) => 30
         *
         *      计算器
         *          算: 0001 1110 => ( 二进制 ) => 30
         *
         *      Run:
         *          oA ^ oB 的结果是 30
         *
         */
        byte oC = (byte)(oA ^ oB);

        // @Prints: oC
        System.out.println("oA ^ oB 的结果是 " + oC);
    }
}

```

<p style="color: red;">※ 注意: 前后均需转为二进制后对位进行<u>异或比较</u>，相同为 0，不同则视为 1。</p>

---

### 3.8 运算符的优先级

- 运算符优先级
  1. []中括号

     .fun()

  2. ! 非 

     ~ 按位取反

     ++ 加加

     --  减减

     \- 一元运算 ( 负号 )

     \+ 一元运算 ( 正号 )

  3. \* 乘法

     / 除法

     % 取余

  4. \+ 加法

     \- 减法

  5. << 左移运算符

     \>\> 右移运算符

     \>\>\> 逻辑右移运算符

  6. \> 大于

     \< 小于

     \>= 大于等于

     <= 小于等于

     instanceof

  7. == 相等

     != 不等

  8. & 按位与运算符

  9. ^ 按位取反运算符

  10. | 按位或运算符

  11. && 逻辑与运算符

  12. || 逻辑或运算符

  13. a ? a : b 三元运算符
  
  14. = 赋值运算符
  
- 运算符规则

  - 小括号的优先级最高
  - 等号的优先级最低
  - 如无法确认优先级，则可以使用小括号进行运算提升

---

## 4. 流程控制语句

---

### 4.1 if 判断语句

- 对 if 中的内容进行判断如果为 真 ( true ) 则会执行内部代码，否则不执行

```java
// 上方语句
if("条件语句"){
    // true 执行语句
}
// 下方语句
```

---

### 4.2  if...else... 流程判断语句

- 对 if 中的内容进行判断，若为 真 ( true ) 则会执行内部代码,若为 假 ( false ) 则会执行 else 中的代码块

``` java
// 上方语句

if("条件语句"){
    // true 执行语句
}else{
    // false 执行语句
}

// 下方语句
```

---

### 4.3 if...else if...else... 多重判断语句

- 相较于以上的流程判断语句,新增了更多的可能性，如果 if 中的语句为 假 ( false ) 则会继续下一层的判断, 直到某一个 else if 为 真 ( true ) 或 全部为 假 ( false ) 时执行 else 中的代码块

```
// 上方语句

if("条件语句 1"){
	// 语句1 为 true 时执行的语句
}else if("条件语句 2"){
	// 语句2 为 true 时执行的语句
}else if("条件语句 N"){
	// 语句N 为 true 时执行的语句
}else{
	// 以上全不成立时执行的语句
}

// 下方语句
```

---

### 4.4 swich 条件分支语句

- switch 中支持的类型有: byte, short, char, int ;但从 JDK 1.5 开始支持枚举类型，从 JDK 1.7 开始支持 String 类型

``` java
// 上方语句

swich("条件语句"){
    case "判断语句1":
    	// 执行语句
    	break; //进行结束
    case "判断语句2"
        // 执行语句
    	break; //进行结束
    case "判断语句N"
        // 执行语句
    	break; //进行结束
    default:
    	// 如以上都没有被匹配成功 则会执行 default 语句中的代码块
    	break; // 最后的 default 中的 break 可以省略不写，因为已经执行到最后一条语句了
}

// 下方语句
```

---

### 4.5 for 循环

- 对 for 内的语句进行指定次数的循环

``` java
// 上方语句

for(设置初始值; 条件语句; 初始值递增( 减 )){
    // 重复执行语句
}

//下方语句
```

---

### 4.6 continue 关键字

- continue 语句用在循环体中，用于结束本次循环，直接跳出本次执行下一次循环

``` java
// 上方语句

for(设置初始值; 条件语句; 初始值递增( 减 )){
    // 重复执行语句
    
    if("判断条件"){
        // 结束本次循环
        continue;
    }
    
    // 重复执行语句
}

//下方语句
```

---

### 4.7 break 关键字

- break 用于结束循环体，直接退出当前执行体

```java
// 上方语句

// 设置无限制次数的 for 循环
for(;;){
    // 重复执行语句
    
    if("判断条件"){
        // 结束循环
        break;
    }
    
    // 重复执行语句
}

//下方语句
```

---

### 4.8 while 循环

- while 用于判断条件是否成立, 成立则执行循环体, 出成立则跳出

```java in note
while ( 条件 或 条件表达式 ) {
    循环体
}
```

---

### 4.9 for && while 对比

- while 和 for 循环完全可以互换, 但要注意: 在条件中是明确循环条件, 还是明确循环次数, 如果是 条件则选择 while, 而如果不是明确条件而是明确 次数 则选用 for 循环

---

### 4.10 do while 循环

- 先执行一次循环体再去判断是否达成条件, 达成则再次执行循环体, 否则不执行

```java
do {
    循环体
}while(条件)
```

---

## 5. 数组的应用

### 5.1 一维数组

#### 5.1.1 基本概念

- 当需要在 Java 程序中记录单个数据内容时, 则声明一个变量即可
- 当需要在 Java 程序中记录多个变量且类型相同的时候, 则声明一个一维数组, 一维数组本质上就是在内存空间中申请一段连续的存储单元
- 数组是相同数据类型的多个元素的容器, 元素按照现行顺序排列, 在 Java 语句中体现为一种引用数据类型

#### 5.1.2 声明方式

- 声明时: 数据类型[] 名称 = new 数据类型[长度]；
- 调用时候需要表明调用的具体位置, 且调用数组的 length 属性可以获取数组的长度

※ 注意: 下表是从 0 开始, 而长度不是

### 5.2 内存结构 ( 栈区 )

- 栈用来存放程序运行过程当中所有的局部变量, 一个运行的 Java 程序从开始到结束会有很多次变量的声明

### 5.3 内存结构 ( 堆区 )

- JVM 会在其内存空间中开辟一个称为 "" 的存储空间, 这部分空间用于存储使用 new 关键字创建的 <span style="color: red; text-decoration: underline; font-weight: bold;">数组</span> 和 <span style="color: red; text-decoration: underline; font-weight: bold;">对象</span> .

### 5.4 一维数组的优缺点

- 可以直接通过下标的方式访问指定位置的元素, 具有速度快的优势
- 数组要求所有元素的类型相同
- 数组要求内存空间连续, 并且长度确定就不能再被修改了
- 增加元素 和 删除元素 时可能移动大量元素, 效率低

### 5.5 数组工具类的概念

- java.util.Arrays 类可以实现对数组中元素的遍历、查找 和 排序 等...

- 使用 Arrays.toString(oArr) 的方式可以直接将一维数组的值打印出来

```java
import java.util.Arrays;
public class ImportArrFirst {
    
    public static void main(String[] args){

        // A. 声明一个数组; init: 5, 10, 15, 20, 25
        int[] oArr = {5, 10, 15, 20, 25};

        // B. 原始打印数组
        System.out.println("---------- 原始打印数组 ----------");
        System.out.print("[");
        for(int i = 0; i < oArr.length; i++){
            System.out.print(oArr[i] + (i == oArr.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        // C. 使用 Arrays.toString() 打印数组
        System.out.println("---------- Arrays.toString() ----------");
        System.out.println(Arrays.toString(oArr));
    }
    
}

```

- 使用 Arrays.fill( oArr, 填充内容) 对数组中的每一个元素进行填充

```java
import java.util.Arrays;
public class ImportArrSecond {
    
    public static void main(String[] args) {
        
        // 创建两个长度为 5 的数组
        int[] oArr1 = new int[5];
        int[] oArr2 = new int[5];

        System.out.println("=========== 基础赋值操作开始 ===========");
        // 数组 oArr1 赋值为 10
        for (int i = 0; i < oArr1.length; i++) {
            oArr1[i] = 10;
        }

        // 打印 oArr1 数组
        System.out.println("oArr1 数组的值为: " + Arrays.toString(oArr1));
        System.out.println("=========== 基础赋值操作结束 ===========");

        System.out.println("=========== 数组 fill 赋值开始 ===========");
        // 数组 oArr2 赋值为 20
        Arrays.fill(oArr2, 20);

        // 打印 oArr2 数组
        System.out.println("oArr2 数组的值为: " + Arrays.toString(oArr2));
        System.out.println("=========== 数组 fill 赋值结束 ===========");

    }
}

```

- 使用 Arrays.equals(oArr1, oArr2) 对两个数组进行比较, 要求: 内容相同、顺序相同

```java
import java.util.Arrays;
public class ImportArrThird {
    
    public static void main(String[] args){

        // 创建两个数组
        int[] oArr1 = new int[5];
        int[] oArr2 = new int[5];
        
        // 填充两个数组 10
        Arrays.fill(oArr1, 10);
        Arrays.fill(oArr2, 10);

        // 使用 Arrays.equals() 方法比较两个数组
        System.out.println("oArr1 和 oArr2 数组是否相等: " + (Arrays.equals(oArr1, oArr2)? "IsTrue": "IsFalse" ));
    }
}

// oArr1 和 oArr2 数组是否相等: IsTrue
```

- 使用 Arrays.sort(oArr) 对数组进行从小到大的排序
- 使用 Arrays.binarySearch(oArr, 查找内容)  对数组内容进行查找, 输出为下标

```java
import java.util.Arrays;
public class ImportArrFourthly {
    
    public static void main(String[] args) {
        int[] oArr = { 2, 3, 1, 4, 5, 9, 6, 8, 7 };
        System.out.println("------ 排序前的数组 ------");
        System.out.println(Arrays.toString(oArr));
        System.out.println("--------------------");

        // 使用 Arrays.sort() 方法对数组进行排序
        Arrays.sort(oArr);
        System.out.println("------ 排序后的数组 ------");
        System.out.println(Arrays.toString(oArr));
        System.out.println("--------------------");

        // 使用 Arrays.binarySearch() 方法查找元素
        System.out.println("元素 5 在数组中的下标位置为: " + Arrays.binarySearch(oArr, 5));
    }
}
// [2, 3, 1, 4, 5, 9, 6, 8, 7]
// [1, 2, 3, 4, 5, 6, 7, 8, 9]
// 元素 5 在数组中的下标位置为: 4
```

### 5.6 二维数组

- 在一维数组中调取指定位置的数据可以使用: oArr[下标]; 而在二维数组中需要使用: oArr[外层数组的下标]\[内层数组的下标]

```java
import java.util.Arrays;
public class ArrsQuared {
    
    public static void main(String[] args){
        int[] oArr = new int[5];

        int[][] oArrs = new int[5][5];

        Arrays.fill(oArr, 5);
        System.out.println("---------- 一维数组 ----------");
        System.out.println(Arrays.toString(oArr));

        for (int i = 0; i < oArrs.length; i++) {
            Arrays.fill(oArrs[i], i + 1);
        }

        System.out.println("---------- 二维数组 ----------");
        for (int i = 0; i < oArrs.length; i++) {
            System.out.println(Arrays.toString(oArrs[i]));
            System.out.println("=============================");
        }
    }
}

```

- 杨辉三角案例:

```java
import java.util.Arrays;
import java.util.Scanner;
public class ArrTriangle {
    
    public static void main(String[] args){
       
        System.out.println("请用户输入一个整数:");
        Scanner oSc = new Scanner(System.in);
        int iNum = oSc.nextInt();

        // 创建一个对应用户输入行数的数组, 二维数组处暂不声明
        int[][] oArrs = new int[iNum][];

        // 初始化二维数组
        for(int i = 0; i < iNum; i++){
            // 创建实体化
            oArrs[i] = new int[i+1];
        
            for(int j = 0; j < i + 1; j++){
                oArrs[i][j] = 0 == j || j == i ? 1 : oArrs[i-1][j-1] + oArrs[i-1][j];
            }
        }

        for(int i = 0; i < iNum; i++){
            System.out.println(Arrays.toString(oArrs[i]));
        }

        oSc.close();
    }
}

```



