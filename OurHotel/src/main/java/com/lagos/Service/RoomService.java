package com.lagos.Service;

import com.lagos.Model.Room;

import java.util.List;

public interface RoomService {
    /**
     * 查询所有空房间
     * @param room_num
     * @return
     */
    public List<Room> findAllEmptyRoom();

    /**
     * 查询空房间
     * @param room_num
     * @return
     */
    public Room findEmptyRoom();

    /**
     * 查询所有房间信息
     * @return
     */
    public List<Room> findAllRoom();

    /**
     * 修改房间状态
     * @return
     */
    public boolean updateRoomStatus(String room_num,String room_status);

    /**
     * 添加房间
     * @return
     */
    public boolean addRoom(Room room);

    /**
     * 修改房间信息
     * @param room
     * @return
     */
    public boolean updateroom(Room room);

    /**
     * 根据房间号删除房间
     * @param room_id
     * @return
     */
    public boolean deleteRoomById(Integer room_id);

    /**
     * 根据num查找房间
     * @param room_num
     * @return
     */
    public Room findRoomByNum(String room_num);

    public boolean updateRoomStatus2(String room_num, String room_status);


}
