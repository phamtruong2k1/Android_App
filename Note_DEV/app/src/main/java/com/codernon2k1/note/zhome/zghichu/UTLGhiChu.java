package com.codernon2k1.note.zhome.zghichu;

public class UTLGhiChu {
    private int idghichu;
    private String noidungghichu;

    public UTLGhiChu() {
    }

    public UTLGhiChu(int idghichu, String noidungghichu) {
        this.idghichu = idghichu;
        this.noidungghichu = noidungghichu;
    }

    public int getIdghichu() {
        return idghichu;
    }

    public void setIdghichu(int idghichu) {
        this.idghichu = idghichu;
    }

    public String getNoidungghichu() {
        return noidungghichu;
    }

    public void setNoidungghichu(String noidungghichu) {
        this.noidungghichu = noidungghichu;
    }
}
