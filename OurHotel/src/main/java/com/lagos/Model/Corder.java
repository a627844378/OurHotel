package com.lagos.Model;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Date;

public class Corder implements Serializable {
    private Integer corder_id;
    private String client_telephone;
    private Integer room_id;
    private Date corder_st_date;
    private Date corder_ed_date;

    public Integer getCorder_id() {
        return corder_id;
    }

    public void setCorder_id(Integer corder_id) {
        this.corder_id = corder_id;
    }

    public String getClient_telephone() {
        return client_telephone;
    }

    public void setClient_telephone(String client_telephone) {
        this.client_telephone = client_telephone;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Date getCorder_st_date() {
        return corder_st_date;
    }

    public void setCorder_st_date(Date corder_st_date) {
        this.corder_st_date = corder_st_date;
    }

    public Date getCorder_ed_date() {
        return corder_ed_date;
    }

    public void setCorder_ed_date(Date corder_ed_date) {
        this.corder_ed_date = corder_ed_date;
    }

    @Override
    public String toString() {
        return "Corder{" +
                "corder_id=" + corder_id +
                ", client_telephone='" + client_telephone + '\'' +
                ", room_id=" + room_id +
                ", corder_st_date=" + corder_st_date +
                ", corder_ed_date=" + corder_ed_date +
                '}';
    }
}
