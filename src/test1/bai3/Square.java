package bai3;

public class Square {
    private float canh;

    public float getCanh() {
        return canh;
    }

    public void setCanh(float canh) {
        this.canh = canh;
    }

    public void showCanh() {
        System.out.println("Độ dài cạnh hình vuông là: " + this.canh);
    }

    public void showChuvi() {
        System.out.println("Chu vi hình vuông là: " + 4*this.canh);
    }

    public void showDientich() {
        System.out.println("Chu vi hình vuông là: " + this.canh*this.canh);
    }

    public void showAll(){
        System.out.println("Độ dài cạnh hình vuông là: " + this.canh);
        System.out.println("Chu vi hình vuông là: " + 4*this.canh);
        System.out.println("Chu vi hình vuông là: " + this.canh*this.canh);
    }
}
