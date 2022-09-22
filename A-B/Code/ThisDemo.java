public class ThisDemo {

    // * 构造方法中的this
    ThisDemo(){
        System.out.println("===== 构造方法中的this =====");
        System.out.println("This is: " + this);
        System.out.println("==========================");
    }

    // ! ===== 构造方法中的this 结束 =====

    // * 成员方法中的this
    void oThis(){
        System.out.println("===== 成员方法中的this =====");
        System.out.println("This is: " + this);
        System.out.println("==========================");
    }

    // ! ===== 成员方法中的this 结束 =====

    public static void main(String[] args){

        // * 构造方法中的this
        ThisDemo oTD = new ThisDemo();
        System.out.println("===== Main 方法中 =====");
        System.out.println("Main 中的 oTD: " + oTD);
        System.out.println("======================");

        // ! ===== 构造方法中的this 结束 =====

        // * 成员方法中的this
        oTD.oThis();
        // ! ===== 成员方法中的this 结束 =====

    }

}