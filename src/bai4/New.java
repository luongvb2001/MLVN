package bai4;


public class New implements INew{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    private int[] rateList;

    public New() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public void setRateList(int[] rateList) {
        this.rateList = rateList;
    }

    @Override
    public void calculate(){
        float sum = 0;
        for (int j : this.rateList) {
            sum = sum + j;
        }
        this.averageRate = sum/this.rateList.length;
    }

    @Override
    public void display() {
        System.out.println("Thông tin New: \n" + "Title: " + this.title
                + "\nPublishDate: " + this.publishDate
                + "\nAuthor: " + this.author
                + "\nContent: " + this.content
                + "\nAverageRate: " + this.averageRate
        );
    }
}
