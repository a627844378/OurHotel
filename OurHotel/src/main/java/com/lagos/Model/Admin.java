package com.lagos.Model;

import java.io.Serializable;

public class Admin implements Serializable {
//    admin_id	int
//    admin_num	varchar
//    admin_password	varchar
    private Integer admin_id;
    private String admin_num;
    private String admin_password;

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_num() {
        return admin_num;
    }

    public void setAdmin_num(String admin_num) {
        this.admin_num = admin_num;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_num='" + admin_num + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
