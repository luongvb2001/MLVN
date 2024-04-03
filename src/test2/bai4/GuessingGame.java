package src.bai4;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame implements Runnable {
    private int userNumber;
    private int winnerThread;

    private static volatile boolean gameFinish = false;

    public GuessingGame(int userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public void run() {
        Random random = new Random();
        int guess;
        do {
            guess = random.nextInt(100) + 1;
            System.out.println(Thread.currentThread().getName() + ": Đoán " + guess);
            try {
                Thread.sleep(100); // Sleep 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!gameFinish && guess != userNumber);

        if (!gameFinish) {
            winnerThread = guess;
            gameFinish = true; // Đặt biến cờ khi luồng này kết thúc
        }

    }

    public int getWinnerThread() {
        return winnerThread;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;

        // Nhập số từ người dùng
        do {
            System.out.print("Nhập vào một số nguyên từ 1 đến 100: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập một số nguyên.");
                scanner.next();
            }
            userNumber = scanner.nextInt();
        } while (userNumber < 1 || userNumber > 100);

        // Tạo và khởi chạy hai thread
        GuessingGame guessingGame0 = new GuessingGame(userNumber);
        GuessingGame guessingGame1 = new GuessingGame(userNumber);
        Thread thread0 = new Thread(guessingGame0, "Thread 0");
        Thread thread1 = new Thread(guessingGame1, "Thread 1");
        thread0.start();
        thread1.start();

        try {
            // Chờ cho cả hai thread kết thúc
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In kết quả
        System.out.println("Người dùng đã nhập số " + userNumber + ".");
        System.out.println("Thread chiến thắng đã đoán đúng là " +
                (guessingGame0.getWinnerThread() == userNumber ? "Thread 0" : "Thread 1") + ".");
    }
}