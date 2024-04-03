package src.bai5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankSystem {
    private double balance;
    private Lock lock;

    public BankSystem(double initialBalance) {
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void withdraw(String accountHolder, double amount) {
        lock.lock(); // Lock đảm bảo chỉ có một luồng có thể truy cập vào balance cùng một lúc
        try {
            // Kiểm tra xem có đủ tiền trong tài khoản không
            if (balance >= amount) {
                // Thực hiện rút tiền
                System.out.println(accountHolder + " đang rút " + amount + " từ tài khoản.");
                balance -= amount;
                System.out.println("Rút tiền thành công. Số dư hiện tại: " + balance);
            } else {
                System.out.println(accountHolder + " không đủ tiền trong tài khoản để rút " + amount);
            }
        } finally {
            lock.unlock(); // Mở khóa sau khi đã thực hiện xong các thao tác
        }
    }

    public static void main(String[] args) {
        BankSystem bank = new BankSystem(5000); // Khởi tạo tài khoản với số dư ban đầu là 5000

        // Tạo các luồng tương ứng với các tài khoản
        Thread threadA = new Thread(() -> {
            bank.withdraw("Người A", 2000);
        });

        Thread threadB = new Thread(() -> {
            bank.withdraw("Người B", 4000);
        });

        // Bắt đầu thực hiện các luồng
        threadA.start();
        threadB.start();

        try {
            // Chờ cho các luồng kết thúc
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
