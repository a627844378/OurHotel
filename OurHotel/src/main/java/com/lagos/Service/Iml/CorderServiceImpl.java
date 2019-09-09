package com.lagos.Service.Iml;

import com.lagos.Dao.CorderDao;
import com.lagos.Dao.Iml.CorderDaoImpl;
import com.lagos.Dao.Iml.RoomHistoryDaoImpl;
import com.lagos.Dao.RoomHistoryDao;
import com.lagos.Model.Corder;
import com.lagos.Service.CorderService;

import java.util.List;

public class CorderServiceImpl implements CorderService {
    CorderDao corderDao=new CorderDaoImpl();
    @Override
    public List<Corder> findAllCorder() {
        return corderDao.findALl();
    }

    @Override
    public boolean addCorder(Corder corder) {
        return corderDao.addCorder(corder);
    }

    @Override
    public int deleteUseLessCorder() {
        List<Corder> aLl = corderDao.findALl();
        Long time=System.currentTimeMillis();
        RoomHistoryDao roomHistoryDao=new RoomHistoryDaoImpl();
        int count=0;
        for (Corder corder : aLl) {
            if (time>corder.getCorder_ed_date().getTime()){
               //根据id生成历史并添加历史表
                roomHistoryDao.addRoomHistory( roomHistoryDao.generateHistoryRoom(corder.getCorder_id()));
                if (corderDao.deleteCorder(corder.getCorder_id())){
                   count++;
               }
            }
        }
        return count;
    }

    @Override
    public boolean updateCorder(Corder corder) {
        return corderDao.updateCorder(corder);
    }

    @Override
    public boolean deleteCorder(Integer corder_id) {
        return corderDao.deleteCorder(corder_id);
    }

    @Override
    public List<Corder> findCorderByTel(String corder_telphone) {
        return corderDao.findByTelephone(corder_telphone);
    }

}
