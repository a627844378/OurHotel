package cn.foreverhu.service;

import com.lagos.Model.Client;
import com.lagos.Model.Corder;

import java.util.List;

public interface CorderService {
    /**
     * 添加订单，向订单表添加信息
     * @param corder
     * @return
     */
    public boolean addCorder(Corder corder);

    /**
     * 查询用户的订单
     * @param client
     * @return
     */
    public List<Corder> findByTelephone(Client client);
}
