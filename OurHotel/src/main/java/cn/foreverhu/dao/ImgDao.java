package cn.foreverhu.dao;

import com.lagos.Model.Img;

import java.util.List;

public interface ImgDao {
    /*
     * 根据房间号查询所有图片
     */
    public List<Img> findByRoomId(Integer room_id);

    /**
     * 根据图片id删除图片
     * @param img_id
     */
    public boolean deleteImg(Integer img_id);

    /**
     * 修该图片
     * @param img
     */
    public boolean updateImg(Img img);

    /**
     * 添加图片
     * @param img
     */
    public boolean addImg(Img img);
}
