package src.bai1;

import java.util.Scanner;

public class NumberGenerator extends Thread {
    private volatile boolean running = true;
    private int number = 0;

    public void stopGenerating() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(number);
            number = (number + 1) % 101;
            try {
                Thread.sleep(500); // Sleep 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhấn Enter để bắt đầu quay số. Nhấn thêm lần nữa để dừng.");
        scanner.nextLine(); // Đợi người dùng nhấn Enter
        NumberGenerator generator = new NumberGenerator();
        generator.start();

        scanner.nextLine(); // Đợi người dùng nhấn Enter
        generator.stopGenerating();
        try {
            generator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Số đã quay: " + generator.number);
    }
}
