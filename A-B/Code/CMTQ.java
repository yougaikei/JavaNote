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
