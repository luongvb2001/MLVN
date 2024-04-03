package src.bai7;

public class Main {
    public static void main(String[] args) {
        // Tạo một cây nhị phân và thêm các phần tử
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);

        // Tìm kiếm một nút trong cây
        int keyToSearch = 60;
        if (tree.isNodePresent(keyToSearch)) {
            System.out.println("Nút " + keyToSearch + " tồn tại trong cây.");
        } else {
            System.out.println("Nút " + keyToSearch + " không tồn tại trong cây.");
        }
    }
}
