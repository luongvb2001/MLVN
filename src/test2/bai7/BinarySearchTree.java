package src.bai7;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insertNode(int data){
        root = insert(root,data);
    }

    private Node insert(Node root, int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(data > root.getData()){
            root.setRight(insert(root.getRight(), data));
        }

        if(data < root.getData()){
            root.setLeft(insert(root.getLeft(), data));
        }

        return root;
    }

    private Node search(Node root, int data) {
        if (root == null || root.getData() == data)
            return root;

        if (root.getData() < data)
            return search(root.getRight(), data);

        return search(root.getLeft(), data);
    }

    public boolean isNodePresent(int data) {
        Node result = search(root, data);
        return result != null;
    }
}
