package src.bai6;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankSystem {
    private double balance;

    private Lock lock;
    private final Object obj = new Object();

    public BankSystem(double initialBalance) {
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void withdraw(String accountHolder, double amount) {
        synchronized (obj) {
            // Kiểm tra xem có đủ tiền trong tài khoản không
            while (balance < amount) {
                try {
                    System.out.println(accountHolder + " đặt lệnh rút " + amount + ", nhưng số dư không đủ.");
                    obj.wait(); // Chờ đợi cho đến khi có đủ tiền trong tài khoản
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Thực hiện rút tiền
            lock.lock();
            try {
                balance -= amount;
                System.out.println(accountHolder + " đã rút " + amount + " từ tài khoản. Số dư hiện tại: " + balance);
            } finally {
                lock.unlock();
            }
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        synchronized (obj) {
            System.out.println("Nhập số tiền muốn nạp: ");
            balance += scanner.nextInt();
            System.out.println("Nạp tiền vào tài khoản. Số dư hiện tại: " + balance);
            obj.notifyAll(); // Thông báo cho các luồng đang chờ biết rằng có thể tiếp tục
        }
    }

    public static void main(String[] args) {
        BankSystem bank = new BankSystem(3000); // Khởi tạo tài khoản với số dư ban đầu là 1000
        System.out.println("Số dư hiện tại: " + bank.balance);

        // Tạo hai luồng đại diện cho việc rút tiền tự động
        Thread autoWithdrawThread1 = new Thread(() -> {
            bank.withdraw("Người vợ", 2000); // Người vợ muốn rút 2000
        });

        Thread autoWithdrawThread2 = new Thread(() -> {
            bank.withdraw("Người chồng", 3000); // Người chồng muốn rút 3000
        });

        // Bắt đầu luồng rút tiền tự động
        autoWithdrawThread1.start();
        autoWithdrawThread2.start();


        // Tạo một luồng đại diện cho việc nạp tiền vào tài khoản
        Thread depositThread = new Thread(bank::deposit);

        depositThread.start(); // Bắt đầu luồng nạp tiền

        try {
            // Chờ cho các luồng kết thúc
            autoWithdrawThread1.join();
            autoWithdrawThread2.join();
            depositThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
