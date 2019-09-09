package com.lagos.Dao.Iml;

import com.lagos.Dao.RoomHistoryDao;
import com.lagos.Model.HistoryRoom;
import com.lagos.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoomHistoryDaoImpl implements RoomHistoryDao {
    //导入数据库连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean addRoomHistory(HistoryRoom historyRoom) {
        String sql="insert into roomHistory (room_num,room_type,room_price,client_no,client_name,client_address,client_telephone,corder_st_date,corder_ed_date) " +
                "values(?,?,?,?,?,?,?,?,?)";
        try {
            int update = template.update(sql, historyRoom.getRoom_num(), historyRoom.getRoom_type(),historyRoom.getRoom_price(), historyRoom.getClient_no(), historyRoom.getClient_name(), historyRoom.getClient_address(), historyRoom.getClient_telephone(), historyRoom.getCorder_st_date(), historyRoom.getCorder_ed_date());
            if (update==0){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    @Override
    public List<HistoryRoom> findAllRoomHistory() {
        String sql="select *from roomHistory";
        List<HistoryRoom> allRoomHistory = template.query(sql, new BeanPropertyRowMapper<HistoryRoom>(HistoryRoom.class));
        return allRoomHistory;
    }

    @Override
    public List<HistoryRoom> findRoomHyByInf(String inf) {
        String sql="select *from roomHistory where client_telephone=?";
        List<HistoryRoom> roomHy = template.query(sql, new BeanPropertyRowMapper<HistoryRoom>(HistoryRoom.class), inf);
        return roomHy;
    }

    @Override
    public HistoryRoom generateHistoryRoom(Integer corder_id) {
        String sql="SELECT room_num,room_type,room_price,client_no,client_name,client_address,client.client_telephone,corder_st_date,corder_ed_date " +
                "from corder JOIN client ON client.client_telephone=corder.client_telephone JOIN room on room.room_id=corder.room_id " +
                "WHERE corder_id=?";
        List<HistoryRoom> query = template.query(sql, new BeanPropertyRowMapper<HistoryRoom>(HistoryRoom.class), corder_id);
        if (query.size()>0){
            return query.get(0);
        }else {
            return null;
        }
    }
}
