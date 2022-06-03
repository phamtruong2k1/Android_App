package com.codernon2k1.note.zhome.zthoikhoabieu.sukien;

public class UTLLich {
    private int day,monyh,year,sukien;

    public UTLLich() {
        this.day = 0;
        this.monyh = 0;
        this.year = 0;
        this.sukien = 0;
    }

    public UTLLich(int day, int monyh, int year, int sukien) {
        this.day = day;
        this.monyh = monyh;
        this.year = year;
        this.sukien = sukien;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonyh() {
        return monyh;
    }

    public void setMonyh(int monyh) {
        this.monyh = monyh;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSukien() {
        return sukien;
    }

    public void setSukien(int sukien) {
        this.sukien = sukien;
    }
}
