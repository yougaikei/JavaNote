public class Narcissus {

    public static void main(String[] args) {
        
        // for 实现水仙花数
        for(int i = 100; i < 1000; i++) {
            
            // 取百位
            int a = i / 100;
            
            // 取十位
            int b = i / 10 % 10;
            
            // 取个位
            int c = i % 10;
            if(i == a*a*a + b*b*b + c*c*c) {
                System.out.println(i);
            }
        }
    }
}