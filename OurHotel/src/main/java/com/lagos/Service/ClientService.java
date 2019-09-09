package com.lagos.Service;

import com.lagos.Model.Client;

import java.util.List;

public interface ClientService {
    /**
     * 查看所有客户信息
     * @return
     */
    public List<Client> findAllClient();

    /**
     * 添加客户信息
     * @return
     */
    public boolean addClient(Client client);

    /**
     * 删除客户信息
     * @param client_telephone
     * @return
     */
    public boolean deleteClient(String client_telephone);

    /**
     * 修改客户信息
     * @param client
     * @return
     */
    public boolean updateClient(Client client);

    /**
     * 检查客户年龄
     * @param client_no
     * @return
     */
    public boolean checkClientAge(String client_no);

    /**
     * 根据电话号码查询client
     * @param client_telephone
     * @return
     */
    public Client findClientByTel(String client_telephone);
}
