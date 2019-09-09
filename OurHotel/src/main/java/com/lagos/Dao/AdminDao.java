package com.lagos.Dao;


import com.lagos.Model.Admin;

public interface AdminDao {
    /**
     * 根据账号查询管理员
     * @param num
     * @return
     */
    public Admin findByNum(String num);
}
