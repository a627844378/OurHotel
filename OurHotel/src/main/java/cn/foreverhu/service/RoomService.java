package cn.foreverhu.service;

import com.lagos.Model.Room;

import java.util.List;

public interface RoomService {

    /**
     * 根据房间类型查询房间
     */
    public List<Room> findByType(Room room);

    /**
     * 查询所有房间
     * @return
     */
    public List<Room> findAll();

    /**
     * 根据room_id查询房间
     */
    public Room findByRoomId(Integer room_id);

    /**
     * 修改房间信息
     */
    public boolean updateRoom(Room room);

    /**
     * 查询所有空房
     * @return
     */
    public List<Room> findAllNullRoom();

    /**
     * 改变入住状态
     * @param room
     * @return
     */
    public boolean chageRoomStatus(Room room);
}
