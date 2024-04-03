package bai3;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Square square = new Square();
        float canh = 0;
        System.out.println("Nhập độ dài cạnh: ");
        try{
            canh = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("Đầu vào không hợp lệ");
            System.exit(0);
        }
        if(canh<=0){
            System.out.println("Độ dài cạnh được nhập phải lớn hơn 0");
            System.exit(0);
        }

        square.setCanh(canh);
        // Hiển thị độ dài cạnh
        square.showCanh();
        // Hiển thị chu vi
        square.showChuvi();
        // Hiển thị diện tích
        square.showDientich();
        // Hiển thị tất cả thông tin trên
        square.showAll();
    }
}
