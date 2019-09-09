package cn.foreverhu.dao;

import com.lagos.Model.Corder;

import java.util.List;

public interface CorderDao {

    /**
     * 查询所有订单
     * @return
     */
    public List<Corder> findALl();

    /**
     * 根据电话查询订单
     * @param telephont
     * @return
     */
    public List<Corder> findByTelephone(String telephont);

    /**
     * 根据订单号删除订单
     * @param corder_id
     */
    public boolean deleteCorder(Integer corder_id);

    /**
     * 添加订单
     * @param corder
     */
    public boolean addCorder(Corder corder);

    /**
     * 修改订单
     * @param corder
     */
    public boolean updateCorder(Corder corder);
}
