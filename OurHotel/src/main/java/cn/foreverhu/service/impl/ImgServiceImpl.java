package cn.foreverhu.service.impl;

import cn.foreverhu.dao.ImgDao;
import cn.foreverhu.dao.impl.ImgDaoImpl;
import cn.foreverhu.service.ImgService;
import com.lagos.Model.Img;
import com.lagos.Model.Room;

import java.util.List;

public class ImgServiceImpl implements ImgService {
    private ImgDao imgDao = new ImgDaoImpl();
    @Override
    public List<Img> findByRoomId(Room room) {
        List<Img> imgs = imgDao.findByRoomId(room.getRoom_id());
        return imgs;
    }
}
