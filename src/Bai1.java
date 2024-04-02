import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a=0;
        double b=0;
        double c=0;
        try {
            System.out.println("nhập hệ số a: ");
            a = scanner.nextDouble();
            System.out.println("nhập hệ số b: ");
            b = scanner.nextDouble();
            System.out.println("nhập hệ số c: ");
            c = scanner.nextDouble();
        }catch (Exception e){
            System.out.println("Đầu vào không hợp lệ");
            System.exit(0);
        }

        double delta = sqrtDelta(a,b,c);

        if(delta == -1){
            System.out.println("Phương trình vô nghiệm");
        }else{
            System.out.println("căn delta của phương trình là: " + delta);
        }
    }

    private static double sqrtDelta(double a, double b, double c){
        double delta = b*b - 4*a*c;
        if(delta >= 0){
            return Math.sqrt(delta);
        }
        return -1;
    }
}
