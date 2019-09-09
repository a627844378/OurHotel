package cn.foreverhu.dao;

import com.lagos.Model.Room;

import java.util.List;

public interface RoomDao {
    /**
     * 查询所有房间
     */
    public List<Room> findAll();

    /**
     * 查询所有空房间
     * @return
     */
    public List<Room> findAllNull();

    /**
     * 根据房间号查询房间
     * @param room_id
     * @return
     */
    public Room findById(Integer room_id);

    /**
     * 根据房间号删除房间
     * @param room_id
     */
    public boolean deleteRoomById(Integer room_id);

    /**
     * 修改房间信息
     * @param room
     */
    public boolean updateRoom(Room room);

    /**
     * 添加房间
     * @param room
     */
    public boolean addRoom(Room room);

    /**
     * 根据房间类型查询房间
     * @param room_type
     * @return
     */
    public List<Room> findByType(String room_type);

    /**
     * 根据房间号查询房间
     * @param room_num
     * @return
     */
    public Room findByNum(String room_num);

    /**
     * 修改房间状态
     * @param room
     * @return
     */
    public boolean chageRoomStatus(Room room);
}
