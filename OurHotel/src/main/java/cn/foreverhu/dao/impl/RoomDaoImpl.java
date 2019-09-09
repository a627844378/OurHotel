package cn.foreverhu.dao.impl;

import cn.foreverhu.dao.RoomDao;
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
        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class), room_id);
        if (rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteRoomById(Integer room_id) {
        boolean flag = true;
        try {

            String sql = "delete from room where room_id = ?";
            template.update(sql, room_id);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateRoom(Room room) {
        boolean flag = true;
        try {
            String sql = "update room set room_num = ?, room_type = ?, room_price = ?, room_status = ?, room_describe = ? where room_id = ?";
            template.update(sql, room.getRoom_num(), room.getRoom_type(), room.getRoom_price(), room.getRoom_status(), room.getRoom_describe(), room.getRoom_id());

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean addRoom(Room room) {
        boolean flag = true;
        try {
            String sql = "insert into room(room_num, room_type, room_price, room_status, room_describe) " +
                    "values(?, ?, ?, ?, ?)";
            template.update(sql, room.getRoom_num(), room.getRoom_type(), room.getRoom_price(), room.getRoom_status(), room.getRoom_describe());

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;

    }

    @Override
    public List<Room> findByType(String room_type) {
        String sql = "select * from room where room_type = ? and room_status = 'N" +
                "'";
        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class), room_type);
        return rooms;
    }


    @Override
    public Room findByNum(String room_num) {
        String sql = "select * from room where room_num = ?";
        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class), room_num);
        if (rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;

    }

    @Override
    public boolean chageRoomStatus(Room room) {
        boolean flag = true;
        String sql = "update room set room_status = ? where room_id = ?";
        try {
            template.update(sql, room.getRoom_status(), room.getRoom_id());
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
