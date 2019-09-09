package com.lagos.Service.Iml;

import com.lagos.Dao.Iml.RoomHistoryDaoImpl;
import com.lagos.Dao.RoomHistoryDao;
import com.lagos.Model.HistoryRoom;
import com.lagos.Service.RoomHistoryService;

import java.util.List;

public class RoomHistoryServiceImpl implements RoomHistoryService {
    RoomHistoryDao roomHistoryDao=new RoomHistoryDaoImpl();
    @Override
    public boolean addRoomHistory(HistoryRoom historyRoom) {
        return roomHistoryDao.addRoomHistory(historyRoom);
    }

    @Override
    public List<HistoryRoom> findAllRoomHistory() {
        return roomHistoryDao.findAllRoomHistory();
    }

    @Override
    public List<HistoryRoom> findRoomHyByInf(String inf) {
        return roomHistoryDao.findRoomHyByInf(inf);
    }

    @Override
    public HistoryRoom generateHistoryRoom(Integer corder_id) {
        return roomHistoryDao.generateHistoryRoom(corder_id);
    }
}
