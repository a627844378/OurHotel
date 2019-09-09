package cn.foreverhu.dao.impl;

import cn.foreverhu.dao.CorderDao;
import com.lagos.Model.Corder;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
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
        boolean flag = true;
        try {
            String sql = "delete from corder where corder_id = ?";
            template.update(sql, corder_id);
        } catch (Exception e) {
            flag = false;
        }
        return flag;

    }

    @Override
    public boolean addCorder(Corder corder) {
        boolean flag = true;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "insert into corder(client_telephone, room_id, corder_st_date, corder_ed_date) " +
                    "values(?, ?, ?, ?)";
            template.update(sql, corder.getClient_telephone(), corder.getRoom_id(), format.format(corder.getCorder_st_date()), format.format(corder.getCorder_ed_date()));
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateCorder(Corder corder) {
        boolean flag = true;
        try {

            String sql = "update corder set client_telephone = ?, room_id = ?, corder_st_date = ?, corder_ed_date = ? where corder_id = ?";
            template.update(sql, corder.getClient_telephone(), corder.getRoom_id(), corder.getCorder_st_date(), corder.getCorder_ed_date(), corder.getCorder_id());
        } catch (Exception e) {
            flag = false;
        }
        return flag;

    }
}
