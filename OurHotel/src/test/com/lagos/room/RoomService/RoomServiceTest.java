package com.lagos.room.RoomService;

import com.lagos.Model.Room;
import com.lagos.Service.Iml.RoomServiceImpl;
import com.lagos.Service.RoomService;
import org.junit.Test;

import java.util.List;

public class RoomServiceTest {
    RoomService roomService=new RoomServiceImpl();
    @Test
    public void testroomService(){
        Room room=new Room();
        room.setRoom_id(2);
        room.setRoom_num("2032332");
        room.setRoom_type("豪华");
        room.setRoom_price(901.0);
        room.setRoom_status("N");
        room.setRoom_describe("这是个好房间");
//        System.out.println(roomService.addRoom(room));
//        List<Room> allEmptyRoom = roomService.findAllEmptyRoom();
//        System.out.println(allEmptyRoom.size());
//        List<Room> allRoom = roomService.findAllRoom();
//        System.out.println(allRoom.size());
//        System.out.println(roomService.findEmptyRoom().getRoom_id());
//        System.out.println(roomService.updateRoomStatus("2019-9-1-0","Y"));
//        roomService.updateroom(room);
//        roomService.deleteRoomById(2);
    }
}
