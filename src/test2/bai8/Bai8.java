package src.bai8;

import java.util.Arrays;
import java.util.LinkedList;

public class Bai8 {

    public static void main(String[] args) {

        // tạo 1 linked list
        LinkedList<String> list = new LinkedList<>(

                Arrays.asList("A", "B", "D", "E")

        );

        // hiển thị
        for(String val : list) {

            System.out.print(val + "\t");

        }
        // thêm vào cuối
        list.add("F");
        // thêm phần tử thứ 2
        list.add(2, "C");

        // hiển thị
        System.out.print("\nCác phần tử sau khi thêm\n");
        for(String val : list) {

            System.out.print(val + "\t");

        }

        // xóa phần tử đầu
        list.remove();
        // hiển thị
        System.out.print("\nCác phần tử sau khi xóa\n");
        for(String val : list) {

            System.out.print(val + "\t");

        }
        // xóa phần tử chỉ định
        list.remove("D");
        list.remove(2);
        System.out.print("\nCác phần tử sau khi xóa\n");
        for(String val : list) {

            System.out.print(val + "\t");

        }




    }

}
