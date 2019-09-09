package cn.foreverhu.service;

import com.lagos.Model.Client;

public interface ClientService {


    public boolean checkClientLogin(Client client);

    /**
     * 添加用户
     * @param client
     * @return
     */
    public boolean addClient(Client client);

    public Client findByTelephone(Client client);

    /**
     * 修改用户信息
     */
    public boolean updateClient(Client client);
}
