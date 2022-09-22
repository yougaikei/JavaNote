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
