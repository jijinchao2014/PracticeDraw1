package com.hencoder.hencoderpracticedraw1.practice;

public class VersionBean {
    public VersionBean(String name, float number) {
        this.name = name;
        this.number = number;
    }

    public VersionBean(String name, String simpleName, float number) {
        this.name = name;
        this.simpleName = simpleName;
        this.number = number;
    }

    public VersionBean(String name, String simpleName, float number, int color) {
        this.name = name;
        this.simpleName = simpleName;
        this.number = number;
        this.color = color;
    }

    public String name;
    public String simpleName;
    public float number;
    public int color;
    public boolean isChecked = false;
    public float realAngle; //对应扇形的角度
}
