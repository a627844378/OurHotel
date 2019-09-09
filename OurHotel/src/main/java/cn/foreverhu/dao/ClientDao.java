package cn.foreverhu.dao;

import com.lagos.Model.Client;

import java.util.List;

public interface ClientDao {

    /**
     * 查询所有的客户
     * @return
     */
    public List<Client> findAll();

    /**
     * 根据账号（手机号）查询客户
     * @param telephone
     * @return
     */
    public Client findByTelephone(String telephone);

    /**
     * 根据账号删除客户
     * @param telephone
     */
    public boolean deleteClient(String telephone);

    /**
     * 修改客户信息
     * @param client
     */
    public boolean updateClient(Client client);

    /**
     * 添加客户
     * @param client
     */
    public boolean addClient(Client client);
}
