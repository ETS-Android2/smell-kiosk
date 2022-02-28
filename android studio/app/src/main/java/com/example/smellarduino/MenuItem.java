package com.example.smellarduino;

public class MenuItem {
    private String name;
    private String drawable;
    private String scentString;

    public MenuItem(String name, String drawable, String scentString) {
        this.name = name;
        this.drawable = drawable;
        this.scentString = scentString;
    }

    public String getName() {
        return name;
    }

    public String getDrawable() {
        return drawable;
    }

    public String getScentString() {
        return scentString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDrawable(String drawable) {
        this.drawable = drawable;
    }

    public void setScentString(String scentString) {
        this.scentString = scentString;
    }
}
