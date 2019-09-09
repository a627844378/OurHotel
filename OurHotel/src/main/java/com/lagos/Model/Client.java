package com.lagos.Model;

import java.io.Serializable;

public class Client implements Serializable {
    private Integer client_id;
    private String client_no;
    private String client_name;
    private String client_sex;
    private Integer client_age;
    private String client_address;
    private String client_telephone;
    private String client_password;

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
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

    public String getClient_sex() {
        return client_sex;
    }

    public void setClient_sex(String client_sex) {
        this.client_sex = client_sex;
    }

    public Integer getClient_age() {
        return client_age;
    }

    public void setClient_age(Integer client_age) {
        this.client_age = client_age;
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

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", client_no='" + client_no + '\'' +
                ", client_name='" + client_name + '\'' +
                ", client_sex='" + client_sex + '\'' +
                ", client_age=" + client_age +
                ", client_address='" + client_address + '\'' +
                ", client_telephone='" + client_telephone + '\'' +
                ", client_password='" + client_password + '\'' +
                '}';
    }
}
