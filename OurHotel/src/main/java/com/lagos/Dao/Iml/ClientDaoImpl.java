package com.lagos.Dao.Iml;

import com.lagos.Dao.ClientDao;
import com.lagos.Model.Client;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class ClientDaoImpl implements ClientDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Client> findAll() {
        String sql = "select * from client";
        List<Client> clients = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class));
        return clients;
    }

    @Override
    public Client findByTelephone(String telephone) {
        String sql = "select * from client where client_telephone = ?";
        List<Client> client= template.query(sql, new BeanPropertyRowMapper<Client>(Client.class), telephone);
        if (client.size()>0){
            return client.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteClient(String telephone) {
        String sql = "delete from client where client_telephone = ?";
        try {
            if (template.update(sql, telephone)==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    @Override
    public boolean updateClient(Client client) {
        String sql = "update client set client_no = ?, client_name = ?, client_sex = ?, client_age = ?, client_address = ?, client_telephone = ?, client_password = ? where client_id = ? ";
        try {
            if(template.update(sql, client.getClient_no(), client.getClient_name(), client.getClient_sex(), client.getClient_age(), client.getClient_address(), client.getClient_telephone(), client.getClient_password(), client.getClient_id())==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    @Override
    public boolean addClient(Client client) {
        String sql = "insert into client(client_no, client_name, client_sex,client_age, client_address, client_telephone, client_password) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        try {
            if(template.update(sql, client.getClient_no(), client.getClient_name(), client.getClient_sex(), client.getClient_age(), client.getClient_address(), client.getClient_telephone(), client.getClient_password())==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
