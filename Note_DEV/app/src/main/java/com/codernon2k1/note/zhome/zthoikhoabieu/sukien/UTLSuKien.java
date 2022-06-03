package com.codernon2k1.note.zhome.zthoikhoabieu.sukien;

public class UTLSuKien {
    private int Id;
    private String name;
    private int day;
    private int month;
    private int year;
    private int gio ;
    private int phut;
    private int baothuc_gio;
    private int baothuc_phut;
    private int baothuc;
    private String Ndghichu;

    public UTLSuKien() {
    }

    public UTLSuKien(int id, String name, int day, int month, int year, int gio, int phut, int baothuc_gio, int baothuc_phut, int baothuc, String ndghichu) {
        Id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gio = gio;
        this.phut = phut;
        this.baothuc_gio = baothuc_gio;
        this.baothuc_phut = baothuc_phut;
        this.baothuc = baothuc;
        Ndghichu = ndghichu;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    public int getBaothuc_gio() {
        return baothuc_gio;
    }

    public void setBaothuc_gio(int baothuc_gio) {
        this.baothuc_gio = baothuc_gio;
    }

    public int getBaothuc_phut() {
        return baothuc_phut;
    }

    public void setBaothuc_phut(int baothuc_phut) {
        this.baothuc_phut = baothuc_phut;
    }

    public int getBaothuc() {
        return baothuc;
    }

    public void setBaothuc(int baothuc) {
        this.baothuc = baothuc;
    }

    public String getNdghichu() {
        return Ndghichu;
    }

    public void setNdghichu(String ndghichu) {
        Ndghichu = ndghichu;
    }
}
