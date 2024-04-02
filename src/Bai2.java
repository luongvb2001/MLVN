import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số điện trong tháng: ");
        int a=0;
        try{
            a = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Đầu vào không hợp lệ");
            System.exit(0);
        }
        if(a<=0){
            System.out.println("Số điện được nhập phải lớn hơn 0");
            System.exit(0);
        }
        int donGia = tinhTien(a);
        System.out.println("Số tiền điện trong tháng: " + donGia);
    }

    private static int tinhTien(int a) {
        if (a <= 25){
            return a*1000;
        }
        if (a <= 75){
            return 25000 + (a-25)*1250;
        }
        if (a <= 150){
            return 87500 + (a-75)*1800;
        }
        return 222500 + (a-150)*2500;
    }
}
