package com.lagos.Service;

import com.lagos.Model.Corder;

import java.util.List;

public interface CorderService {
    /**
     * 查看所有订单
     * @return
     */
    public List<Corder> findAllCorder();

    /**
     * 添加订单
     * @param id
     * @return
     */
    public boolean addCorder(Corder corder);

    /**
     * 根据对比时间删除无效订单
     * @return
     */
    public int deleteUseLessCorder();

    /**
     * 修改订单
     * @param id
     * @return
     */
    public boolean updateCorder(Corder corder);

    /**
     * 根据id删除订单
     * @param corder_id
     * @return
     */
    public boolean deleteCorder(Integer corder_id);

    /**
     * 根据电话号码查询所有订单
     * @param corder_telphone
     * @return
     */
    public List<Corder> findCorderByTel(String corder_telphone);

}
