package com.example.smellarduino;

public class MenuItem {
    private String name;
    private String imageUrl;
    private String scentString;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getScentString() {
        return scentString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setScentString(String scentString) {
        this.scentString = scentString;
    }
}
