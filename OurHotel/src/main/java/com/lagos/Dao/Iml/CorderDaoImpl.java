package com.lagos.Dao.Iml;

import com.lagos.Dao.CorderDao;
import com.lagos.Model.Corder;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CorderDaoImpl implements CorderDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Corder> findALl() {
        String sql = "select * from corder";
        List<Corder> corders = template.query(sql, new BeanPropertyRowMapper<Corder>(Corder.class));
        return corders;
    }

    @Override
    public List<Corder> findByTelephone(String telephone) {

        String sql = "select * from corder where client_telephone = ?";
        List<Corder> corders = template.query(sql, new BeanPropertyRowMapper<Corder>(Corder.class), telephone);

        return corders;
    }

    @Override
    public boolean deleteCorder(Integer corder_id) {
        String sql = "delete from corder where corder_id = ?";
        try {
            if(template.update(sql, corder_id)==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    @Override
    public boolean addCorder(Corder corder) {

        String sql = "insert into corder(client_telephone, room_id, corder_st_date, corder_ed_date) " +
                "values(?, ?, ?, ?)";
        try{
            if (template.update(sql, corder.getClient_telephone(), corder.getRoom_id(), corder.getCorder_st_date(), corder.getCorder_ed_date())==0||"".equals(corder.getClient_telephone())){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    @Override
    public boolean updateCorder(Corder corder) {
        String sql = "update corder set client_telephone = ?, room_id = ?, corder_st_date = ?, corder_ed_date = ? where corder_id = ?";
        try {
            if (template.update(sql, corder.getClient_telephone(), corder.getRoom_id(), corder.getCorder_st_date(), corder.getCorder_ed_date(), corder.getCorder_id())==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
}
