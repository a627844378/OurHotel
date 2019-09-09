package cn.foreverhu.service.impl;

import cn.foreverhu.dao.ClientDao;
import cn.foreverhu.dao.impl.ClientDaoImpl;
import cn.foreverhu.service.ClientService;
import com.lagos.Model.Client;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();
    @Override
    public boolean checkClientLogin(Client client) {
        Client client1 = clientDao.findByTelephone(client.getClient_telephone());
        if (client1 == null) {
            return false;
        }
        String username = client.getClient_telephone();
        String password = client.getClient_password();
        if (client1.getClient_telephone().equals(username) && client1.getClient_password().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addClient(Client client) {
        boolean flag = clientDao.addClient(client);

        return flag;
    }

    @Override
    public Client findByTelephone(Client client) {
        Client client1 = clientDao.findByTelephone(client.getClient_telephone());
        return client1;
    }

    @Override
    public boolean updateClient(Client client) {
        Client client1 = clientDao.findByTelephone(client.getClient_telephone());
        if (client1 == null) {
            return false;
        }
        boolean flag = clientDao.updateClient(client);
        return flag;
    }
}
