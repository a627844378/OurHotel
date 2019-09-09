package com.lagos.Model;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private Integer room_id;
    private String room_num;
    private String room_type;
    private Double room_price;
    private String room_status;
    private List<Img> room_imgId;
    private String room_describe;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_num() {
        return room_num;
    }

    public void setRoom_num(String room_num) {
        this.room_num = room_num;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Double room_price) {
        this.room_price = room_price;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public List<Img> getRoom_imgId() {
        return room_imgId;
    }

    public void setRoom_imgId(List<Img> room_imgId) {
        this.room_imgId = room_imgId;
    }

    public String getRoom_describe() {
        return room_describe;
    }

    public void setRoom_describe(String room_describe) {
        this.room_describe = room_describe;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", room_num='" + room_num + '\'' +
                ", room_type='" + room_type + '\'' +
                ", room_price=" + room_price +
                ", room_status='" + room_status + '\'' +
                ", room_imgId=" + room_imgId +
                ", room_describe='" + room_describe + '\'' +
                '}';
    }
}
