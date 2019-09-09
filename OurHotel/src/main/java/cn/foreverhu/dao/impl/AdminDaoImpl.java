package cn.foreverhu.dao.impl;

import cn.foreverhu.dao.AdminDao;
import com.lagos.Model.Admin;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据管理员账号查询管理员的信息
     * @param num
     * @return
     */
    @Override
    public Admin findByNum(String num) {
        String sql = "select * from admin where admin_num = ?";
        List<Admin> admins = template.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class), num);
        if (admins.size() > 0) {
            return admins.get(0);
        }
        return null;
    }
}
