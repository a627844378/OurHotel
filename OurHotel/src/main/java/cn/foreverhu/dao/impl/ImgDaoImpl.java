package cn.foreverhu.dao.impl;

import cn.foreverhu.dao.ImgDao;
import com.lagos.Model.Img;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImgDaoImpl implements ImgDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Img> findByRoomId(Integer room_id) {
        String sql = "select * from img where room_id = ?";
        List<Img> imgs = template.query(sql, new BeanPropertyRowMapper<Img>(Img.class), room_id);
        return imgs;
    }

    @Override
    public boolean deleteImg(Integer img_id) {
        boolean flag = true;
        try {
            String sql = "delete from img where img_id = ?";
            template.update(sql, img_id);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateImg(Img img) {
        boolean flag = true;
        try {

            String sql = "update img set room_id=?, img_name=? where img_id = ?";
            template.update(sql, img.getRoom_id(), img.getImg_name(), img.getImg_id());
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean addImg(Img img) {
        boolean flag = true;
        try {

            String sql = "insert into img(room_id, img_name) values(?, ?) ";
            template.update(sql, img.getRoom_id(), img.getImg_name());
        } catch (Exception e) {
            flag = false;
        }
        return flag;

    }
}
