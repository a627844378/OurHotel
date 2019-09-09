package com.lagos.Service.Iml;

import com.lagos.Dao.ClientDao;
import com.lagos.Dao.Iml.ClientDaoImpl;
import com.lagos.Model.Client;
import com.lagos.Service.ClientService;

import java.util.Calendar;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao clientDao=new ClientDaoImpl();
    @Override
    public List<Client> findAllClient() {
        return clientDao.findAll();
    }

    @Override
    public boolean addClient(Client client) {
        return clientDao.addClient(client);
    }

    @Override
    public boolean deleteClient(String client_telephone) {
        return clientDao.deleteClient(client_telephone);
    }

    @Override
    public boolean updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public boolean checkClientAge(String client_no) {
        //18位身份证验证
        if (client_no.length()==18){
            String c_year = client_no.substring(6, 10);
            Calendar date=Calendar.getInstance();
            int year = date.get(Calendar.YEAR);
            if (year-Integer.parseInt(c_year)>18){
                return true;
            }
        }
        return false;
    }

    @Override
    public Client findClientByTel(String client_telephone) {
        return clientDao.findByTelephone(client_telephone);
    }
}
