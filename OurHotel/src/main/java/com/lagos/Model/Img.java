package com.lagos.Model;

import java.io.Serializable;

public class Img implements Serializable {
    private Integer img_id;
    private Integer room_id;
    private String img_name;

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    @Override
    public String toString() {
        return "Img{" +
                "img_id=" + img_id +
                ", room_id=" + room_id +
                ", img_name='" + img_name + '\'' +
                '}';
    }
}
