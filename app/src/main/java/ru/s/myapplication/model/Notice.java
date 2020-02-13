package ru.s.myapplication.model;

public class Notice {

    private String title;
    private String description;
    private String address;
    private Double price;
    private int imageID;

    public Notice(String title, String description, String address, Double price, int imageID) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.price = price;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", imageID=" + imageID +
                '}';
    }

}
