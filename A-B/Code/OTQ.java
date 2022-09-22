public class OTQ {
    /**
     * todo: ( OverloadTestQuestions )
     * 编程实现为 XX X 类添加重载的成员方法:
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
