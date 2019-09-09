package cn.foreverhu.service;

import com.lagos.Model.Img;
import com.lagos.Model.Room;

import java.util.List;

public interface ImgService {

    public List<Img> findByRoomId(Room room);
}
