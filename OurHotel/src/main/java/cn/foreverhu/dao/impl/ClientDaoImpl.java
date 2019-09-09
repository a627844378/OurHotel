package cn.foreverhu.dao.impl;

import cn.foreverhu.dao.ClientDao;
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
        List<Client> clients = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class), telephone);
        if (clients.size() == 0) {
            return null;
        }
        return clients.get(0);
    }

    @Override
    public boolean deleteClient(String telephone) {
        boolean flag = true;
        try {
            String sql = "delete from client where client_telephone = ?";
            template.update(sql, telephone);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateClient(Client client) {
        boolean flag = true;
        try {
            String sql = "update client set client_no = ?, client_name = ?, client_sex = ?, client_age = ?, client_address = ?, client_telephone = ?, client_password = ? where client_id = ? ";
            template.update(sql, client.getClient_no(), client.getClient_name(), client.getClient_sex(), client.getClient_age(), client.getClient_address(), client.getClient_telephone(), client.getClient_password(), client.getClient_id());

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean addClient(Client client) {
        boolean flag = true;
        try {
            String sql = "insert into client(client_no, client_name, client_sex,client_age, client_address, client_telephone, client_password) " +
                    "values(?, ?, ?, ?, ?, ?, ?)";
            template.update(sql, client.getClient_no(), client.getClient_name(), client.getClient_sex(), client.getClient_age(), client.getClient_address(), client.getClient_telephone(), client.getClient_password());

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
