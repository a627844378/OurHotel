package cn.foreverhu.service.impl;

import cn.foreverhu.dao.RoomDao;
import cn.foreverhu.dao.impl.RoomDaoImpl;
import cn.foreverhu.service.RoomService;
import com.lagos.Model.Room;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao = new RoomDaoImpl();

    /**
     * 根据房间类型查询房间
     * @param room
     * @return
     */
    @Override
    public List<Room> findByType(Room room) {
        return roomDao.findByType(room.getRoom_type());
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = roomDao.findAll();
        return rooms;
    }

    @Override
    public Room findByRoomId(Integer room_id) {
        Room room = roomDao.findById(room_id);
        return room;
    }

    @Override
    public boolean updateRoom(Room room) {
        boolean flag = roomDao.updateRoom(room);
        return flag;
    }

    @Override
    public List<Room> findAllNullRoom() {
        List<Room> rooms = roomDao.findAllNull();
        return rooms;
    }

    @Override
    public boolean chageRoomStatus(Room room) {
        return roomDao.chageRoomStatus(room);
    }
}
