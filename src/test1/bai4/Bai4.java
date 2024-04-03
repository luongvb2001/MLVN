package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai4 {
    static List<INew> listNews = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    INew iNew;
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Menu: \n" +
                    "1 – Insert news\n" +
                    "2 – View list news\n " +
                    "3 – Average rate\n" +
                    "4 – Exit \n" +
                    "Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    avarageRate();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                    break;
            }

        }while (choice != 4);
    }

    public static void insertNews(){
        New news = new New();
        System.out.println("Nhập thông tin mới:");
        scanner.nextLine();
        System.out.println("Title: ");
        news.setTitle(scanner.nextLine());
        System.out.println("PublishDate: ");
        news.setPublishDate(scanner.nextLine());
        System.out.println("Author: ");
        news.setAuthor(scanner.nextLine());
        System.out.println("Content: ");
        news.setContent(scanner.nextLine());

        System.out.println("Nhập 3 đánh giá: ");
        int a[] = new int[3];
        for(int i=0; i<3; i++){
            a[i] = scanner.nextInt();
        }
        news.setRateList(a);

        listNews.add(news);
    }

    public static void viewListNews(){
        for (INew news: listNews) {
            news.display();
        }
    }

    public static void avarageRate(){
        for (INew news: listNews) {
            news.calculate();
            news.display();
        }
    }

}
