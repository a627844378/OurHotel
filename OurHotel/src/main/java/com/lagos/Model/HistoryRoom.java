package com.lagos.Model;

import java.io.Serializable;
import java.util.Date;

public class HistoryRoom implements Serializable {
    private Integer roomhis_id;
    private String room_num;
    private String room_type;
    private String room_price;
    private String client_no;
    private String client_name;
    private String client_address;
    private String client_telephone;
    private Date corder_st_date;
    private String corder_ed_date;

    @Override
    public String toString() {
        return "HistoryRoom{" +
                "auto_increment=" + roomhis_id +
                ", room_num='" + room_num + '\'' +
                ", room_type='" + room_type + '\'' +
                ", room_price='" + room_price + '\'' +
                ", client_no='" + client_no + '\'' +
                ", client_name='" + client_name + '\'' +
                ", client_address='" + client_address + '\'' +
                ", client_telephone='" + client_telephone + '\'' +
                ", corder_st_date=" + corder_st_date +
                ", corder_ed_date='" + corder_ed_date + '\'' +
                '}';
    }

    public Integer getRoomhis_id() {
        return roomhis_id;
    }

    public void setRoomhis_id(Integer roomhis_id) {
        this.roomhis_id = roomhis_id;
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

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getClient_no() {
        return client_no;
    }

    public void setClient_no(String client_no) {
        this.client_no = client_no;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_telephone() {
        return client_telephone;
    }

    public void setClient_telephone(String client_telephone) {
        this.client_telephone = client_telephone;
    }

    public Date getCorder_st_date() {
        return corder_st_date;
    }

    public void setCorder_st_date(Date corder_st_date) {
        this.corder_st_date = corder_st_date;
    }

    public String getCorder_ed_date() {
        return corder_ed_date;
    }

    public void setCorder_ed_date(String corder_ed_date) {
        this.corder_ed_date = corder_ed_date;
    }
}
