package com.lagos.Service.Iml;

import com.lagos.Dao.Iml.RoomDaoImpl;
import com.lagos.Dao.RoomDao;
import com.lagos.Model.Room;
import com.lagos.Service.RoomService;

import java.math.RoundingMode;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    RoomDao roomDao=new RoomDaoImpl();

    @Override
    public List<Room> findAllEmptyRoom() {
        List<Room> allEmptyRoom = roomDao.findAllNull();
        return allEmptyRoom;
    }

    @Override
    public Room findEmptyRoom() {
        List<Room> allEmptyRoom=this.findAllEmptyRoom();
        if (allEmptyRoom.size()>0){
            return allEmptyRoom.get(0);
        }
        return null;
    }

    @Override
    public List<Room> findAllRoom() {
        List<Room> allRoom=roomDao.findAll();
        return allRoom;
    }

    @Override
        public boolean updateRoomStatus(String room_num,String room_status) {
        return roomDao.updateRoomStatus(room_num,room_status);
    }

    @Override
    public boolean addRoom(Room room) {
       return roomDao.addRoom(room);
    }

    @Override
    public boolean updateroom(Room room) {
        return roomDao.updateRoom(room);
    }

    @Override
    public boolean deleteRoomById(Integer room_id) {
        return roomDao.deleteRoomById(room_id);
    }

    @Override
    public Room findRoomByNum(String room_num) {
        return  roomDao.findByNum(room_num);
    }

    @Override
    public boolean updateRoomStatus2(String room_num, String room_status) {
        return roomDao.updateRoomStatus2(room_num,room_status);
    }
}
