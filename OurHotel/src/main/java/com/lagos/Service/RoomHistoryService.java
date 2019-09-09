package com.lagos.Service;

import com.lagos.Model.HistoryRoom;

import java.util.List;

public interface RoomHistoryService {
    /**
     * 添加历史信息表
     * @param historyRoom
     * @return
     */
    public boolean addRoomHistory(HistoryRoom historyRoom);

    /**
     * 查询所有历史表信息
     * @return
     */
    public List<HistoryRoom> findAllRoomHistory();

    /**
     * 根据列名和信息查询历史表
     * @param client_telephone
     * @return
     */
    public List<HistoryRoom> findRoomHyByInf(String inf);

    /**
     * 根据电话号码生成历史表信息
     * @param client_telephone
     * @return
     */
    public HistoryRoom generateHistoryRoom(Integer corder_id);
}
