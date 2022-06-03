package com.codernon2k1.note.sup.utl;

public class BaiViet {
    private Integer baivietId;

    private String id_user;

    private String time;

    private String img;

    private String status;

    private Integer liked;

    private Integer disliked;

    public BaiViet() {
    }

    public BaiViet(Integer baivietId, String id_user, String time, String img, String status, Integer liked, Integer disliked) {
        this.baivietId = baivietId;
        this.id_user = id_user;
        this.time = time;
        this.img = img;
        this.status = status;
        this.liked = liked;
        this.disliked = disliked;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBaivietId() {
        return baivietId;
    }

    public void setBaivietId(Integer baivietId) {
        this.baivietId = baivietId;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    public Integer getDisliked() {
        return disliked;
    }

    public void setDisliked(Integer disliked) {
        this.disliked = disliked;
    }
}
