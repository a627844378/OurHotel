package com.lagos.Dao.Iml;

import com.lagos.Dao.RoomDao;
import com.lagos.Model.Room;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoomDaoImpl implements RoomDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Room> findAll() {
        String sql = "select * from room";
        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class));
        return rooms;
    }

    @Override
    public List<Room> findAllNull() {
        String sql = "select * from room where room_status = 'N'";
        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class));
        return rooms;
    }

    @Override
    public Room findById(Integer room_id) {
        String sql = "select * from room where room_id = ?";
        List<Room> query = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class), room_id);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public Room findByNum(String room_num) {
        String sql="select * from room where room_num=?";
        List<Room> query = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class), room_num);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteRoomById(Integer room_id) {
        String sql = "delete from room where room_id = ?";
        try {
            if (template.update(sql, room_id)==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();

        return false;
        }
    }

    @Override
    public boolean updateRoom(Room room) {

        String sql = "update room set room_num = ?, room_type = ?, room_price = ?, room_status = ?, room_describe = ? where room_id = ?";
        try {
            if(template.update(sql, room.getRoom_num(), room.getRoom_type(), room.getRoom_price(), room.getRoom_status(), room.getRoom_describe(), room.getRoom_id())==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();

        return false;
        }
    }

    @Override
    public boolean addRoom(Room room) {
        String sql = "insert into room(room_num, room_type, room_price, room_status, room_describe) " +
                "values(?, ?, ?, ?, ?)";
        try {
            if(template.update(sql, room.getRoom_num(), room.getRoom_type(), room.getRoom_price(), room.getRoom_status(), room.getRoom_describe())==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();

        return false;
        }
    }

    @Override
    public boolean updateRoomStatus(String room_id, String room_status) {
        String sql="update room set room_status= ? where room_id= ?";
        try {
            if (template.update(sql, room_status, room_id)==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();

        return false;
        }
    }
    public boolean updateRoomStatus2(String room_num, String room_status) {
        String sql="update room set room_status= ? where room_num= ?";
        try {
            if (template.update(sql, room_status, room_num)==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
    }
}
